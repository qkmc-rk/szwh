package com.szwh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminPrivInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//»ñÈ¡session,ÅÐ¶ÏÊÇ·ñµÇÂ¼,µÇÂ¼·ÅÐÐ,Î´µÇÂ¼µ½µÇÂ¼Ò³Ãæ
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			modelAndView.clear();
			modelAndView.setViewName("/internal/nologin");
		}
			
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
