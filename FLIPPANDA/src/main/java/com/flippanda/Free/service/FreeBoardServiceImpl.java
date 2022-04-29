package com.flippanda.Free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flippanda.Free.domain.Criteria;
import com.flippanda.Free.domain.SearchCriteria;
import com.flippanda.Free.mapper.FreeBoardMapper;
import com.flippanda.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	@Autowired
	private FreeBoardMapper FreeBoardMapper;
	
	//리턴자료형이 없는 insert, delete, update구문은 사용자 행동 기준으로 메서드를 나눕니다 
	@Override
	public List<FreeBoardVO> getList(SearchCriteria cri){
		return FreeBoardMapper.getList(cri);
	}
	
	@Override
	public int countPageNum(SearchCriteria cri) {
		return FreeBoardMapper.countPageNum(cri);
	}
	
	@Override
	public FreeBoardVO select(long freeboard_num) {
		return FreeBoardMapper.select(freeboard_num);
	}
	
	@Override
	public void insert(FreeBoardVO vo) {
		FreeBoardMapper.insert(vo);
		
	}
	@Override
	public void delete(long freeboard_num) {
		// mapper를 이용해 구현
		FreeBoardMapper.delete(freeboard_num);
		
	}
	
	@Override
	public void update(FreeBoardVO vo) {
		FreeBoardMapper.update(vo);
		
		
	}
}