package com.flippanda.auctionFunk.mapper;

import java.util.List;

import com.flippanda.vo.auctionLogVO;
import com.flippanda.vo.auctionVO;
import com.flippanda.vo.bidVO;

public interface auctionLogMapper {
	
	public List<auctionLogVO> getbidLog(Long auction_num);
	
	public void delete(Long auction_num);

	public void bid(auctionVO avo);

}
