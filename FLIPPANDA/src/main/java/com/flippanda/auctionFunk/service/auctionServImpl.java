package com.flippanda.auctionFunk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flippanda.vo.auctionVO;

import lombok.extern.log4j.Log4j;

import com.flippanda.auctionFunk.mapper.auctionLogMapper;
import com.flippanda.auctionFunk.mapper.auctionMapper;

@Log4j
@Service 
public class auctionServImpl implements AuctionSevice{
	
	@Autowired
	public auctionMapper auctionMapper;
	
	@Autowired
	public auctionLogMapper auctionLogMapper;
	
	@Override
	public List<auctionVO> getAuctionListTest() {
		log.info("테스트중" + auctionMapper.getAuctionListTest());
		return auctionMapper.getAuctionListTest();
	}

	@Override
	public List<auctionVO> getPendingList() {
		log.info("testing WIP:" + auctionMapper.getPendingList());
		return auctionMapper.getPendingList();
	}
	
	@Override
	public auctionVO getAuction(long auction_num) {
		log.info("testing WIP:" + auctionMapper.getAuction(auction_num));
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
	
	@Transactional
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
	
	@Transactional
	@Override
	public void delete(long auction_num) {
		auctionMapper.delete(auction_num);
		auctionLogMapper.delete_bidLog(auction_num);
	}



}
