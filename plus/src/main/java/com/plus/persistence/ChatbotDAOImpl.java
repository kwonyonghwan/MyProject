package com.plus.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plus.domain.MatchingDTO;

@Repository
public class ChatbotDAOImpl implements ChatbotDAO{

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.plus.mapper.matchingMapper";

	@Override
	public void insertWordList(MatchingDTO MatchingDTO) {
	
		sqlSession.insert(namespace+".insertWordList", MatchingDTO);
		
	}//insertWordList()

}//class