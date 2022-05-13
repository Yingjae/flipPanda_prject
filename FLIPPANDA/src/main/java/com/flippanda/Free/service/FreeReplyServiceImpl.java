package com.flippanda.Free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flippanda.Free.mapper.FreeBoardMapper;
import com.flippanda.Free.mapper.FreeReplyMapper;
import com.flippanda.vo.FreeBoardReplyVO;

@Service
public class FreeReplyServiceImpl implements FreeReplyService {

	@Autowired
	private FreeReplyMapper mapper;
	
	@Override
	public List<FreeBoardReplyVO> listReply(long freeboard_num) {
		return mapper.getList(freeboard_num);
	}
	
	@Transactional
	@Override
	public void addReply(FreeBoardReplyVO vo) {
		mapper.create(vo);
		// 댓글번호는 ReplyVO에 들어있으므로 getter를 활용
		//FreeBoardMapper.updateReplyCount(vo.getFreeBoardNum(), 1); // 댓글이 추가되면 갯수 증가 
		
	}
	
	@Override
	public void modifyReply(FreeBoardReplyVO vo) {
		mapper.update(vo);
		
	}
	
	@Transactional
	@Override
	public void removeReply(Long freeBoardReplyNum) {
		// 글 삭제 전에 먼저 bno번을 채취하놓고
		Long bno = mapper.getFreeBoardNum(freeBoardReplyNum);
		// 다음 글 삭제해야 문제 없이 글 번호를 가져옵니다. 
		mapper.delete(freeBoardReplyNum);
		// DB에서 커밋 안하면 pending 상태로 계속 지연되니 주의 
		//FreeBoardMapper.updateReplyCount(FreeBoardNum, -1); // 댓글이 추가되면 갯수 감소 
	}
}
