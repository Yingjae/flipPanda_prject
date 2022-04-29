package com.flippanda.Free.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flippanda.Free.domain.Criteria;
import com.flippanda.Free.domain.SearchCriteria;
import com.flippanda.vo.FreeBoardVO;

public interface FreeBoardMapper {
	
public List<FreeBoardVO> getList(SearchCriteria cri);
	
	public void insert(FreeBoardVO vo);
	
	public FreeBoardVO select(long freeBoard_num);
	 
	public void delete(long freeBoard_num);
	
	public void update(FreeBoardVO vo);
	
	public void update2(@Param("freeBoardTitle") String freeBoardTitle,
						@Param("freeBoardContent")String freeBoardContent,
						@Param("freeBoardNum") long freeBoardNum);
	
	
	public int countPageNum(SearchCriteria cri);
	


}
