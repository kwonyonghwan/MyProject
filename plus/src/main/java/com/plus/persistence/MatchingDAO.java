package com.plus.persistence;

import java.util.List;

import com.plus.domain.MatchingDTO;

public interface MatchingDAO {

	public List<String> readCategoryList();
	
	public List<MatchingDTO> readMathcingData(String category);
	
}//interface
