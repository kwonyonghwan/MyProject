package com.plus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("post Handle.....");

		HttpSession session = request.getSession();
		System.out.println(session.getId());
		System.out.println(session.getAttribute(LOGIN));
		
	/*	ModelMap modelMap = modelAndView.getModelMap();
		Object MemberDTO = modelMap.get("MemberDTO");
		

		if (MemberDTO != null) {
			session.setAttribute(LOGIN, MemberDTO);
			//response.sendRedirect("/");
		}
*/
	}// postHandle

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("pre hande............");

		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) != null){
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}

}// class
