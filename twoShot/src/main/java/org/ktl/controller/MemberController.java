package org.ktl.controller;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//7F14D77A87FC64EBE6EC7B9D0C078482
//7F14D77A87FC64EBE6EC7B9D0C078482

//3813899FD3D84415A908FB79362DEA52
//45773CFDFBECF8508445D7F585BC6959

import org.ktl.domain.MemberVO;
import org.ktl.domain.ShoppingCartVO;
import org.ktl.dto.LoginDTO;
import org.ktl.service.MemberService;
import org.ktl.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;
// 로그인, 회원가입, 마이페이지
@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private MemberService service;
	
	@Inject
	private ProductService pservice;
	
	/* ------ login, GET -------- */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto, HttpServletRequest request) {
		
		// AuthInterceptor에서 세션에 저장된 path가 없다면, /login을 호출한 페이지 주소를 세션에 저장한다.
		if(request.getSession().getAttribute("path") == null){
			String path = request.getHeader("referer");
			
			if(path !=null){
			System.out.println("ㅇㅇㅇㅇ" + path);
			String[] splitpath = path.split("/");
			String modpath =  "/";
			if(splitpath.length>3){
				System.err.println("/"+splitpath[3] +"/"+ splitpath[4]);
			    modpath = "/"+splitpath[3] +"/"+ splitpath[4];
					
			}
			request.getSession().setAttribute("path", modpath);
		}
		}
		
	}
	
	/* ------ login, POST -------- 로그인 결과처리하는곳*/
	@RequestMapping(value="/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
		
		logger.info("----------------------------------------------------------");
		logger.info("dto :"+dto);
		logger.info("session :" + session.getId());
		logger.info("model :" + model);
		MemberVO mVo = service.login(dto);  //입력된 아이디가 DB와 일치하는지 여부를 판단하는 부분
		logger.info("mVo :" + mVo);
		
		if(mVo == null) {  //로그인 안된 상태라면
			return ;  // 이경로로 이동!
		
		}//if
		
		// MemberVO mVo = (MemberVO)session.getAttribute("login");   다른 경로에서 호출시. 
		session.setAttribute("login", mVo);
		
//		System.out.println(" 여기!!!!!!!!!!!!! "+session.getId());
		
		
		model.addAttribute("memberVO", mVo);

		if(dto.isUseCookie()){  //사용자가 자동로그인을 선택한 경우 필요한 기능을 추가
			
			int amount = 60* 60*24*7; // loginCookie값이 유지디는 시간 정보를 DB에 저장한다. 
			
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
		
			service.keepLogin(mVo.getMemberid(), session.getId(), sessionLimit);
		}
		int amount = 60* 60*24*1;
		Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
		service.keepLogin(mVo.getMemberid(), session.getId(), sessionLimit);
		
		return ; //로그인이 되면(즉,id == pw)이면 이동할 경로.
	}//loginPOST


	
	/* ------ 로그아웃, GET -------- */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, 
						 HttpSession session) throws Exception{
		
		Object obj = session.getAttribute("login");
		
		if(obj != null){
			MemberVO mVo = (MemberVO)obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			
			if(loginCookie != null){
			
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);  //쿠키 식제
				
			response.addCookie(loginCookie);
			service.keepLogin(mVo.getMemberid(), session.getId(), new Date());
			
			}
		}
		return "redirect:/product/productList";
	}
	
	
	/*---- JOIN, GET------회원가입 페이지 보는곳*/
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void joinGET(MemberVO mVo, Model model) throws Exception {
		
		System.out.println("join GET............");
	}//joinGET
	

	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public void myPageGET(MemberVO mVo, Model model, HttpSession session ) throws Exception {
		
		System.out.println("mVO :" + mVo.toString());
		System.out.println();
		System.out.println("model :" + model.toString());
		MemberVO mVO;
		
		System.out.println(session.getId());
		
		mVO = service.checkLoginBefore(session.getId());
		
		System.out.println(mVO);
		
		model.addAttribute("mVO", mVO);
		
		System.out.println("myPage GET............");
	}//myPageGET



	
	/*---- JOIN, POST-----실제로 입력된 데이터 처리*/
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(MemberVO mVo, RedirectAttributes rttr) throws Exception {
		
		System.out.println("joinPOST.......	...");
		System.out.println(mVo.toString());
	

		service.join(mVo);
	
		rttr.addFlashAttribute("msg", "success");  // 숨김 데이터 전송
		//return "/member/success";
		
		return "redirect:/product/productList";    // 메인화면 생기면 메인으로! (지금은 없으니까 임의로 설정함.)	
	}  //joinPOST

	
	/*---- CartList, GET-----장바구니 목록*/
	@RequestMapping(value="/cartList", method=RequestMethod.GET)
	public String cartList(Model model, HttpSession session, LoginDTO dto, RedirectAttributes rttr) throws Exception {
		
		//로그인 정보를 담는다. 
		Object user= session.getAttribute("login");  //속성명이 "login"인 값을 Object타입으로 리턴한다. 
		
		MemberVO mVo = (MemberVO) user;
		System.out.println(mVo);

		if(mVo == null) {  //장바구니에 넣을 때 로그인 안된 상태라면
			
			rttr.addFlashAttribute("msg", "success");  //숨김 데이터 전송
			
			return "redirect:/member/login";  // 이경로로 이동!
		}  //그다음에 그전에 보던 페이지로 이동하도록 하는 부분 추가해야함.(AuthenticationSuccessHandler 인터페이스)
		
		String memberId=mVo.getMemberid();//mVo에 로그인한 회원에 대한 정보가 있다. 
		List<ShoppingCartVO> list=  service.cartList(memberId);//그 회원의 아이디에 해당하는 장바구니 목록을 가지고 온다. 
		
		System.out.println("여기!!!!!!!:" + list.toString());
		
		int totalAll=0;  //전체 금액 !!!
		
		for (ShoppingCartVO shoppingCartVO : list) { // 한 행에 대한 totalList를 가져온다.
	
			totalAll += shoppingCartVO.getProductTotalPrice();  //모든 ProductTotalPrice를 가져온다. 
		}
		model.addAttribute("total", totalAll); // 장바구니 목록 조회할때 cartList객체 가져오는 부분
		
		model.addAttribute("cart", list); // 장바구니 목록 조회할때 cartList객체 가져오는 부분. "cart"는 list 자체이다.
		//"cart"라는 이름으로 jsp에 보내준다.
		
		model.addAttribute("id" , memberId);   // model에 넣어준다.
		//"id"라는 이름으로 jsp에 보내준다.
		
		return "/member/cartList"; //로그인되면 이동할 경로 왜 리다이렉트 할까 .. 
	}
	

	/*---- PutCart, POST-----카트에 상품넣기*/
	@RequestMapping(value="/cartList", method = RequestMethod.POST)
	public String putCart(@ModelAttribute ShoppingCartVO cVo,
			LoginDTO dto, HttpSession session, RedirectAttributes rttr, HttpServletRequest request) throws Exception{
		
		
			//로그인 정보를 담는다. 
				Object user= session.getAttribute("login");  //속성명이 "login"인 값을 Object타입으로 리턴한다. 
				MemberVO mVo = (MemberVO) user;
				
				if(mVo == null) {  //장바구니에 넣을 때 로그인 안된 상태라면
					
					rttr.addFlashAttribute("msg", "success");  //숨김 데이터 전송
					
					return "redirect:/member/login";  // 이경로로 이동!
				}  //그다음에 그전에 보던 페이지로 이동하도록 하는 부분 추가해야함.(AuthenticationSuccessHandler 인터페이스)
				
				String memberId=mVo.getMemberid();//mVo에 로그인한 회원에 대한 정보가 있다. 

				System.out.println("로그인정보" + mVo);
				
				service.putCart(cVo);
				System.out.println("카트에 넣는다." + cVo);	
				
		return "redirect:/member/cartList";	//카트에 상품이 담기면 이 경로로 이동. 
	}
	
	
	
	
	
	/*---- REMOVECART, POST----- 카트 삭제*/
	@RequestMapping(value="/deleteCart", method=RequestMethod.POST)
	public String deleteCart(@ModelAttribute ShoppingCartVO cVo,RedirectAttributes rttr,@RequestParam("pno") int pno,HttpSession session,  
						   HttpServletRequest request,HttpServletResponse response) throws Exception {  //RequestParam Map
		
		//로그인 정보를 담는다. 
		Object user= session.getAttribute("login");  //속성명이 "login"인 값을 Object타입으로 리턴한다. 
		MemberVO mVo = (MemberVO) user;
		String memberId=mVo.getMemberid();//mVo에 로그인한 회원에 대한 정보가 있다. 
		
		System.out.println("삭제아이디 : " + memberId);
		
		System.out.println("cVO1 :" + cVo);  //null
		
		service.deleteCart(pno);
		
		rttr.addAttribute("msg", "SUCCESS");
		
		return "redirect:/member/cartList";
	}
	
	/*---- REMOVECARTAll, POST----- 카트 전체삭제 */
