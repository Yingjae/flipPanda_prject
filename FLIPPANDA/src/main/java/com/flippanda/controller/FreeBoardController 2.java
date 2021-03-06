/*
package com.flippanda.Free.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flippanda.Free.domain.PageMaker;
import com.flippanda.Free.domain.SearchCriteria;
import com.flippanda.Free.service.FreeBoardService;

import com.flippanda.vo.FreeBoardVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/FreeBoard")
public class FreeBoardController {

	
	@Autowired
	private FreeBoardService service;
	
	@GetMapping("/FreeBoardList")
	public String FreeBoardList(SearchCriteria cri, Model model) {
		//model.addAttribute("바인딩이름", 바인딩자료);
		List<FreeBoardVO> FreeBoardList = service.getList(cri);
		log.info("넘어온 글 관련 정보 목록 : " + FreeBoardList);
		model.addAttribute("FreeBoardList",FreeBoardList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int countPage=service.countPageNum(cri); 
		pageMaker.setTotalBoard(countPage); //prev, next, startPage, endPage세팅
		model.addAttribute("pageMaker", pageMaker);
		
		return "FreeBoard/FreeboardList";
	}
	
	@GetMapping("/FreeBoardDetail/{freeBoard_num}") 
	public String FreeboardDetail(@PathVariable long freeBoard_num, Model moder) {
		FreeBoardVO FreeBoard = service.select(freeBoard_num);
		moder.addAttribute("FreeBoard", FreeBoard);
		return "FreeBoard/FreeBoardDetail";
	}
	
	@GetMapping("/FreeBoardInsert")
	public String FreeBoardForm() {
		return "FreeBoard/FreeBoardForm";
	}
	
	@PostMapping("/FreeBoardInsert")
	public String FreeBoardInsert(FreeBoardVO FreeBoard) {
		// 폼에서 날린 데이터 들어오는지 디버깅
		log.info("들어온 데이터 디버깅 : " + FreeBoard);
		// insert 로직 실행
		service.insert(FreeBoard);
		return "redirect:/Freeboard/FreeboardList";
	}
	
	@PostMapping("/FreeboardDelete")
	public String FreeboardDelete(long freeBoard_num, SearchCriteria cri, RedirectAttributes rttr) {
		log.info("pageNum 정보 : " + cri.getPageNum());
		log.info("searchType 정보 : " + cri.getSearchType());
		log.info("keyword 정보 : " + cri.getKeyword());
		
		// 리다이렉트 주소에 페이지번호, 검색조건, 키워드 전달
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("pageNum", cri.getPageNum());
		parameters.put("searchType",cri.getSearchType());
		parameters.put("keyword", cri.getKeyword());
		log.info("전달 직진 : " + parameters);
		// 위에 생성한 맵 자료를 전달합니다.
		rttr.addAllAttributes(parameters);
		
		//삭제로직 실행
		service.delete(freeBoard_num);
		//리턴으로 리스트페이지 복귀
		return "redirect:/Freeboard/FreeboardList";
	}
	
	@PostMapping("/FreeBoardUpdateForm")
	public String boardUpdateForm(long freeBoard_num, Model model) {
		FreeBoardVO FreeBoard = service.select(freeBoard_num);
		// 바인딩
		model.addAttribute("FreeBoard",FreeBoard);
		return "FreeBoard/FreeBoardUpdateForm"; //${board};
	}
	
	@PostMapping("/FreeBoardUpdate")			// keyword, searchType, pageNum을 받기 위해 선언
	public String boardUpdate(FreeBoardVO FreeBoard, SearchCriteria cri, RedirectAttributes rttr) {
		// SearchCriteria가 제대로 받아오는지 체크
		log.info("수정로직 : "+ FreeBoard);
		log.info("검색 키워드 : " + cri.getKeyword());
		log.info("검색 조건 : " + cri.getSearchType());
		log.info("검색 페이지번호 : " + cri.getPageNum());
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		// update 호출
		service.update(FreeBoard);
		// redirect:주소&글번=getter
		return "redirect:/FreeBoard/FreeBoardDetail/" + FreeBoard.getFreeBoardNum();
	}
}*/

