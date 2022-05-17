package com.flippanda.auctionFunk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.flippanda.auctionFunk.auctionVO;
import com.flippanda.auctionFunk.mapper.auctionLogMapper;
import com.flippanda.auctionFunk.mapper.auctionMapper;

@Service
public class auctionServImpl implements AuctionSevice{
	
	@Autowired
	public auctionMapper auctionMapper;
	
	@Autowired
	public auctionLogMapper auctionLogMapper;

	@Override
	public List<auctionVO> getAuctionListTest() {
		return auctionMapper.getAuctionListTest();
	}

	@Override
	public List<auctionVO> getPendingList() {
		return auctionMapper.getPendingList();
	}
	
	@Override
	public auctionVO getAuction(Long auction_num) {
		return auctionMapper.getAuction(auction_num);
	}

	@Override
	public void postAuction(auctionVO avo) {
		auctionMapper.postAuction(avo);
	}

	@Override
	public void publishAuction(auctionVO avo) {
		auctionMapper.publishAuction(avo);
	}
	
//	@Transactional
	@Override
	public void bidding(auctionVO avo) {
		auctionMapper.bidding(avo);
		auctionLogMapper.bid(avo);
	}

	@Override
	public void update(auctionVO avo) {
		auctionMapper.update(avo);
	}

	@Override
	public void closeAuction(auctionVO avo) {
		auctionMapper.closeAuction(avo);
	}

	@Override
	public void soldAuction(auctionVO avo) {
		auctionMapper.soldAuction(avo);
	}	

	@Override
	public void failedAuction(auctionVO avo) {
		auctionMapper.failedAuction(avo);
	}
	
//	@Transactional
	@Override
	public void delete(Long auction_num) {
		auctionMapper.delete(auction_num);
		auctionLogMapper.delete(auction_num);
	}



}
