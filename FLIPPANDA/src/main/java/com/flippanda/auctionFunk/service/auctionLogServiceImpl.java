package com.flippanda.auctionFunk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flippanda.auctionFunk.auctionLogVO;
import com.flippanda.auctionFunk.auctionVO;
import com.flippanda.auctionFunk.bidVO;
import com.flippanda.auctionFunk.mapper.auctionLogMapper;
import com.flippanda.auctionFunk.mapper.auctionMapper;

@Service
public class auctionLogServiceImpl implements auctionLogSevice{
	
	@Autowired
	public auctionLogMapper auctionLogMapper;
	
	@Override
	public List<auctionLogVO> getbidLog(Long auction_num) {
		return auctionLogMapper.getbidLog(auction_num);
		
	}
	@Override
	public void deleteLog(Long auction_num) {
		auctionLogMapper.delete(auction_num);
	}

}
