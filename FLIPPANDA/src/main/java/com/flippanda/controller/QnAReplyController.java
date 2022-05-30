package com.flippanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flippanda.qna.service.QnAReplyService;
import com.flippanda.vo.QnAReplyVO;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/qnareplies")
public class QnAReplyController {
	
	@Autowired
	private QnAReplyService service;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@PostMapping(value="", consumes="application/json",	produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> register(	@RequestBody QnAReplyVO vo){
		ResponseEntity<String> entity = null;
		try {		
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {		
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
		return entity;
	}
	
	@PreAuthorize("permitAll")
	@GetMapping(value="/all/{qnaNum}",
		produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<QnAReplyVO>> list(@PathVariable("qnaNum") int qnaNum){
		
		ResponseEntity<List<QnAReplyVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(
					service.listReply(qnaNum), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@DeleteMapping(value="/{qnareplyNum}",
					produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("qnareplyNum") int qnareplyNum){	
		
		ResponseEntity<String> entity = null;		
		
		try {
			service.removeReply(qnareplyNum);			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
					value="/{qnareplyNum}",
					consumes="application/json",
					produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(	
				@RequestBody QnAReplyVO vo,
				@PathVariable("qnareplyNum") int qnareplyNum){	
		ResponseEntity<String> entity = null;
		try {			
			vo.setQnareplyNum(qnareplyNum);	
			service.modifyReply(vo);		
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	
	
}




