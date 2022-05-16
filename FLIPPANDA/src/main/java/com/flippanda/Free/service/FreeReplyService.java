package com.flippanda.Free.service;

import java.util.List;

import com.flippanda.vo.FreeBoardReplyVO;

public interface FreeReplyService {

	public List<FreeBoardReplyVO> listReply(long freeboard_num);
	
	public void addReply(FreeBoardReplyVO vo);
	
	public void modifyReply(FreeBoardReplyVO vo);
	
	public void removeReply(Long freeBoardReplyNum);
}
