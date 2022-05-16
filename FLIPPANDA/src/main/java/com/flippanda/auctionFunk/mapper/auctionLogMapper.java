package com.flippanda.auctionFunk.mapper;

import java.util.List;

import com.flippanda.auctionFunk.auctionLogVO;
import com.flippanda.auctionFunk.auctionVO;
import com.flippanda.auctionFunk.bidVO;

public interface auctionLogMapper {
	
	public List<auctionLogVO> getbidLog(Long auction_num);
	
	public void delete(Long auction_num);

	public void bid(auctionVO avo);

}
