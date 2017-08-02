package org.ktl.interceptor;
//특정 경로에 접근하는경우 현재 사용자가 로그인한 상태의 사용자인지를 체크하는 역할을 처리한다. 
//로그인을 안했을 경우 로그인창으로 이동.

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ktl.domain.MemberVO;
import org.ktl.service.MemberService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	private MemberService service;
	
	//사용자가 원래 가려고 했던 URI를 저장했다가, 로그인 성공 후 원래의 URI로 이동시키는 작업
	private void savePath(HttpServletRequest req){
		
		// ex) product/Detail ? pno=3
		// uri에서 ? 앞 부분
		String uri = req.getRequestURI();
		
		// uri에서 ? 뒷 부분
		String query = req.getQueryString();
		
		if(query == null || query.equals("null")) {
			query="";
		}else{
			query = "?" + query;
		}
		if(req.getMethod().equals("GET")) {
			System.out.println("Path: " + (uri+query));
			req.getSession().setAttribute("path", uri + query);
		}
	}
	
	

	/*---- preHandle------현재 사용자가 로그인한 상태인지 체크 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null){  // 로그인 안했다면 '/member/login'으로 이동
			
			System.out.println("로그인 안 함");

			savePath(request);  //사용자가 원하는 uri를 HttpSession에 저장했다가
			
			/* 자동로그인 부분 */
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null){  //만약 이전에 보관한 쿠키가 있다면
				
				MemberVO mVo = service.checkLoginBefore(loginCookie.getValue()); // MemberService 객체를 이용해 사용자 정보가 존재하는지 확인한다. 
				System.out.println("MEMBERVO: " + mVo);
				
				if(mVo != null){  //만약 사용자 정보가 존재한다면 
					
					session.setAttribute("login", mVo);  //session에 사용자 정보를 다시 넣어준다.
					System.out.println("이 세션 값은 ??  " + session.getId() + session.getMaxInactiveInterval());
					
					
					return true;
				}
			}
			/* 자동로그인 부분 */
			response.sendRedirect("/member/login");  //로그인 성공 후 이 경로로 이동한다. 
			return false;
		}
		return true;
	}
	
}
