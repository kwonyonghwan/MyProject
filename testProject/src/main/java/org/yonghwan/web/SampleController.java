package org.yonghwan.web;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yonghwan.domain.test_tableDTO;

@RestController
@RequestMapping("/users")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void doA(@ModelAttribute("dto") test_tableDTO dto){
		
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
		public void doB(test_tableDTO dto,HttpSession session, Model model) throws Exception{
		logger.info("doB called.................");
		
		test_tableDTO testDTO = new test_tableDTO();
		testDTO.setName("ddddd");
		testDTO.setAge(12);
		
		if(testDTO == null){
			return;
		}
		
		model.addAttribute("test_tableDTO", testDTO);
	}
	

}
