package com.flippanda.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
//		log.info("로그인 성공");
//		List<String> roleList = new ArrayList<>();
//		
//		log.info("부여받은 권한을 확인합니다.");
//		for(String role : roleList) {
//			log.info(role);
//		}
//		
//		log.info("메인페이지로 돌아갑니다.");
//		response.sendRedirect("/");
		
		log.warn("로그인 성공");
		List<String> roleList = new ArrayList<>();
		
		for(GrantedAuthority role : authentication.getAuthorities()) {
			roleList.add(role.getAuthority());
		}
		
		// roleList에 포함된 권한을 통해 로그인 계정의 권한에 따라 처리
		log.warn("부여받은 권한들 : " + roleList);
		if(roleList.contains("ROLE_USER")) {
			response.sendRedirect("/main");
			return;
		
		response.sendRedirect("/");
	}

}
