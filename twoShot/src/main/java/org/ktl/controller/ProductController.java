package org.ktl.controller;
//상품 목록과 관련된 controller. (사용자가 보는 화면)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ktl.domain.Criteria;
import org.ktl.domain.ManufacturerVO;
import org.ktl.domain.PageMaker;
import org.ktl.domain.ProductStockVO;
import org.ktl.domain.ProductVO; //상품
import org.ktl.domain.SearchCriteria;
import org.ktl.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	private ProductService service;

	/*---- PRODUCTLIST, GET------상품 전체목록*/
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public void productList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		// 상품 정보 목록
		List<ProductVO> productList = this.service.productList();

		// text로 검색하는 부분(페이징 관련 쿼리가 여기에서 이루어짐)
		model.addAttribute("productList", service.listSearch(cri)); 

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri); // page, perPageNum 세팅

		pageMaker.setTotalCount(service.listCountCriteria(cri));

		System.out.println("페이지메이커 : " + pageMaker);

		// 뿌려줄 제품의 총 갯수와 현재 페이지, 페이지당 보여줄 제품 수 정보 등
		model.addAttribute("pageMaker", pageMaker);

	}

	
	/*---- PRODUCTSEARCH, GET------상품 검색*/
	@RequestMapping(value = "/productSearch", method = RequestMethod.GET)
	public String productSearch(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {

		// 일단 모든 상품 목록을 가져온다 (필터링 전)
		List<ProductVO> productList = this.service.productList();

		model.addAttribute("productList", service.listSearch(cri)); // text로
																	// 검색하는 부분

		// view로 부터의 파라미터 값을 받아온다. (검색창에 입력한 값, 사용자가 선택한 검색타입)
		String keyword = request.getParameter("keyword");
		String searchType = request.getParameter("searchType");

		// category 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("category") != null) {
			logger.info("" + request.getParameterValues("category"));
			cri.setCategory(Arrays.asList(request.getParameterValues("category")));
		} // if()

		// color 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("color") != null) {
			logger.info("" + request.getParameterValues("color")[0]);
			cri.setColor(Arrays.asList(request.getParameterValues("color")));
		} // if()

		// size 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("size") != null) {
			logger.info("" + request.getParameterValues("size")[0]);

			cri.setSize(Arrays.asList(request.getParameterValues("size")));
		}

		// 가격 담기 ""
		if (request.getParameter("price") != null) {
			//
			if (!(request.getParameter("price").equals("")) || request.getParameter("price").split("-").length == 2) {
				String[] priceArr = request.getParameter("price").split("-");

				logger.info(priceArr[0]);
				logger.info(priceArr[1]);

				cri.setBeginPrice(priceArr[0]);
				cri.setEndPrice(priceArr[1]);
			} // if()

		} // if()

		// 현재 가격, 다중체크를 category에 담은 상태이다.

		List<ProductVO> sList = service.multiSearch(cri);

		System.out.println("필터 결과");
		System.out.println(sList.toString());

		/* 검색처리 부분 */
		model.addAttribute("filteredProductList", sList); // 뷰에서 productList로 전달받음.

		// 페이징 처리 부분
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));

		model.addAttribute("pageMaker", pageMaker);

		return "/product/productSearch";

	}                           

	/*---- PRODUCTDETAIL, GET-----상품 상세보기*/
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public void read(@RequestParam("pno") int pno, Model model) throws Exception {
		// 외부에서 전달될 pno값을 전달받음 + 조회된 결과를 jsp로 전달해야 해서 Model객체 사용함.

		model.addAttribute(service.productDetail(pno)); // 상세보기 불러오기

		model.addAttribute("pri", service.productReelImage(pno)); // 이미지 파일 불러오기
		System.out.println("pno:" + pno);

		// 상품재고목록
		List<ProductStockVO> productStock = this.service.productStock(pno);

		model.addAttribute("productStock", productStock); // "productStock"이름의
															// 모델 객체를 뷰에 전달한다.

		// 상세페이지에서 상품 색상들을 중복없이 출력하기 위한 부분
		List<String> productColor = new ArrayList<>(); // 상품 색상 리스트

		for (ProductStockVO productStockVO : productStock) {

			String color = productStockVO.getProductcolor(); // 제품 색상 4개를 가져온다.

			if (productColor.contains(color) == false) { // 선택한 색상이 리스트에 없으면
															// 넣는다.

				productColor.add(color);
			} // if

			System.out.println("=============");
			System.out.println("*사이즈:" + productStockVO.getProductsize()); // 사이즈
																			// 목록
			System.out.println("*색상:" + productStockVO.getProductcolor()); // 색상
																			// 목록
			System.out.println("*재고수량:" + productStockVO.getProductstock()); // 재고수량

		} // for

		model.addAttribute("productcolor", productColor); // view에서 받을 model설정

		// 상세페이지에서 상품 사이즈 목록을 중복없이 출력하기 위한 부분
		List<Integer> productSize = new ArrayList<>(); // 상품 사이즈 리스트

		for (ProductStockVO productStockVO : productStock) {

			int size = productStockVO.getProductsize(); // 제품 사이즈들(250`290)을
														// 가져온다.

			if (productSize.contains(size) == false) { // 선택한 사이즈가 리스트에 없으면 넣는다.

				productSize.add(size);
			} // if
		} // for

		System.out.println(productSize);
		model.addAttribute("productsize", productSize);
	}

	/*---- READPAGE, GET-----조회 페이지 처리 */
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("pno") int pno, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {
		// 외부에서 전달될 pno값을 전달받음 + 조회된 결과를 jsp로 전달해야 해서 Model객체 사용함.

		model.addAttribute(service.productDetail(pno));

	} // /product/readPage?pno=xx&page=x&perPageNum=xxx

	
	
	/*---- manufacturerid, GET-----상점 개별 페이지 */
	@RequestMapping(value = "/{manufacturerid}", method = RequestMethod.GET)
	public String getSpecificStoreProducts(@PathVariable("manufacturerid") String manufacturerid, SearchCriteria cri,
			Model model, HttpServletRequest request) throws Exception {

		System.out.println("메뉴펙처아이디 컨트롤러 들어옴");
		System.out.println(manufacturerid);
		model.addAttribute("manufacturerid", manufacturerid);
		
		ManufacturerVO mVO = new ManufacturerVO();
		mVO.setManufacturerid(manufacturerid);

		// 서비스 호출 해서 ProductVO리스트 받아옴.
		List<ProductVO> list = new ArrayList<>();

		try {
			// 특정가게의 모드 제품 가져옴.
			list = service.specificStoreproductList(mVO);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// 받아온 리스트 모델에 담음.
		model.addAttribute("specificStoreProducts", list);

		// category 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("category") != null) {
			
			logger.info("지금지금" + Arrays.asList(request.getParameterValues("category")));
			
			cri.setCategory(Arrays.asList(request.getParameterValues("category")));
		} // if()

		// color 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("color") != null) {
		
			cri.setColor(Arrays.asList(request.getParameterValues("color")));
		} // if()

		// size 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("size") != null) {

			cri.setSize(Arrays.asList(request.getParameterValues("size")));
		}

		// 가격 담기 ""
		if (request.getParameter("price") != null) {
			//
			if (!(request.getParameter("price").equals("")) || request.getParameter("price").split("-").length == 2) {
				String[] priceArr = request.getParameter("price").split("-");

				cri.setBeginPrice(priceArr[0]);
				cri.setEndPrice(priceArr[1]);
			}

		} // if
		
		// 가게 이름 세팅
		cri.setManufacturerid(manufacturerid);
		
		model.addAttribute("searchCriteria", cri);

		// 선택된 검색조건들로 필터링 된 결과 리스트 받아옴.
		List<ProductVO> sList = service.multiSearch(cri);

		System.out.println("필터 결과");
		System.out.println(sList.toString());

		/* 검색처리 부분 */ // 제품페이징 처리가 되고,
		model.addAttribute("filteredProductList", sList);
															

		// 페이징 처리 부분
		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(cri);
		
		// 해당 가게의 총제품 갯수를 계산하도록 쿼리 변경해야함.
		System.out.println("갯수???  " + service.specificStoreproductListCount(cri));
		pageMaker.setTotalCount(service.specificStoreproductListCount(cri));

		System.out.println("페이지" + pageMaker);
		
		model.addAttribute("pageMaker", pageMaker);

		// 해당 뷰 페이지로 이동.
		return "/product/manufacturer";

	}// getSpecificStoreProducts()

	
	/*---- /{manufacturerid}Search, GET----- 상점검색 */
	@RequestMapping(value = "/{manufacturerid}Search", method = RequestMethod.GET)
	public String manufactSearch(@PathVariable("manufacturerid") String manufacturerid, SearchCriteria cri,
			Model model, HttpServletRequest request) throws Exception {

		System.out.println("메뉴펙처아이디 컨트롤러 들어옴");
		
		model.addAttribute("manufacturerid", manufacturerid);
		
		ManufacturerVO mVO = new ManufacturerVO();
		mVO.setManufacturerid(manufacturerid);

		// 서비스 호출 해서 ProductVO리스트 받아옴.
		List<ProductVO> list = new ArrayList<>();

		try {
			// 특정가게의 모드 제품 가져옴.
			list = service.specificStoreproductList(mVO);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// 받아온 리스트 모델에 담음.
		model.addAttribute("specificStoreProducts", list);

		// category 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("category") != null) {
			
			logger.info("지금지금" + Arrays.asList(request.getParameterValues("category")));
			
			cri.setCategory(Arrays.asList(request.getParameterValues("category")));
		} // if()

		// color 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("color") != null) {
		
			cri.setColor(Arrays.asList(request.getParameterValues("color")));
		} // if()

		// size 값이 null이 아닐때만 가져온다.
		if (request.getParameterValues("size") != null) {

			cri.setSize(Arrays.asList(request.getParameterValues("size")));
		}

		// 가격 담기 ""
		if (request.getParameter("price") != null) {
			//
			if (!(request.getParameter("price").equals("")) || request.getParameter("price").split("-").length == 2) {
				String[] priceArr = request.getParameter("price").split("-");

				cri.setBeginPrice(priceArr[0]);
				cri.setEndPrice(priceArr[1]);
			}

		} // if
		
		// 가게 이름 세팅
		cri.setManufacturerid(manufacturerid);
		
		model.addAttribute("searchCriteria", cri);

		// 선택된 검색조건들로 필터링 된 결과 리스트 받아옴.
		List<ProductVO> sList = service.multiSearch(cri);

		System.out.println("필터 결과");
		System.out.println(sList.toString());

		/* 검색처리 부분 */ // 제품페이징 처리가 되고,
		model.addAttribute("filteredProductList", sList);
															

		// 페이징 처리 부분
		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(cri);
		
		// 해당 가게의 총제품 갯수를 계산하도록 쿼리 변경해야함.
		System.out.println("갯수???  " + service.specificStoreproductListCount(cri));
		pageMaker.setTotalCount(service.specificStoreproductListCount(cri));

		System.out.println("페이지" + pageMaker);
		
		model.addAttribute("pageMaker", pageMaker);

		// 해당 뷰 페이지로 이동.
		return "/product/manufactSearch";

	}// getSpecificStoreProducts()
}
