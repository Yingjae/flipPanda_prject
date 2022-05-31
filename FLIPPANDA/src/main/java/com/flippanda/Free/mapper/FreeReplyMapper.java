package com.flippanda.Free.mapper;

import java.util.List;

import com.flippanda.vo.FreeBoardReplyVO;
import com.flippanda.vo.FreeBoardVO;

public interface FreeReplyMapper {

	public List<FreeBoardReplyVO> getList(Long freeBoard_num); // 특정 게시판 num번 글의 댓글 목록 가져오기
	
	public void create(FreeBoardReplyVO vo);
	
	public void update(FreeBoardReplyVO vo);
	
	// 댓글 삭제시는 단일 댓글 하나만 삭제해야 하므로 댓글번호를 받는다.
	public void delete(Long freeBoardReplyNum);
	
	// 댓글번호를 통해 글번호 유추하기.
	public Long getFreeBoardNum(Long freeBoardReplyNum);
	
	public FreeBoardReplyVO getNick(String freeBoardNick);
}
