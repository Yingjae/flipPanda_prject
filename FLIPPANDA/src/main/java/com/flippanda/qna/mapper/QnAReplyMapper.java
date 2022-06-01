package com.flippanda.qna.mapper;

import java.util.List;

import com.flippanda.vo.QnAReplyVO;

public interface QnAReplyMapper {
	
	// 특정 게시판 qnanum번 글의 전체 댓글 목록 가져오기
	public List<QnAReplyVO> getList(int qnaNum);
	 
    public void create(QnAReplyVO vo);
	
	public void update(QnAReplyVO vo);
	
	// 댓글 삭제시는 단일 댓글 하나만 삭제해야 하므로 댓글번호를 받는다.
	public void delete(int qnareplyNum);
	
	// 댓글번호를 통해 글번호 유추하기
	public int getQnANum(int qnareplyNum);
	
	public void deleteAllReplies(int qnaNum);



}
