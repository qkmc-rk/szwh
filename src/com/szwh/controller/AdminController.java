package com.szwh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.szwh.entity.Case;
import com.szwh.entity.User;
import com.szwh.service.CaseService;
import com.szwh.service.UserService;
import com.szwh.util.JsonResult;

/**
 * Admin controller ����Ա���������
 * 1.����Ա��¼(���Ʒ�ʽ)
 * 
 * 
 * @author Mrruan
 *
 */

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	CaseService caseService;
	
	/**
	 * ����Ա�û���¼�Ĵ�����
	 * @param username �û���
	 * @param password ����
	 * @return ��ʽ:JSON ����:��¼ʧ�ܷ���false,��¼�ɹ�����token
	 */
	@RequestMapping(value="/adminlogin")
	@ResponseBody
	public String adminlogin(HttpSession session,@RequestParam String username,@RequestParam String password) {
		System.out.println("front-->" + username + "  " +password);
		User user = userService.login(username, password);
		System.out.println("db-->" + user);
		if(user == null) {
			return JsonResult.RS_FALSE;
		}else {
			//��¼�ɹ�
			session.setAttribute("user", user);
			return "{\"token\":\"" + user.getPassword() + "\"}";
		}
	}
	
	@RequestMapping("/logoff")
	public String logoff(HttpSession session) {
		session.removeAttribute("user");
		return "/internal/logoff";
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public ModelAndView main(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/internal/index");
		mdv.addObject("user", session.getAttribute("user"));
		return mdv;
	}
	
	@RequestMapping("/showcase")
	public ModelAndView showcase() {
		ModelAndView mdv = new ModelAndView();
		//������ʾ���е�ҳ��
		mdv.setViewName("/internal/showcase");
		//����
		return mdv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit() {
		//ȥ���༭ҳ��
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/internal/fulleditor");
		return mdv;
	}
	
	@RequestMapping("/update")
	public ModelAndView toUpdate(Integer id) {
		ModelAndView mdv = new ModelAndView();
		if(id == null) {
			mdv.setViewName("/error");
			mdv.addObject("message", "û��id�����޷�����updateҳ��");
		}
		//��ͨ��id��ȡ����������
		Case case1;
		try {
			case1 = caseService.selectOneCaseById(id);
			mdv.addObject("case1", case1);
			mdv.setViewName("/internal/updatecase");
		} catch (Exception e) {
			mdv.setViewName("/error");
			mdv.addObject("message", "û���ҵ���ӦID�İ���,��Ĳ���Ϊ�Ƿ�����!");
			e.printStackTrace();
		}
		
		return mdv;
	}
	
	@RequestMapping("/setcover")
	public ModelAndView setcoverpage(@RequestParam("id")Integer id) {
		ModelAndView mdv = new ModelAndView();
		if(id == null) {
			mdv.setViewName("/error");
			mdv.addObject("message", "û��id�����޷�����setcoverҳ��");
		}
		//��ͨ��id��ȡ����������
		Case case1;
		try {
			case1 = caseService.selectOneCaseById(id);
			mdv.addObject("case1", case1);
			mdv.setViewName("/internal/setcover");
		} catch (Exception e) {
			mdv.setViewName("/error");
			mdv.addObject("message", "û���ҵ���ӦID�İ���,��Ĳ���Ϊ�Ƿ�����!");
			e.printStackTrace();
		}
		
		return mdv;
	}
	
	/**
	 * ��̨���в���ʱ��ת������,���ת��
	 * @return
	 */
	@RequestMapping(value="/article_show",method=RequestMethod.GET)
	public String articleShow(Integer id) {return "forward:/article_show";}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String deleteCase(@PathVariable("id")Integer id) {return "forward:/case/delete/" + id;}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id")Integer id,
			@RequestParam("type") String type,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("origin") String origin,
			@RequestParam("click")Integer click) {
		
		return "forward:/case/update/" + id;
	}
}
