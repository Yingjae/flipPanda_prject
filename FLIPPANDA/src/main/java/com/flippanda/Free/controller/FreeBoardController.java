package com.flippanda.Free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.flippanda.Free.mapper.FreeBoardMapper;

@Controller
public class FreeBoardController {

	
	@Autowired
	private FreeBoardMapper freeBoardMapper;
	
	@GetMapping("/freeBoardList")
	public String freeBoardList() {
	//	freeBoardMapper.getList();
		
		return "freeBoardList";
	}
}
