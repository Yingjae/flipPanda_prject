package com.flippanda.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flippanda.qna.mapper.QnABoardMapper;
import com.flippanda.qna.mapper.QnAReplyMapper;
import com.flippanda.vo.QnAReplyVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class QnAReplyServiceImpl implements QnAReplyService{
	// 서비스는 매퍼를 호출하기때문에 매퍼 생성
	@Autowired
	private QnAReplyMapper mapper;
	
	@Autowired
	private QnABoardMapper boardMapper;

	@Override
	public List<QnAReplyVO> listReply(int qnaNum) {
		return mapper.getList(qnaNum);
	}
	
	@Transactional
	@Override
	public void addReply(QnAReplyVO vo) {
		mapper.create(vo);
		boardMapper.updateReplyCount(vo.getQnaNum(), 1);
	}

	@Override
	public void modifyReply(QnAReplyVO vo) {
	    mapper.update(vo);		
	}
    
	@Transactional
	@Override
	public void removeReply(int qnareplyNum) {
		int qnaNum = mapper.getQnANum(qnareplyNum);
		mapper.delete(qnareplyNum);	
	}

	
	

}
