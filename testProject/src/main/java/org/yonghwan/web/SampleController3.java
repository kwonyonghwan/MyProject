package org.yonghwan.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yonghwan.domain.ProductVO;
import org.springframework.ui.Model;

@Controller
public class SampleController3 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("/doD")
	public String doA(Model model){

		ProductVO product = new ProductVO("sanple product", 10000);
		logger.info("doD");
		logger.info(product.toString());
		
		model.addAttribute(product);			
		
		return "productDetail";
	}
	
}//class
