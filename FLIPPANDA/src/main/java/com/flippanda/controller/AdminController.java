package com.flippanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flippanda.admin.mapper.AdminMapper;
import com.flippanda.user.mapper.UserMapper;
import com.flippanda.vo.UserAuthority;
import com.flippanda.vo.UserVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserMapper userMapper;
	
	@PreAuthorize("hasRole('ROLE_MASTER')")
	@GetMapping("/adminManager")
	public void adminManager(Model model) {
		List<UserVO> userDataList = userMapper.getUserAllData();
		model.addAttribute("userDataList",userDataList);
	}
	
	@PreAuthorize("hasRole('ROLE_MASTER')")
	@PostMapping("/addAuth")
	public String addAdmin(@RequestParam("userId")String userId, @RequestParam("auth")String auth, int userNum) {
		log.info(userId + ": " + auth);
		userMapper.SetUserAuth(auth, userId);
		if(auth.equals("ROLE_ADMIN")) {			
			adminMapper.adminInsert(userNum);
		} else {
			adminMapper.adminDelete(userNum);
		}
		return "redirect:/admin/adminManager";
		
	}
}
