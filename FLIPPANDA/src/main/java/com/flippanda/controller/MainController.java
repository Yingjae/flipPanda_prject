package com.flippanda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.flippanda.vo.auctionLogVO;
import com.flippanda.vo.auctionVO;
import com.flippanda.vo.bidVO;
import com.flippanda.auctionFunk.service.AuctionSevice;
import com.flippanda.auctionFunk.service.auctionLogSevice;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
//@RequestMapping(value="/main")
public class MainController {
	
	@Autowired
	private AuctionSevice auctionService;
	
	@Autowired
	private auctionLogSevice auctionLogService;
	
	@GetMapping("/main")
	public String frontView() {
		return "/main";
	}
	
	
	@GetMapping("/main.ajax")
	public @ResponseBody List<auctionVO> auctionListAjax(){
		List<auctionVO> getAuctionList = auctionService.getAuctionListTest();
		return getAuctionList;
	}
	
	
	@GetMapping("/main/{auction_num}.ajax")
	public @ResponseBody auctionVO auctionDetailAjax(@PathVariable long auction_num){
		auctionVO getAuction = auctionService.getAuction(auction_num);
		log.info("확인:"+getAuction);
		return getAuction;
	}
	
	@GetMapping("/main/log/{auction_num}.ajax")
	public @ResponseBody List<auctionLogVO> auctionLogAjax(@PathVariable long auction_num){
		List<auctionLogVO> auctionLog = auctionLogService.getbidLog(auction_num);
		log.info(auctionLog);
		return auctionLog;
	}
	
	@GetMapping("/main/auction")
	public String auctionDetail(@ModelAttribute("avo") auctionVO avo, Model model, HttpServletRequest request)
			throws Exception {
		long auction_num = avo.getAuction_num();
		auctionVO auctionDetail = auctionService.getAuction(auction_num);
		model.addAttribute("auctionDetail", auctionDetail);

		return "auctuonDetail";
	}
	
	
	@GetMapping("/main/postAuctionForm")
	public void postAuctionForm() {
	}
	
	@PostMapping("/main/postAuction")
	@ResponseBody
	public List<auctionVO> postAuction1(@RequestBody auctionVO avo, MultipartFile[] multipartFile, Model model){
		log.info("insert post data :" + avo);
		auctionService.postAuction(avo);
		return null;
	} 
	
	//승인대기열 (ADMIN의 경우 승인버튼 노출)
	@GetMapping("/pending")
	public String pendingList(Model model) {
		List<auctionVO> pendingList = auctionService.getPendingList();
		log.info("pendingList data :" + pendingList);
		model.addAttribute("pendingList", pendingList);
		return "main/post";
	}
	
	@PostMapping(value="/main/bidNowAjax", consumes="application/json",	produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> bidNowAjax
		
		(@RequestBody auctionVO avo, auctionLogVO alvo, Long auction_num){
		
		ResponseEntity<String> entity = null;
		
		try {
			
			
			int current = (int) avo.getCurrent_amount(); 
			double bidAmount = (double) avo.getBid_amount();
			
			log.info("current Amount :" + current);
			log.info("bid Amount :" + bidAmount);
			
			if(current < bidAmount) {
				auctionService.bidding(avo);
				entity = new ResponseEntity<String>("Your Bid is Placed.", HttpStatus.OK);
			}
		}catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//업데이트 (퍼블리시 안됫을때만)
	@PostMapping("/updateAuctionForm")
	public String updateAuctionForm(Long auction_num, Model model) {
		auctionVO auctionDetail = auctionService.getAuction(auction_num);
		model.addAttribute("auction_detail", auctionDetail);
		return "/updateAuctionForm";
	}
	
	@PostMapping("/updateAuction")
	public String updateAuction(auctionVO avo) {
		auctionService.update(avo);
	return "redirect:/main/";
	
	}
	
	
	//삭제 (관리자만)
	@PostMapping("/delAuction")
	public String DeleteAuction(Long auction_num) {
		auctionService.delete(auction_num);
		return "redirect:/main";
	}
	
	//런칭 (관리자만)
	@PostMapping("/publish")
	public String launchAuction(auctionVO avo) {
		auctionService.publishAuction(avo);
		return "redirect:/main/";
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
	value="/",
	consumes="application/json",
	produces= {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public ResponseEntity<String> closeAuction
	(@PathVariable("auction_num") Long auction_num, @RequestBody auctionVO avo){
	
		ResponseEntity<String> entity = null;
		
		try {
			log.info("auction detail : " + avo);
			auctionService.closeAuction(avo);
			entity = new ResponseEntity<String>("Auction Closed", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	

}
