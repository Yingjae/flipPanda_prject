package com.flippanda.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) 
					throws IOException, ServletException {
		log.error("커스텀 접근 거부 핸들러 실행");
		log.error("사용자 정보에 오류가 있습니다.");
		log.info("메인페이지로 돌아갑니다");
		
		response.sendRedirect("/accessError");
		
	}

}
