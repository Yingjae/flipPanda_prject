package com.flippanda.Free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flippanda.Free.domain.FreeCriteria;
import com.flippanda.Free.domain.FreeSearchCriteria;
import com.flippanda.Free.mapper.FreeBoardMapper;
import com.flippanda.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Autowired
	private FreeBoardMapper freeBoardMapper;

	@Override
	public List<FreeBoardVO> getList(FreeSearchCriteria freecri) {
		return freeBoardMapper.getList(freecri);
	}

	@Override
	public int countPageNum(FreeSearchCriteria freecri) {
		return freeBoardMapper.countPageNum(freecri);
	}
	
	@Override
	public FreeBoardVO select(long freeBoard_num) {
		return freeBoardMapper.select(freeBoard_num);
	}

	@Override
	public void insert(FreeBoardVO vo) {
		freeBoardMapper.insert(vo);
	}

	@Override
	public void delete(long freeBoard_num) {
		freeBoardMapper.delete(freeBoard_num);
		
	}

	@Override
	public void update(FreeBoardVO vo) {
		freeBoardMapper.update(vo);
		
	}

	@Override
	public FreeBoardVO getNick(String freeBoardNick) {
		return freeBoardMapper.getNick(freeBoardNick);
		
	}

	@Override
	public List<FreeBoardVO> usersGetList(long userNum) {
		return freeBoardMapper.usersGetList(userNum);
	}

	@Override
	public void updateviews(long freeBoard_num) {
	freeBoardMapper.updateviews(freeBoard_num);
	}

}
