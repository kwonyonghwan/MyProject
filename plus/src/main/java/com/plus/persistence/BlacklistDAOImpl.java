package com.plus.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plus.domain.BlacklistDTO;

@Repository
public class BlacklistDAOImpl implements BlacklistDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.plus.mapper.blacklistMapper";
	
	@Override
	public List<BlacklistDTO> selectAll(String memberid) {
		return sqlSession.selectList(namespace+".readBlacklist", memberid);
	}//selectAll

	@Override
	public int insertBlacklist(BlacklistDTO blackDTO) {
		return sqlSession.insert(namespace + ".registerBlacklist", blackDTO);
	}//insertBlacklist

	@Override
	public void deleteBlacklist(BlacklistDTO blackDTO) {
		sqlSession.delete(namespace+".deleteBlacklist", blackDTO);
	}//deleteBlacklist

}//class