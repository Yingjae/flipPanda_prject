package com.flippanda.Free.mapper;

import java.util.List;

import com.flippanda.vo.FreeBoardReplyVO;

public interface FreeReplyMapper {

public List<FreeBoardReplyVO> getList(Long freeBoard_num);
	
	public void create(FreeBoardReplyVO vo);
	
	public void update(FreeBoardReplyVO vo);
	
	// 댓글 삭제시는 단일 댓글 하나만 삭제해야 하므로 댓글번호를 받는다.
	public void delete(Long freeBoardReplyNum);
	
	// 댓글번호를 통해 글번호 유추하기.
	public Long getFreeBoardNum(Long freeBoardReplyNum);
}
