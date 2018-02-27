package com.szwh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.szwh.service.CaseService;

public class ClickInteceptor implements HandlerInterceptor {

	@Autowired
	CaseService caseService;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//���Ȼ�ȡid
		String idstr = request.getParameter("id");
		Integer id = null;	
		if(idstr != null) {
			try {
				id = Integer.parseInt(idstr);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("ֵת���쳣");
				return;
			}
			//ʹ��caseService���ӵ������.
			Integer plusNum = 1;
			caseService.plusClick(id, plusNum);
			System.out.println("id:" + id + " click����1");
		}

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	/**
	 * ��������ɺ������������ +1
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		return true;
	}

}
