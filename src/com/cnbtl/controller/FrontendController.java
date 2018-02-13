package com.cnbtl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnbtl.entity.Case;
import com.cnbtl.service.CaseService;

/**
 * 控制前端页面的一些请求和转发
 * 因为需要做一些model的绑定,因此需要使用controller来进行.
 * @author Mrruan
 *
 */

@Controller
public class FrontendController {

	@Autowired
	CaseService caseService;
	
	/**
	 * 返回主页
	 * 主页需要有六个案列
	 * model 6个案列
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(Integer start, Integer end) {
		ModelAndView mdv = new ModelAndView();
		//1.获取6个案列
		if(start == null || end == null) {
			start = 0;
			end = 7;
		}
		List<Case> cases;
		try {
			cases = caseService.getAllCase();
			if(cases != null) {
				cases = cases.subList(0, 6);
				mdv.addObject("cases", cases);
				mdv.setViewName("/frontend/index");
			}else {
				mdv.addObject("message","主页获取案列时出现致命错误!索引为" + start + "-" + end);
				mdv.setViewName("/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mdv.addObject("message","主页获取案列时出现致命错误!索引为" + start + "-" + end);
			mdv.setViewName("/error");
		}
		//2.返回主页
		return mdv;
	}
	
	/**
	 * 返回服务页面,静态页面
	 * @return 静态服务视图的路径与名称
	 */
	@RequestMapping("/service")
	public String service() {
		return "/frontend/service";
	}
	
	/**
	 * 返回案列页面,此页面包含很多案列,需要
	 * 配合page分页食用
	 * @return 案列页面
	 */
	@RequestMapping("/article")
	public String article() {
		//获取分页的Page
		//将page装入model,返回
		return null;
	}
	
	@RequestMapping("/article_show")
	public ModelAndView article_show(@RequestParam("id") Integer id) {
		ModelAndView mdv = new ModelAndView();
		//1.通过id查询到案列
		List<Case> cases = caseService.getAllCase();
		Case case0,case1 = null,case2;
		//从list中获取指定id的记录.
		for (Case cs : cases) {
			if(cs.getId() == id) {
				case1 = cs;
				break;
			}
		}
		//从list中获取指定id的object的前一个.需要判断是否是第一个
		if(cases.indexOf(case1)-1 >= 0 && null != cases.get(cases.indexOf(case1) - 1) ) {
			case0 = cases.get(cases.indexOf(case1)-1);
		}else {
			case0 = null;
		}
		//从list中获取指定id的object的后一个,需要判断是否是最后一个
		if(cases.indexOf(case1)+1 < cases.size() && null != cases.get(cases.indexOf(case1) + 1) ) {
			case2 = cases.get(cases.indexOf(case1)+1);
		}else {
			case2 = null;
		}
		System.out.println(case0);
		System.out.println(case1);
		System.out.println(case2);
		//设置视图
		if(case1 != null) {
			mdv.addObject("case0", case0);
			mdv.addObject("case1", case1);
			mdv.addObject("case2", case2);
			mdv.setViewName("/frontend/article_show");
		}else {
			mdv.addObject("message", "获取指定Id=" + id +"的案列时出现错误!");
			mdv.setViewName("/error");
		}
		//2.返回视图
		return mdv;
	}
	
	/**
	 * 返回联系页面
	 * @return 联系视图的路径与名称
	 */
	@RequestMapping("/contact")
	public String contact() {
		return "/frontend/contact";
	}
	/**
	 * 返回关于页面
	 * @return 关于视图的路径与名称
	 */
	@RequestMapping("/about")
	public String about() {
		return "/frontend/about";
	}
	
}
