package com.flippanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flippanda.user.service.UserService;
import com.flippanda.vo.UserVO;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/test")
	public void test() {
		
	}
	
	@RequestMapping("/tester")
	public String tester(UserVO userData) {
		log.info(userData);
		service.userInsert(userData);
		return "test";
	}
	
	@GetMapping("/updateTest")
	public String updateForm(int userNum, Model model) {
		UserVO userData = service.getUserData(userNum);
		System.out.println("값 :" + userData);
		model.addAttribute("userData", userData);
		return "updateTest";
	}
	
	@PostMapping("/updateTest")
	public String updateUser(UserVO userData) {
		service.userUpdate(userData);
		return "updateTest";
	}
	
}
