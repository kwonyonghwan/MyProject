package org.yonghwan.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.yonghwan.domain.test_tableDTO;

@Repository
public class test_tableDAOImpl implements test_tableDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "org.yonghwan.mapper.test_tableMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertTest_table(test_tableDTO dto) {
		sqlSession.insert(namespace+".insertTest_table",dto);
	}

	@Override
	public test_tableDTO read(String name) {
		return sqlSession.selectOne(namespace+".getTest_tableDTO",name);
	}

}
