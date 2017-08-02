package com.plus.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plus.domain.MatchingDTO;

@Repository
public class MatchingDAOImpl implements MatchingDAO{

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.plus.mapper.matchingMapper";

	@Override
	public List<String> readCategoryList() {

		List<String> categoryList = sqlSession.selectList(namespace+".readCategoryList");
	
		return categoryList;
	}//readCategoryList

	@Override
	public List<MatchingDTO> readMathcingData(String category) {
		
		List<MatchingDTO> matchingDataList = sqlSession.selectList(namespace+".readMatchingData", category);
	
		return matchingDataList;
	}//readMathcingData

}//class