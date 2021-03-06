package com.flippanda.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.flippanda.collection.service.CollectionService;
import com.flippanda.vo.CollectionAttachVO;
import com.flippanda.vo.MyCollectionVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CollectionController {
	
	// 컨트롤러가 서비스를 호출하도록 주소 변경
	// Service를 CollectionController 에서 쓸 수 있도록 선언/주입
	@Autowired
	private CollectionService service;
	
	// 전체 글을 조회하는 로직
	@GetMapping("/allCollectionList")
	public String allCollectionList(Model collectionModel) {
		List<MyCollectionVO> allCollectionList = service.getAllCollectionList();
		log.info("넘어온 글 관련 정보 목록 : " + allCollectionList);
		collectionModel.addAttribute("allCollectionList", allCollectionList);
		service.getAllCollectionList();
		return "allCollectionList";
	}
	// 전체 글을 조회하는 로직(비동기)
	/*
	@GetMapping(value="/allCollectionList",
				produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<List<MyCollectionVO>> list(){
			ResponseEntity<List<MyCollectionVO>> entity = null;
			
			try {
				entity = new ResponseEntity<>(
						service.getAllCollectionList(), HttpStatus.OK);
			} catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
	*/
	// 특정 유저의 글을 조회하는 로직
	@GetMapping("/usersCollectionList/{userNum}")
	public String selectUsers(@PathVariable long userNum, Model collectionModel) {
		List<MyCollectionVO> usersCollection = service.usersCollectionList(userNum);
		collectionModel.addAttribute("usersCollection", usersCollection);
	/* 화면단에 collectionNick을 뿌려주고 싶은데 못하는중 
	public String selectUsers(MyCollectionVO cVO, long userNum, long collectionNum, Model cModel ) {
		collectionMapper.usersCollectionList(userNum);
		collectionMapper.selectMyCollection(collectionNum);
		cModel.addAttribute("userNum", userNum);*/
		return "usersCollectionList";
	}
	
	// 특정 유저의 글을 조회하는 로직(비동기)
	/*@GetMapping(value="/usersCollectionList"
			    produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<List<MyCollectionVO>> usersCollection(){
			ResponseEntity<List<MyCollectionVO>> entity = null;
	}*/
	
	// 컬렉션 글을 추가하는 로직
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/insertMyCollection")
	public String insertMyCollection() {
		
		log.info("upload form");
		return "insertMyCollection";
	}
	
	// 글 추가 form의 post방식을 처리하는 메서드
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/insertMyCollection")
	public String insertMyCollection(MyCollectionVO cVO, MultipartFile[] uploadFile, Model model) {
		log.info("들어온 데이터 디버깅 : " + insertMyCollection());
		
		String uploadFolder = "C:\\upload_data\\temp";
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		} // end for
		
		service.insertMyCollection(cVO);
		return "redirect:/allCollectionList";
	}
	
	// upload파일이 이미지 파일인지 아닌지 확인하는 메서드
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 이미지 정보를 rest 방식으로 출력하는 메서드
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<CollectionAttachVO>> getAttachList(long collectionNum){
		return new ResponseEntity<>(service.getAttachList(collectionNum), HttpStatus.OK);
	}
	
	// 글 삭제 메서드
	// /deleteMyCollection 로 주소처리
	// collectionNum을 받아서 해당 글 삭제
	// 글 삭제 버튼은 페이지 하단에 userNum이나 userNick 일치하면 활성화
	@PostMapping("/deleteMyCollection")
	public String deleteMyCollection(long collectionNum, long userNum) {
		service.deleteMyCollection(collectionNum);
		List<MyCollectionVO> usersCollection = service.usersCollectionList(userNum);
		// user security랑 연결하면 마이컬렉션으로 이동하도록 수정
		return "redirect:/usersCollectionList/" + userNum;
	}
	
	// 글 수정하는 메서드
	@PostMapping("/updateMyCollectionForm")
	public String updateMyCollectionForm(long collectionNum, Model collectionModel) {
		MyCollectionVO cVO = service.selectMyCollection(collectionNum);
		collectionModel.addAttribute("cVO", cVO);
		return "updateMyCollectionForm";
	}
	
	// 수정된 글의 내용을 받아오는 메서드
	@PostMapping("/updateMyCollection")
	public String updateMyCollection(MyCollectionVO cVO) {
		service.updateMyCollection(cVO); 
		return "redirect:/usersCollectionList/" + cVO.getUserNum(); 
	}
	
	
	
	
}
