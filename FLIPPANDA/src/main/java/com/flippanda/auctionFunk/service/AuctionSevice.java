package com.flippanda.auctionFunk.service;

import java.util.List;

import com.flippanda.auctionFunk.auctionLogVO;
import com.flippanda.auctionFunk.auctionVO;
import com.flippanda.auctionFunk.bidVO;

public interface AuctionSevice {
	
	public List<auctionVO> getAuctionListTest();
	
	public List<auctionVO> getPendingList();
	
	public auctionVO getAuction(Long auction_num);
	
	public void postAuction(auctionVO avo);
	
	public void publishAuction(auctionVO avo);
	
	public void bidding(auctionVO avo);
	
	public void update(auctionVO avo);
	
	public void closeAuction(auctionVO avo);
	
	public void soldAuction(auctionVO avo);
	
	public void failedAuction(auctionVO avo);
	
	public void delete(Long auction_num);


}
