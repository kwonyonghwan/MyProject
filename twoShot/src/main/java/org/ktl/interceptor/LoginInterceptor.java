package org.ktl.interceptor;
import javax.servlet.http.Cookie;
//로그인한 사용자에 대해 postHandle()을 이용해 HttppSession에 보관한다. 
//HttpSession에 관련된 모든 처리, '/loginPOST'로 접근. 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ktl.domain.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login"; //
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	

	
	/* ---- POSTHANDLE, MemberCont.에서 MemberVO라는 이름으로 객체를 담아둔 상태 -> HttpSession에 저장한다. ----  */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		MemberVO MemberVO = (MemberVO)modelMap.get("memberVO");
		
		if(MemberVO != null){
		
			logger.info(""+session.getAttribute(LOGIN));
			if(request.getParameter("useCookie") != null) {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());  //자동로그인을 위한 쿠키 생성. 키:(loginCookie) 값 : session에 저장된 id값.
				loginCookie.setPath("/");   //
				loginCookie.setMaxAge(60 * 60 * 24 * 7);  //일주일간 유지
				response.addCookie(loginCookie); //만들어진 쿠키는 HttpServletResponse에 담겨서 전송된다. 		
			}
			
			String path = (String)session.getAttribute("path");  //로그인 성공 후에 'path' 정보를 사용
			if(path.contains("recommend") == true){ // path에 recommend가 포함되어 있을 경우 맨 뒤에 MemberID를 붙여줘야 하기 때문에 
				path = path+ MemberVO.getMemberid();
			}
			response.sendRedirect(path != null ? path:"/product/productList");
			session.removeAttribute("path");
		}
		
	}
	
	
	/* ---- PREHANDLE, 기존 HttpSession에 남아있는 정보를 삭제 ----  */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) != null){
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}

}
