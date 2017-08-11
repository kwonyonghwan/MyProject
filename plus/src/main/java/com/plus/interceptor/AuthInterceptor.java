package com.plus.interceptor;
//특정 경로에 접근하는경우 현재 사용자가 로그인한 상태의 사용자인지를 체크하는 역할을 처리한다. 
//로그인을 안했을 경우 로그인창으로 이동.

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	/*---- preHandle------현재 사용자가 로그인한 상태인지 체크 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null){  // 로그인 안했다면 '/member/login'으로 이동
			
			System.out.println("로그인 안 함");

			//response.sendRedirect("/member/loing");
			return false;
		}
		return true;
	}
	
}
