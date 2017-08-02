package com.plus.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.plus.domain.ChatbotDTO;
import com.plus.domain.MatchingDTO;
import com.plus.persistence.ChatbotDAO;

@Service
public class ChatbotServiceImpl implements ChatbotService{

	@Inject
	private ChatbotDAO dao;
	
	@Override
	public void insertMesage(ChatbotDTO ChatbotDTO) {
		
		System.out.println(ChatbotDTO.toString());
		//api에 데이터 던지기 
		
		//api에서 데이터 받기 
		MatchingDTO dto = new MatchingDTO();
		
		//받은 데이터에서 위경도 추출 
		
		dao.insertWordList(dto);
	}//insertMesage()

}//class