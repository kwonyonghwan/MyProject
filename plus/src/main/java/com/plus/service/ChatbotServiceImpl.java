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
		//api�� ������ ������ 
		
		//api���� ������ �ޱ� 
		MatchingDTO dto = new MatchingDTO();
		
		//���� �����Ϳ��� ���浵 ���� 
		
		dao.insertWordList(dto);
	}//insertMesage()

}//class