package com.flippanda.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flippanda.qna.mapper.QnABoardMapper;
import com.flippanda.qna.service.QnABoardService;
import com.flippanda.vo.QnACriteria;
import com.flippanda.vo.QnAPageMaker;
//import com.flippanda.vo.QnASearchCriteria;
import com.flippanda.vo.QnAVO;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Pre;

@Controller
@Log4j
@RequestMapping("/qna")
public class QnABoardController {
	
	@Autowired
	private QnABoardService service;
	
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	@GetMapping("/qnaboardList")
	public String qnaboardList(QnACriteria qnacri,Model model) {
		
        List<QnAVO> qnaboardList = service.getList(qnacri);
		
		model.addAttribute("qnaboardList",qnaboardList);
		
		int total= service.countPageNum();
		QnAPageMaker qnapageMaker = new QnAPageMaker(qnacri, total);
		model.addAttribute("qnapageMaker",qnapageMaker);				
		return "qna/qnaboardList";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@GetMapping("/qnaboardInsert")
	public String qnaboardForm() {
		return "qna/qnaboardForm";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@PostMapping("/qnaboardInsert")
	public String qnaboardInsert(QnAVO qnaboard) {
		log.info(" 들어온 데이터 : " + qnaboard);
		service.insert(qnaboard);
		return "redirect:/qna/qnaboardList";	
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@PostMapping("/qnaboardUpdateForm")
	public String qnaboardUpdateForm(int qnaNum, Model model) {
		QnAVO qnaboard = service.select(qnaNum);
		model.addAttribute("qnaboard",qnaboard);
		return "qna/qnaboardUpdateForm";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@PostMapping("/qnaboardUpdate")
	public String qnaboardUpdate(QnAVO qnaboard,QnACriteria qnacri, RedirectAttributes rttr) {	
		/*rttr.addAttribute("pageNum", qnacri.getPageNum());
		rttr.addAttribute("searchType", qnacri.getSearchType());
		rttr.addAttribute("keyword", qnacri.getKeyword());*/
		
		service.update(qnaboard);
		return "redirect:/qna/qnaboardDetail/" + qnaboard.getQnaNum();
	}
	
	@PreAuthorize("permitAll")
	@GetMapping("/qnaboardDetail/{qnaNum}")
	public String qnaboardDetail(@PathVariable int qnaNum,Model model) {
		QnAVO qnaboardList = service.select(qnaNum);
		model.addAttribute("qnaboardList",qnaboardList);
		return "qna/qnaboardDetail";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/qnaboardDelete")
	public String qnaboardDelete(int qnaNum,QnACriteria qnacri,RedirectAttributes rttr) {
		/*Map<String, Object> parameters = new HashMap<>();
		parameters.put("pageNum", qnacri.getPageNum());
		parameters.put("searchType",qnacri.getSearchType());
		parameters.put("keyword", qnacri.getKeyword());
		rttr.addAllAttributes(parameters);*/
		
		service.delete(qnaNum);
		return "redirect:/qna/qnaboardList";
	}

}

