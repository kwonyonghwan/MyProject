package org.ktl.controller;

import javax.inject.Inject;

import org.ktl.domain.BoardVO;
import org.ktl.domain.Criteria;
import org.ktl.domain.PageMaker;
import org.ktl.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	
	@Inject
	private BoardService service;
	
	/*---- REGISTER, GET------게시물 입력페이지 보는곳*/
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(BoardVO bVo, Model model) throws Exception {
		
		logger.info("resister GET............");
	}
	
	
	/*---- REGISTER, POST-----실제로 입력된 데이터 처리*/
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(BoardVO bVo, RedirectAttributes rttr) throws Exception {
		
		logger.info("registerPOST..........");
		logger.info(bVo.toString());
		
		service.regist(bVo);

		rttr.addFlashAttribute("msg", "success");  //숨김 데이터 전송
		
		return "redirect:/board/listAll";	
	} //RedirectAttributes의 addFlashAttribute 를 이용하여 post방식처럼 url뒤에 parameter를  추가하지 않아도 화면에 값을 받을수 있다.
	
	
	/*---- LISTALL, GET-----전체 목록*/
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		
		logger.info("show all list...........");
		model.addAttribute("list", service.listAll());  // 모든 데이터를 jsp로 전송
	}
	
	
	/*---- READ, GET-----게시물 상세보기*/
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		//외부에서 전달될 bno값을 전달받음 + 조회된 결과를 jsp로 전달해야 해서 Model객체 사용함.
		
		model.addAttribute(service.read(bno));
	}
	
	
	/*---- Modify, GET-----게시물 수정을 위한 조회 페이지 이동*/
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	} // Model은 addAttribut()작업에서 아무런 이름 없이 데이터를 넣으면 자동으로 클래스의 이름을 소문자로 시작해서 사용함. 즉 boardVO로 jsp에서 받게된다. 
	
	
	
	/*---- Modify, POST-----게시물 실제 수정 작업*/
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO bVo, RedirectAttributes rttr) throws Exception {
		
		logger.info("mod get................");
		
		service.modify(bVo);
		rttr.addAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
	
	/*---- REMOVE, POST-----게시물 삭제처리*/
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		
		service.remove(bno);
		
		rttr.addAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
	/*---- LISTPAGE, GET-----부분 페이지*/
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
		public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		
		System.out.println("나오나?" + cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		System.out.println(pageMaker.toString());
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
	/*---- LISTCRI, GET-----*/
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
		public void listAll(Criteria cri, Model model) throws Exception {
		
		System.out.println("SHOW LIST PAGE WIRH CRI..........");
		
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	
	/*---- READPAGE, GET-----조회 페이지 처리 */
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		//외부에서 전달될 bno값을 전달받음 + 조회된 결과를 jsp로 전달해야 해서 Model객체 사용함.
		
		model.addAttribute(service.read(bno));
		
	}  // /board/readPage?bno=xx&page=x&perPageNum=xxx
	
	
	
	 /*---- REMOVEPAGE, POST-----삭제 페이지*/
	 @RequestMapping(value = "/removePage", method = RequestMethod.POST)
	  public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		// RedirectAttributes는 Redirect 동작을 수행 할 때 속성값을 URI variable, 
		// 혹은 parameter 형태로 쉽게 전달하기 위해 Spring에서 제공하는 Class이다.
		 
	    service.remove(bno);

	    //page와 pageNum이 jsp로 함께 전송되어야 한다. 
	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addFlashAttribute("msg", "SUCCESS"); //하나의 URL에서 Redirect 요청을 수행 할 때, 특정 값을 다른 URL에서 사용 하기 위해 제공되는 Class이다.

	    return "redirect:/board/listPage";
	  }

	 
	  /*---- MODIFYPAGE, GET-----수정 페이지*/
	  @RequestMapping(value = " /modifyPage", method = RequestMethod.GET)  //조회페이지 -> 수정페이지 이동
	  public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)
	      throws Exception {

	    model.addAttribute(service.read(bno));
	  }
	  
	  
	  /*---- MODIFYPAGE, POST-----수정 작업이 이루어지는 부분*/
	  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	  public String modifyPagingPOST(BoardVO bVo, Criteria cri, RedirectAttributes rttr) throws Exception {
		  
		  service.modify(bVo);
		  
		  rttr.addAttribute("page", cri.getPage());
		  rttr.addAttribute("perPageNum", cri.getPerPageNum());
		  rttr.addFlashAttribute("msg", "SUCCESS");  //수정된 결과를 'msg'로 전송한다. 
		  
		  return "redirect:/board/listPage";  //모든 작업이 끝나면 목록 페이지로 다시 이동한다. 
	  }
	  
}
