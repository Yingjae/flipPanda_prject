package com.flippanda.auction.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.flippanda.vo.auctionLogVO;
import com.flippanda.vo.auctionVO;
import com.flippanda.vo.bidVO;
import com.flippanda.auctionFunk.mapper.auctionLogMapper;
import com.flippanda.auctionFunk.mapper.auctionMapper;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AuctionFunctionalTest {
	
	@Autowired
	public auctionMapper aMapper;
	
	@Autowired
	public auctionLogMapper alMapper;
	
    //@Test
	public void getAuctionListTest() {
		List<auctionVO> result = aMapper.getAuctionListTest();
		log.info("Auction List : " + result);
	}
	//@Test
	public void getAuctionDetailTest() {
		auctionVO result = aMapper.getAuction(4);
		List<auctionLogVO> logresult = alMapper.getBidLog(4);
		log.info("Auction Detail : " + result);
		log.info("Bid Log for This : " + logresult);
	}
	
	//@Test
	public void postTest() {
		auctionVO vo = new auctionVO();
		log.info("before insert :" + vo);
		
		int preSetAmount = 20000;
				
		vo.setAuction_title("posting test auction");
		vo.setAuction_description("posting test great deal");
		vo.setProduct_name("posting test product");
		vo.setProduct_category("Electronics");
		vo.setUser_num("1");
		
		vo.setStart_amount(preSetAmount);
		vo.setCurrent_amount(preSetAmount);
		vo.setRTB_price(0);
		
		aMapper.postAuction(vo);
		
		log.info("after insert :" + vo);
		
	}
	
	//@Test
	public void pendingTest() {
		List<auctionVO> result = aMapper.getPendingList();
		log.info("Pending List : " + result);	
	}
	
	//@Test
	public void publishTest() {
		auctionVO vo = new auctionVO();
		vo.setAuction_num(6);
		log.info("before publish auction:" + vo);
		aMapper.publishAuction(vo);
		log.info("published auction:" + vo);
	}
	
	//@Test
	public void deleteTest() {
		aMapper.delete(4);	
		alMapper.delete_bidLog(4);
	}
	
	//@Test
	public void updateTest() {
		auctionVO vo = new auctionVO();
		vo.setAuction_num(6);
		log.info("before update : " + vo);
		
		int preSetAmount = 50000;
		
		vo.setAuction_title("updating_test auction");
		vo.setAuction_description("updating_test great deal");
		vo.setProduct_name("updating_test product");
		vo.setProduct_category("update");
		
		vo.setStart_amount(preSetAmount);
		vo.setCurrent_amount(preSetAmount);
		vo.setRTB_price(1000000);
		
		log.info("after update : " + vo);
		aMapper.update(vo);
	}
	
	//MOST IMPORTANT aF !!!!
	//@Test
	public void bidTest() {
		auctionVO vo = new auctionVO();
		vo.setAuction_num(2);
		bidVO bvo = new bidVO();
		bvo.setBid_amount((double)50);
		
		log.info(bvo);
		log.info(vo);
		
		int current = (int) vo.getCurrent_amount(); 
		double bidamount = (double) bvo.getBid_amount();
		
		log.info("CA check after bid :" + current);
		log.info("BA check after bid :" + bidamount);
		
		if(current < bidamount) {
			aMapper.bidding(vo);
			alMapper.bid(vo);
		}else {
			log.info("Fuck No");
		}
	}
	
	@Test
	public void closeTest() {
		auctionVO vo = new auctionVO();
		vo.setAuction_num(2);
		log.info("before close auction :" + vo);
		aMapper.closeAuction(vo);
		log.info("closed auction :" + vo);
	}
	
	//@Test
	public void failTest() {
		auctionVO vo = new auctionVO();
		vo.setAuction_num(6);
		log.info("still available auction :" + vo);
		aMapper.failedAuction(vo);
		log.info("failed :" + vo);
	}
	
	//@Test
	public void soldTest() {
		auctionVO vo = new auctionVO();
		vo.setAuction_num(6);
		log.info("still available auction :" + vo);
		aMapper.soldAuction(vo);
		log.info("sold :" + vo);
	}
	

}
