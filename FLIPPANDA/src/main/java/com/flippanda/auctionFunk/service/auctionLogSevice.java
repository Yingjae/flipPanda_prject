package com.flippanda.auctionFunk.service;

import java.util.List;

import com.flippanda.auctionFunk.auctionLogVO;
import com.flippanda.auctionFunk.auctionVO;
import com.flippanda.auctionFunk.bidVO;

public interface auctionLogSevice {
	
	public void deleteLog(Long auction_num);

	List<auctionLogVO> getbidLog(Long auction_num);
	
}
