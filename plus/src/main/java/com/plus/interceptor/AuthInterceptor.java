package com.plus.interceptor;
//Ư�� ��ο� �����ϴ°�� ���� ����ڰ� �α����� ������ ����������� üũ�ϴ� ������ ó���Ѵ�. 
//�α����� ������ ��� �α���â���� �̵�.

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	/*---- preHandle------���� ����ڰ� �α����� �������� üũ */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null){  // �α��� ���ߴٸ� '/member/login'���� �̵�
			
			System.out.println("�α��� �� ��");

			//response.sendRedirect("/member/loing");
			return false;
		}
		return true;
	}
	
}
