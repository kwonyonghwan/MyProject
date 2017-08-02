package org.ktl.persistence;
//BoardDAO인터페이스를 구현.
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.ktl.controller.BoardController;
import org.ktl.domain.BoardVO;
import org.ktl.domain.Criteria;
import org.ktl.domain.SearchCriteria;
import org.ktl.persistence.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	@Inject
	private SqlSession session;  
	
	private static String namespace = "org.ktl.mapper.BoardMapper";
	
	/* ---create---*/
	@Override
	public void create(BoardVO bVo) throws Exception {
		session.insert(namespace + ".create", bVo);
	}

	/* ---- read ----*/
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	/* --- update---*/
	@Override
	public void update(BoardVO bVo) throws Exception {
		session.update(namespace + ".update", bVo);
	}

	/* --- delete---*/
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	/* --- listAll---*/
	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	/* --- listPage---*/
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		if(page <= 0) {
			page = 1;
		}
		
		page = (page -1)*10;
		
		return session.selectList(namespace + ".listPage", page);
	}

	
	/* --- listCriteria---*/
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	
	/* --- COUNTPAGING---*/
	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return session.selectOne(namespace + ".countPaging", cri);
	}

	
	/* --- LISTSEARCH---*/
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".listSearch", cri);
	}

	
	/* --- LISTSEARCHCOUNT---*/
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
