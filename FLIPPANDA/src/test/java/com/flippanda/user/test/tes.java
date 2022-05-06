package com.flippanda.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flippanda.user.mapper.UserMapper;
import com.flippanda.vo.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class tes {
	@Autowired
	private UserMapper mapper;
	
	//@Test
	public void insertTest() {
		int a =1;
		log.info(a);
		System.out.println("${userName}");
		//mapper.userInsert(userData);
	}
	
	//@Test
	public void getUserDataTest() {
		mapper.getUserData(1);
	}
	
	//@Test
	public void updateUser() {
		UserVO userData = mapper.getUserData(1);
		userData.setUserAddress("일산");
		userData.setUserName("박씨");
		userData.setUserPw("00");
		userData.setUserNick("수정");
		mapper.userUpdate(userData);
		log.info(mapper.getUserData(1));
	}
	
	//@Test
	public void DeleteUser() {
		mapper.userDelete(1);
	}
}
