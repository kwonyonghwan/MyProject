package com.plus.service;

import java.util.List;

import com.plus.domain.BlacklistDTO;

public interface BlacklistService {
	
	public List<BlacklistDTO> selectAll(String memberid);
	
	public void insertBlacklist (BlacklistDTO blackDTO);

	public void deleteBlacklist (BlacklistDTO blackDTO);
	
}//interface
