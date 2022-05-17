package com.flippanda.auctionFunk.service;

import java.util.List;

import com.flippanda.vo.auctionLogVO;
import com.flippanda.vo.auctionVO;
import com.flippanda.vo.bidVO;

public interface auctionLogSevice {
	
	public void deleteLog(Long auction_num);

	List<auctionLogVO> getbidLog(Long auction_num);
	
}
