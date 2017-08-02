package org.ktl.service;

import java.util.List;

import org.ktl.domain.BoardVO;
import org.ktl.domain.Criteria;
import org.ktl.domain.SearchCriteria;

public interface BoardService {
	
	public void regist(BoardVO bVo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void modify(BoardVO bVo) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;  //페이징 처리
	
	public int listCountCriteria(Criteria cri) throws Exception;

	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}
