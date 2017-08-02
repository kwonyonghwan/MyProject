package com.plus.service;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.plus.controller.MemberController;
import com.plus.domain.MatchingDTO;
import com.plus.persistence.MatchingDAO;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Inject
	MatchingDAO dao;
	
	@Override
	public void matchingLogic() {

		List<String> categoryList = dao.readCategoryList();
		
		for (String string : categoryList) {
			
			List<MatchingDTO> matchingDataList = dao.readMathcingData(string);
			System.out.println(matchingDataList.toString());
			//Logic
			
			//if(success)
			//pushApp
			
		}//forEach(categoryList)
		
		
	}//matchingLogic()

}//class
