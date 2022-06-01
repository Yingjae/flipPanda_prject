package com.flippanda.qna.service;

import java.util.List;

import com.flippanda.vo.QnACriteria;
import com.flippanda.vo.QnAVO;

public interface QnABoardService {
	
	public List<QnAVO> getList(QnACriteria qnacri);
	
	public QnAVO select(int qnaNum);
	
	public void insert(QnAVO vo);
	
	public void delete(int qnaNum);
	
	public void update(QnAVO vo);
	
	public int countPageNum();
	
	public List<QnAVO> getList(int qnaNum);
	

}
