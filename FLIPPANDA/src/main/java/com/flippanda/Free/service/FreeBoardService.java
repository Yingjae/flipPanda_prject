package com.flippanda.Free.service;

import java.util.List;

import com.flippanda.Free.domain.FreeCriteria;
import com.flippanda.Free.domain.FreeSearchCriteria;
import com.flippanda.vo.FreeBoardVO;

public interface FreeBoardService {

	public List<FreeBoardVO> getList(FreeSearchCriteria freecri);
	
	public List<FreeBoardVO> usersGetList(long userNum);
	
	public int countPageNum(FreeSearchCriteria freecri);
	
	public FreeBoardVO select(long freeBoard_num);
	
	public void insert(FreeBoardVO vo);
	
	public void delete(long freeBoard_num);
	
	public void update(FreeBoardVO vo);
	
	public FreeBoardVO getNick(String freeBoardNick);
	
  public void updateviews(long freeBoard_num);

}
