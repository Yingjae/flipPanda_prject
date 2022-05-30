package com.flippanda.auctionFunk.mapper;

import java.util.List;

import com.flippanda.vo.auctionLogVO;
import com.flippanda.vo.auctionVO;
import com.flippanda.vo.bidVO;

public interface auctionLogMapper {
	
	public List<auctionLogVO> getBidLog(long auction_num);
	
	public void delete_bidLog(long auction_num);

	public void bid(auctionVO avo);

}