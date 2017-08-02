package org.ktl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

import org.ktl.domain.BoardVO;
import org.ktl.domain.PageMaker;
import org.ktl.domain.SearchCriteria;
import org.ktl.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	@Controller
	@RequestMapping("/sboard/*")
	public class SearchBoardController {
		
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
		
	@Inject	
	private BoardService service;
		
	
	/*---- LIST, GET------*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	  public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

	    logger.info(cri.toString());

	    // model.addAttribute("list", service.listCriteria(cri));
	    model.addAttribute("list", service.listSearchCriteria(cri));

	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);

	    // pageMaker.setTotalCount(service.listCountCriteria(cri));
	    pageMaker.setTotalCount(service.listSearchCount(cri));

	    model.addAttribute("pageMaker", pageMaker);
	  }
	
	/*---- REMOVEPAGE, GET------게시물 삭제 */
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, 
					 @ModelAttribute("cri") SearchCriteria cri, 
					 Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
	}
	
	
	/*---- REMOVEPAGE, GET------*/
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	  public String remove(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

	    service.remove(bno);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/sboard/list";
	  }

	
	/*---- MODIFYPAGE, GET------게시물 수정 */
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

	   model.addAttribute(service.read(bno));
	}
	 
	/*---- MODIFYPAGE, POST------*/
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(BoardVO bVo, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

	    logger.info(cri.toString());
	    service.modify(bVo);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    logger.info(rttr.toString());

	    return "redirect:/sboard/list";
	  }

	
	  /*---- REGISTER, GET------*/
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public void registGET() throws Exception {

	    logger.info("regist get ...........");
	  }
	  
	  
	  /*---- REGISTER, POST------*/
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

	    logger.info("regist post ...........");
	    logger.info(board.toString());

	    service.regist(board);

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/sboard/list";
	  }
	
	}

