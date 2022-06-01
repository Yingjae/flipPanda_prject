package com.flippanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flippanda.Free.service.FreeReplyService;
import com.flippanda.vo.FreeBoardReplyVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies") //임시 주소
@Log4j
public class FreeReplyController {
	
	@Autowired
	private FreeReplyService freeReplyservice;
	
	@PostMapping(value="", consumes="application/json",produces = {MediaType.TEXT_PLAIN_VALUE})
	// PRODUCES에 TEXT_PLAIN_VALUE를 줬으므로 String 리턴
	public ResponseEntity<String> register(
					// RestController에서는 받는 파라미터 앞에 @RequestBody 어노테이션이 붙어야
					// 형식에 맞는 json데이터를 vo에 매칭시켜줍니다. 
					@RequestBody FreeBoardReplyVO vo){
		// 에러 나는 경우랑 안 나는 경우를 대비해서 빈 ResponseEntity를 생성함
		ResponseEntity<String> entity = null;
		try {
			// 입력로직 실행 후
			freeReplyservice.addReply(vo);
			// 문제 없이 다음줄로 넘어왔다면 성공했을때 화면에 띄울 ResponseEntity 생성
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			// 에러나면 에러메세지와 함께 ResponseEntity 생성
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		// 위의 try블럭이나 catch블럭에서 얻어온 entity 변수 리턴하기. 
		return entity;
	}
	

	@GetMapping(value="/all/{freeBoardNum}",
		produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity<List<FreeBoardReplyVO>> list(@PathVariable("freeBoardNum")long freeBoardNum){
		ResponseEntity<List<FreeBoardReplyVO>> entity = null;
		
		log.info("뎃글 목록 :" + freeReplyservice.listReply(freeBoardNum));
		try {
			entity = new ResponseEntity<>(
					freeReplyservice.listReply(freeBoardNum), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@DeleteMapping(value="/{freeBoardReplyNum}",
				produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> remove(@PathVariable("freeBoardReplyNum")Long freeBoardReplyNum){
		
		ResponseEntity<String> entity =null;
		
		try {
			freeReplyservice.removeReply(freeBoardReplyNum);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
					value="/{freeBoardReplyNum}", consumes="application/json",
					produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> modify(
			
			@RequestBody FreeBoardReplyVO vo, 
	 
			@PathVariable("freeBoardReplyNum") Long freeBoardReplyNum){
		
		ResponseEntity<String> entity =null;
		try {
			
			log.info("세팅 전 vo : " + vo);
			vo.setFreeBoardReplyNum(freeBoardReplyNum);
			log.info("세팅 후 vo : " + vo);
			freeReplyservice.modifyReply(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		}

}
