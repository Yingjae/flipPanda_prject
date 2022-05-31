package com.flippanda.Free.service;

import java.util.List;

import com.flippanda.vo.FreeBoardReplyVO;
import com.flippanda.vo.FreeBoardVO;

public interface FreeReplyService {

	public List<FreeBoardReplyVO> listReply(long freeBoard_num);
	
	public void addReply(FreeBoardReplyVO vo); 
	
	public void modifyReply(FreeBoardReplyVO vo); //수정
	
	public void removeReply(Long freeBoardReplyNum);
	
	public FreeBoardReplyVO getNick(String freeBoardReplyNick);
}