//	@RequestMapping(value="/deleteCartAll", method=RequestMethod.POST)
//	public String deleteCartAll(@RequestParam("pno") int pno, RedirectAttributes rttr) throws Exception { 
	
//		String[] pnoArr = request.getParameterValues("pno");
//		
//		for (String pno : pnoArr) {
//			System.out.println(pno);
//			
//			service.deleteCart(Integer.parseInt(pno));
//		}//for
//		
//		request.getRequestDispatcher("member/cartList").forward(request, response);
		
//	}
	
	/*---- PUT order, POST-----주문화면*/
	@RequestMapping(value="/orderPage", method = RequestMethod.POST)
	public String orderPage(@ModelAttribute ShoppingCartVO cVo, LoginDTO dto, Model model, 
						   HttpSession session, RedirectAttributes rttr, HttpServletRequest request) throws Exception{
		
		//로그인 정보를 담는다. 
		Object user= session.getAttribute("login");  //속성명이 "login"인 값을 Object타입으로 리턴한다. 
		MemberVO mVo = (MemberVO) user;
		
		if(mVo == null) {  //주문할 때 로그인 안된 상태라면
			
			rttr.addFlashAttribute("msg", "success");  //숨김 데이터 전송
			
			return "redirect:/member/login";  // 이경로로 이동!
		}  //그다음에 그전에 보던 페이지로 이동하도록 하는 부분 추가해야함.(AuthenticationSuccessHandler 인터페이스)
		
		String memberId = mVo.getMemberid();//mVo에 로그인한 회원에 대한 정보가 있다. 
		
		System.out.println(memberId);
		
		model.addAttribute("id" , memberId);   // model에 넣어준다.
		model.addAttribute("cVo", cVo);  // 상세페이지에서 값을 받아온다. 

		System.out.println("여기" + cVo);
		
		return null;	//주문할 제품이 선택되면 이 경로로 이동.	
	}
	
	
	/*---- PUT order, POST-----주문넣기*/
	@RequestMapping(value="/putOrder", method = RequestMethod.POST)
	public String putOrder(@ModelAttribute ShoppingCartVO cVo, LoginDTO dto, Model model, 
						 RedirectAttributes rttr, HttpServletRequest request, HttpSession session) throws Exception{
		
		System.out.println("주문한다." + cVo);
		service.putOrder(cVo);  //카트에 넣는 부분
	
		return "redirect:/member/orderComplete";  // 주문할 제품이 선택되면 이 경로로 이동.	
	}

	
	/*---- ORDERCOMPLETE, POST-----주문완료화면*/
	@RequestMapping(value="/orderComplete", method = RequestMethod.GET)
	public void orderComplete(@ModelAttribute ShoppingCartVO cVo, Model model,
							   LoginDTO dto, HttpSession session) throws Exception{
		
		model.addAttribute(service.orderComplete(cVo));
		System.out.println("서비스" + service.orderComplete(cVo));
		System.out.println("여기" + cVo);
		
	}
	
	/*---- JOIN, GET------회원가입 페이지 보는곳*/
	@RequestMapping(value="/popup", method=RequestMethod.GET)
	public void popupGET(MemberVO mVo, Model model) throws Exception {
		
		System.out.println("popUp GET............");
	}//joinGET
}

