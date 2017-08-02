package com.plus.persistence;

import java.util.List;

import com.plus.domain.BlacklistDTO;

public interface BlacklistDAO {

	public List<BlacklistDTO> selectAll(String memberid);
	
	public int insertBlacklist (BlacklistDTO blackDTO);
	
	public void deleteBlacklist (BlacklistDTO blackDTO);
	
}//interface
