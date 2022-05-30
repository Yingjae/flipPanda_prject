package com.flippanda.auctionFunk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flippanda.vo.auctionLogVO;
import com.flippanda.vo.auctionVO;
import com.flippanda.vo.bidVO;
import com.flippanda.auctionFunk.mapper.auctionLogMapper;
import com.flippanda.auctionFunk.mapper.auctionMapper;

@Service
public class auctionLogServiceImpl implements auctionLogSevice{
	
	@Autowired
	public auctionLogMapper auctionLogMapper;
	
	@Override
	public List<auctionLogVO> getBidLog(long auction_num) {
		return auctionLogMapper.getBidLog(auction_num);
		
	}
	@Override
	public void delete_bidLog(long auction_num) {
		auctionLogMapper.delete_bidLog(auction_num);
	}

}