package org.ktl.service;

import java.util.List;

import javax.inject.Inject;

import org.ktl.domain.Criteria;
import org.ktl.domain.ReplyVO;
import org.ktl.persistence.ReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{ 

	@Inject
	private ReplyDAO dao;

	/*---- addReply------댓글 추가*/
	@Override
	public void addReply(ReplyVO rVo) throws Exception {
		
		dao.create(rVo);
	}
	
	/*---- LISTREPLY------댓글 리스트*/
	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
			
		return dao.list(bno);
	}

	/*---- MODIFYREPLY------댓글 수정*/
	@Override
	public void modifyReply(ReplyVO rVo) throws Exception {
		
		dao.update(rVo);
	}
	
	/*---- REMOVEREPLY------댓글 삭제*/
	@Override
	public void removeReply(Integer rno) throws Exception {
		
		dao.delete(rno);
	}

	
	/*---- REMOVEREPLY------댓글 삭제*/
	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		
		return dao.listPage(bno, cri);
	}

	
	/*---- REMOVEREPLY------댓글 삭제*/
	@Override
	public int count(Integer bno) throws Exception {
		return dao.count(bno);
	}
	
	
	

}
