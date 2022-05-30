package com.flippanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flippanda.vo.FreeCriteria;
import com.flippanda.vo.FreePageMaker;
import com.flippanda.vo.FreeSearchCriteria;
import com.flippanda.Free.mapper.FreeBoardMapper;
import com.flippanda.Free.service.FreeBoardService;
import com.flippanda.vo.FreeBoardVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeservice;
	
	@GetMapping("/freeBoardList")
	public String freeBoardList(FreeSearchCriteria freecri, Model model) {
		
		List<FreeBoardVO> freeBoardList=freeservice.getList(freecri);
		log.info("넘어온 글 관련 정보 목록 : " + freeBoardList);
		model.addAttribute("freeBoardList", freeBoardList);
		
		FreePageMaker freePageMaker = new FreePageMaker();
		freePageMaker.setFreecri(freecri);
		int countPage=freeservice.countPageNum(freecri);
		freePageMaker.setTotalBoard(countPage);
		model.addAttribute("freePageMaker",freePageMaker);
		
		return "freeBoard/freeBoardList";
	}
	
	@GetMapping("/usersFreeBoardList/{userNum}")
	public String usersFreeBoardList(@PathVariable long userNum, Model model) {
		List<FreeBoardVO> usersFreeBoardList=freeservice.usersGetList(userNum);
		model.addAttribute("usersFreeBoardList", usersFreeBoardList);
		return "freeBoard/usersFreeBoardList";
	}
	
	@GetMapping("/freeBoardDetail/{freeBoardNum}") 
	public String freeBoardDetail(@PathVariable long freeBoardNum, Model model) {
		FreeBoardVO freeboard = freeservice.select(freeBoardNum);
		model.addAttribute("freeboard",freeboard);
		return "freeBoard/freeBoardDetail";
	}
	
	@GetMapping("/freeBoardInsert")
	public String freeBoardForm() {
		return "freeBoard/freeBoardForm";
	}
	
	@PostMapping("/freeBoardInsert")
	public String freeBoardInsert(FreeBoardVO freeboard) {
		// 폼에서 날린 데이터 들어오는지 디버깅
		log.info("들어온 데이터 디버깅 : " + freeboard);
		// insert 로직 실행
		freeservice.insert(freeboard);
		return "redirect:/freeBoard/freeBoardList";
	}
	
	@PostMapping("/freeBoardDelete")
	public String freeBoardDelete(long freeBoardNum) {
		freeservice.delete(freeBoardNum);
		return "redirect:/freeBoard/freeBoardList";
	}
	
	@PostMapping("/freeBoardUpdateForm")
	public String freeBoardUpdateForm(long freeBoardNum, Model model) {
		FreeBoardVO freeboard = freeservice.select(freeBoardNum);
		// 바인딩
		model.addAttribute("freeboard",freeboard);
		return "freeBoard/freeBoardUpdateForm"; //${board};
	}
	
	@PostMapping("/freeBoardUpdate")			
	public String boardUpdate(FreeBoardVO freeboard) {
		// SearchCriteria가 제대로 받아오는지 체크
		//log.info("수정로직 : "+ board);
		//log.info("검색 키워드 : " + cri.getKeyword());
		//log.info("검색 조건 : " + cri.getSearchType());
		//log.info("검색 페이지번호 : " + cri.getPageNum());
		
		// 리다이렉트시 주소창 뒤에 파라미터 쿼리스트링 형식으로 붙이기
		// rttr.addAttribute("파라미터명", "전달자료");
		// 는 호출되면 redirect 주소 뒤에 파라미터를 붙여줍니다.
		// rttr.addFlashAttribute()는 넘거간 페이지에서 파라미터를
		// 쓸 수 있도록 전달하는것으로 둘의 역할이 다르니 주의하세요.
		//rttr.addAttribute("pageNum", cri.getPageNum());
		//rttr.addAttribute("searchType", cri.getSearchType());
		//rttr.addAttribute("keyword", cri.getKeyword());
		
		// update 호출
		freeservice.update(freeboard);
		// redirect:주소&글번=getter
		return "redirect:/freeBoard/freeBoardDetail/" + freeboard.getFreeBoardNum();
	}
}
