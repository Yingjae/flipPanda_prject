package com.flippanda.user.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flippanda.admin.mapper.AdminMapper;
import com.flippanda.user.mapper.UserMapper;
import com.flippanda.vo.AdminVO;
import com.flippanda.vo.UserAuthority;
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
		System.out.println("${adminName}");
		//mapper.adminInsert(adminData);
	}
	
	@Test
	public void getadminDataTest() {
		log.info("유저 번호 :");
		log.info("유저 번호 :");
		UserVO user = mapper.getUserData(2);
		List<UserAuthority> auth = mapper.getUserAuth(2);
		log.info("권한정보 : " + auth);
		user.setAuthList(auth);
		log.info("유저 정보 :" + user);
		log.info("유저 번호 :" + user.getUserNum());
	}
	
}
