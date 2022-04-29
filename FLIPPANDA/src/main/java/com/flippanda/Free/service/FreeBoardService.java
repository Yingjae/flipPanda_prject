package com.flippanda.Free.service;

import java.util.List;

import com.flippanda.Free.domain.Criteria;
import com.flippanda.Free.domain.SearchCriteria;
import com.flippanda.vo.FreeBoardVO;

public interface FreeBoardService {

	public List<FreeBoardVO> getList(SearchCriteria cri);
	
	public int countPageNum(SearchCriteria cri);
	
	public FreeBoardVO select(long freeboard_num);
	
	public void insert(FreeBoardVO vo);
	
	public void delete(long freeboard_num);
	
	public void update(FreeBoardVO vo);
}
