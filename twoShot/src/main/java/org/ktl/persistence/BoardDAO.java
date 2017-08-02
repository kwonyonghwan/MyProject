package org.ktl.persistence;

import java.util.List;

import org.ktl.domain.BoardVO;
import org.ktl.domain.Criteria;
import org.ktl.domain.SearchCriteria;

public interface BoardDAO {

	public void create(BoardVO bVo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO bVo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listPage(int page) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;  //검색
	
	public int listSearchCount(SearchCriteria cri) throws Exception;  //검색
	
}// interface

