package com.cnbtl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cnbtl.entity.User;
import com.cnbtl.service.UserService;
import com.cnbtl.util.JsonResult;

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
	
}
