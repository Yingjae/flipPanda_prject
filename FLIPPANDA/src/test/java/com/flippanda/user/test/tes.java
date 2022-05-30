package com.flippanda.user.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestParam;

import com.flippanda.admin.mapper.AdminMapper;
import com.flippanda.admin.service.AdminService;
import com.flippanda.user.service.UserService;
import com.flippanda.vo.UserVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class tes {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	
	//@Test
	public void testConnection() {
		
		UserVO userData =  new UserVO();
		
		userData.setUserName("11");
		userData.setUserId("11");
		userData.setUserNick("11");
		userData.setUserPw("11");
		userData.setUserAddress("11");
			
		userService.userInsert(userData);
		
	}
	
	//@Test
	public void testAdmin() {
		List<UserVO> userData = userService.getUserAllData();
		
		log.info(userData);
		
	}
	
	
	@Test
	public void testSetAuth() {
		String userId = "33";
		String auth = "ROLE_ADMIN";
		log.info("값을 받아옵니다 !!!!" + userId+ " : " + auth);
		userService.SetUserAuth(auth,userId);
	}
	
	//@Test
	public void testupdate() {
		UserVO userData =  new UserVO();
		userData.setUserNum(3);
		userData.setUserName("333");
		userData.setUserId("333");
		userData.setUserNick("333");
		userData.setUserPw("333");
		userData.setUserAddress("333");
		
		userService.userUpdate(userData);
	}
}
