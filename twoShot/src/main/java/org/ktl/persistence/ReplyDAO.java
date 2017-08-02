package org.ktl.persistence;

import java.util.List;

import org.ktl.domain.Criteria;
import org.ktl.domain.ReplyVO;
// 댓글의 리스트, 등록, 수정, 삭제 기능을 정의함.
public interface ReplyDAO {
	
	  public List<ReplyVO> list(Integer bno) throws Exception;
	  
	  public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception;  //페이징처리
	  
	  public int count(Integer bno) throws Exception;  //페이징처리
	
	  public void create(ReplyVO rVo) throws Exception;

	  public void update(ReplyVO rVo) throws Exception;

	  public void delete(Integer rno) throws Exception;

}
