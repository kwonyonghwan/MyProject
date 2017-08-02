package org.ktl.service;

//BoardService를 구현한 Impl클래스입니다.(DAO를 이용해서 작업 실행)
import java.util.List;

import javax.inject.Inject;

import org.ktl.domain.BoardVO;
import org.ktl.domain.Criteria;
import org.ktl.domain.SearchCriteria;
import org.ktl.persistence.BoardDAO;
import org.springframework.stereotype.Service;


@Service  //spring의 빈으로 인식되기 위해
public class BoardServiceImpl implements BoardService {

	
	@Inject
	private BoardDAO dao;
	
	
	/* --- REGIST ---*/
	@Override
	public void regist(BoardVO bVo) throws Exception {
		dao.create(bVo); 
	}
	
	/* ---READ---*/
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	/* ---MODIFY---*/
	@Override
	public void modify(BoardVO bVo) throws Exception {
		dao.update(bVo);
	}

	/* ---REMOVE---*/
	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	/* ---LISTALL---*/
	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	/* ---LISTCRITERIA---*/
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
	
		return dao.listCriteria(cri);
	}
	
	/* ---LISTCOUNTCRITERIA---*/
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		
		return dao.countPaging(cri);
	}

	/* ---LISTSEARCHCRITERIA---*/
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	/* ---LISTSEARCHCOUNT---*/
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
