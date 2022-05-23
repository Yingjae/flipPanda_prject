package com.flippanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flippanda.admin.mapper.AdminMapper;
import com.flippanda.user.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserMapper userMapper;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/adminManager")
	public void adminManager(Model model) {
		userMapper.getUserAllData();
	}
	
	@PostMapping("/addAdmin")
	public void addAdmin() {
		
	}
}
