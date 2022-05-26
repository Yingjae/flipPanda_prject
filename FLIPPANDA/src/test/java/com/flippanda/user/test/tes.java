package com.flippanda.user.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flippanda.user.service.UserService;
import com.flippanda.vo.UserVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class tes {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testConnection() {
		
		UserVO userData =  new UserVO();
		
		userData.setUserName("11");
		userData.setUserId("11");
		userData.setUserNick("11");
		userData.setUserPw("11");
		userData.setUserAddress("11");
			
		userService.userInsert(userData);
		
	}
	
}
