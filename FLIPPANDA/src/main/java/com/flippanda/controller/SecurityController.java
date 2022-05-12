package com.flippanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@RequestMapping("/secu/*")
public class SecurityController {
	@Autowired
	private UserService UserService;
	
	@Autowired
	private PasswordEncoder pwen;
	
	// 회원가입
	@GetMapping("/join")
	public void joinForm() {
		log.info("회원가입창 접속 성공");
	}
	
	@PostMapping("/join")
	public void join(UserVO vo) {
		vo.setUserPw(pwen.encode(vo.getUserPw()));
		UserService.userInsert(vo);
		UserService.autoSetUserAuth(vo);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/authTest")
	public void authTest() {
		log.info("권한 테스트 페이지 접속");
	}
}