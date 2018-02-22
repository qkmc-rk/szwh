package com.cnbtl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cnbtl.service.CaseService;

public class ClickInteceptor implements HandlerInterceptor {

	@Autowired
	CaseService caseService;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//首先获取id
		String idstr = request.getParameter("id");
		Integer id = null;	
		if(idstr != null) {
			try {
				id = Integer.parseInt(idstr);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("值转换异常");
				return;
			}
			//使用caseService增加点击次数.
			Integer plusNum = 1;
			caseService.plusClick(id, plusNum);
			System.out.println("id:" + id + " click增加1");
		}

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	/**
	 * 当请求完成后增减点击次数 +1
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		return true;
	}

}
