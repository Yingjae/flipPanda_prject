package com.flippanda.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flippanda.qna.mapper.QnABoardMapper;
import com.flippanda.qna.mapper.QnAReplyMapper;
import com.flippanda.vo.QnACriteria;
import com.flippanda.vo.QnAVO;

@Service
public class QnABoardServiceImpl implements QnABoardService{
	
	@Autowired
	private QnABoardMapper qnaboardMapper;
	
	@Autowired
	private QnAReplyMapper qnareplyMapper;

	@Override
	public List<QnAVO> getList(QnACriteria qnacri) {		
		return qnaboardMapper.getList(qnacri);
	}

	@Override
	public QnAVO select(int qnaNum) {
		return qnaboardMapper.select(qnaNum);
	}

	@Override
	public void insert(QnAVO vo) {
		qnaboardMapper.insert(vo);		
	}

	@Transactional
	@Override
	public void delete(int qnaNum) {
		qnareplyMapper.deleteAllReplies(qnaNum);
		qnaboardMapper.delete(qnaNum);		
	}

	@Override
	public void update(QnAVO vo) {
		qnaboardMapper.update(vo);		
	}

	@Override
	public int countPageNum() {
		return qnaboardMapper.countPageNum();
	}

	@Override
	public List<QnAVO> getList(int qnaNum) {
		// TODO Auto-generated method stub
		return null;
	}


		
	}

