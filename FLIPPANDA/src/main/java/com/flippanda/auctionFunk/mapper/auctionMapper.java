package com.flippanda.auctionFunk.mapper;

import java.util.List;

import com.flippanda.vo.auctionVO;

public interface auctionMapper {
	
	public List<auctionVO> getAuctionListTest();
	
	public List<auctionVO> getPendingList();
	
	public auctionVO getAuction(long auction_num);
	
	public void postAuction(auctionVO avo);
	
	public void publishAuction(auctionVO avo);
	
	public void bidding(auctionVO avo);
	
	public void update(auctionVO avo);
	
	public void closeAuction(auctionVO avo);
	
	public void soldAuction(auctionVO avo);
	
	public void failedAuction(auctionVO avo);
	
	public void delete(long auction_num);

}
