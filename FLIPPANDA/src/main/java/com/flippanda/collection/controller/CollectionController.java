package com.flippanda.collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.flippanda.collection.mapper.CollectionMapper;
import com.flippanda.collection.service.CollectionService;
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
	
	// 컬렉션 글을 추가하는 로직
	@GetMapping("/insertMyCollection")
	public String insertMyCollection() {
		return "insertMyCollection";
	}
	
	// 글 추가 form의 post방식을 처리하는 메서드
	@PostMapping("/insertMyCollection")
	public String insertMyCollection(MyCollectionVO cVO) {
		//log.info("들어온 데이터 디버깅 : " + collection);
		service.insertMyCollection(cVO);
		return "redirect:/allCollectionList";
	}
	
	// 글 삭제 메서드
	// /deleteMyCollection 로 주소처리
	// collectionNum을 받아서 해당 글 삭제
	// 글 삭제 버튼은 페이지 하단에 userNum이나 userNick 일치하면 활성화
	@PostMapping("/deleteMyCollection")
	public String deleteMyCollection(long collectionNum) {
		service.deleteMyCollection(collectionNum);
		// user security랑 연결하면 마이컬렉션으로 이동하도록 수정
		return "redirect:/allCollectionList";
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
	
	// 좋아요 insert 메서드
	
	
	// 좋아요 delete 메서드
	
	
	
}
