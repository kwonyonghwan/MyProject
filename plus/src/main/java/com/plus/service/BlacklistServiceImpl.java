package com.plus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.plus.domain.BlacklistDTO;
import com.plus.persistence.BlacklistDAO;
import com.plus.persistence.BlacklistDAOImpl;

@Service
public class BlacklistServiceImpl implements BlacklistService {
	
	@Inject
	private BlacklistDAO dao;
	
	@Override
	public List<BlacklistDTO> selectAll(String memberid) {
		return dao.selectAll(memberid); 
	}//selectAll

	@Override
	public void insertBlacklist(BlacklistDTO blackDTO) {
		dao.insertBlacklist(blackDTO);
	}//insertBlacklist

	@Override
	public void deleteBlacklist(BlacklistDTO blackDTO) {
		dao.deleteBlacklist(blackDTO);
	}//deleteBlacklist

}//class