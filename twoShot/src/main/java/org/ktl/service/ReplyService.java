package org.ktl.service;

import java.util.List;

import org.ktl.domain.Criteria;
import org.ktl.domain.ReplyVO;

public interface ReplyService {
	
	public void addReply(ReplyVO rVo) throws Exception;
	
	public List<ReplyVO> listReply(Integer bno) throws Exception;
	
	public void modifyReply(ReplyVO rVo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception; //페이징처리
	
	public int count(Integer bno) throws Exception;
	
	
	
}
