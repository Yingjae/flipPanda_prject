package com.flippanda.qna.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flippanda.vo.QnACriteria;
import com.flippanda.vo.QnAVO;

public interface QnABoardMapper {
	
	public List<QnAVO> getList(QnACriteria qnacri);
	
	public void insert(QnAVO vo);
	
	public QnAVO select(int qnaNum);
	
	public void delete(int qnaNum);
	
	public void update(QnAVO vo);
	
	public int countPageNum();
	
	public void updateReplyCount(@Param("qnaNum") int qnaNum,@Param("amount") int amount);

	public QnAVO getNick(String userNick);

	

}
