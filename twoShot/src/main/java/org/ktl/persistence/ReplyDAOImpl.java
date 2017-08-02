package org.ktl.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.ktl.domain.Criteria;
import org.ktl.domain.ReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.ktl.mapper.ReplyMapper";

	/*---- LIST----*/
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		
		return session.selectList(namespace + ".list", bno);
	}

	/*---- CREATE----*/
	@Override
	public void create(ReplyVO rVo) throws Exception {
		
		session.insert(namespace + ".create", rVo);
		
	}

	/*---- UPDATE----*/
	@Override
	public void update(ReplyVO rVo) throws Exception {

		session.update(namespace + ".update",rVo);
	}

	/*---- DELETE----*/
	@Override
	public void delete(Integer rno) throws Exception {
		
		session.delete(namespace + ".delete",rno);
		
	}
	
	/*---- LISTPAGE----*/
	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		return session.selectList(namespace + ".listPage", paramMap);
	}

	
	/*---- COUNT----*/
	@Override
	public int count(Integer bno) throws Exception {

		return session.selectOne(namespace + ".count", bno);
	}
	
 
}
