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
 * Admin controller 管理员请求相关类
 * 1.管理员登录(令牌方式)
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
	 * 管理员用户登录的处理方法
	 * @param username 用户名
	 * @param password 密码
	 * @return 格式:JSON 内容:登录失败返回false,登录成功返回token
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
			//登录成功
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
		//设置显示案列的页面
		mdv.setViewName("/internal/showcase");
		//返回
		return mdv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit() {
		//去到编辑页面
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/internal/fulleditor");
		return mdv;
	}
	
	@RequestMapping("/update")
	public ModelAndView toUpdate(Integer id) {
		ModelAndView mdv = new ModelAndView();
		if(id == null) {
			mdv.setViewName("/error");
			mdv.addObject("message", "没有id参数无法访问update页面");
		}
		//先通过id获取到案列内容
		Case case1;
		try {
			case1 = caseService.selectOneCaseById(id);
			mdv.addObject("case1", case1);
			mdv.setViewName("/internal/updatecase");
		} catch (Exception e) {
			mdv.setViewName("/error");
			mdv.addObject("message", "没有找到对应ID的案列,你的操作为非法操作!");
			e.printStackTrace();
		}
		
		return mdv;
	}
	
	@RequestMapping("/setcover")
	public ModelAndView setcoverpage(@RequestParam("id")Integer id) {
		ModelAndView mdv = new ModelAndView();
		if(id == null) {
			mdv.setViewName("/error");
			mdv.addObject("message", "没有id参数无法访问setcover页面");
		}
		//先通过id获取到案列内容
		Case case1;
		try {
			case1 = caseService.selectOneCaseById(id);
			mdv.addObject("case1", case1);
			mdv.setViewName("/internal/setcover");
		} catch (Exception e) {
			mdv.setViewName("/error");
			mdv.addObject("message", "没有找到对应ID的案列,你的操作为非法操作!");
			e.printStackTrace();
		}
		
		return mdv;
	}
	
	/**
	 * 后台进行操作时的转发操作,多个转发
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
