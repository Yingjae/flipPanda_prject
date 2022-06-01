package com.flippanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.flippanda.user.service.UserService;
import com.flippanda.vo.UserVO;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class UserController {
	
	@Autowired
	private PasswordEncoder pwen;
	
	@Autowired
	private UserService service;
	
	
	
}
