package com.flippanda.qna.service;

import java.util.List;

import com.flippanda.vo.QnAReplyVO;

public interface QnAReplyService {
	
    public List<QnAReplyVO> listReply(int qnaNum);
	
	public void addReply(QnAReplyVO vo);
	
	public void modifyReply(QnAReplyVO vo);
	
	public void removeReply(int qnareplyNum);

}
