package com.flippanda.Free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flippanda.Free.mapper.FreeReplyMapper;
import com.flippanda.vo.FreeBoardReplyVO;


@Service
public class FreeReplyServiceImpl implements FreeReplyService {
	
	@Autowired
	private FreeReplyMapper freeReplymapper;

	@Override
	public List<FreeBoardReplyVO> listReply(long freeBoard_num) {
		
		return freeReplymapper.getList(freeBoard_num);
	}

	@Override
	public void addReply(FreeBoardReplyVO vo) {
		freeReplymapper.create(vo);
		
	}

	@Override
	public void modifyReply(FreeBoardReplyVO vo) {
		freeReplymapper.update(vo);
		
	}

	@Override
	public void removeReply(Long freeBoardReplyNum) {
		freeReplymapper.delete(freeBoardReplyNum);
		
	}

	@Override
	public FreeBoardReplyVO getNick(String freeBoardReplyNick) {
		// TODO Auto-generated method stub
		return freeReplymapper.getNick(freeBoardReplyNick);
	}

}
