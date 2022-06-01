package com.flippanda.Free.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flippanda.vo.FreeCriteria;
import com.flippanda.vo.FreeSearchCriteria;
import com.flippanda.vo.FreeBoardVO;

public interface FreeBoardMapper {
	
public List<FreeBoardVO> getList(FreeSearchCriteria freecri);

public List<FreeBoardVO> usersGetList(long userNum);
	
	public void insert(FreeBoardVO vo);
	
	public FreeBoardVO select(long freeBoard_num);
	 
	public void delete(long freeBoard_num);
	
	public void update(FreeBoardVO vo);
	
	public void update2(@Param("freeBoardTitle") String freeBoardTitle,
						@Param("freeBoardContent")String freeBoardContent,
						@Param("freeBoardNum") long freeBoardNum);
	
	
	public int countPageNum(FreeSearchCriteria freecri); // 전체 글 개수 얻어오기
	
	public FreeBoardVO getNick(String freeBoardNick);
	
	public void updateviews(long freeBoard_num);
	
	


}
