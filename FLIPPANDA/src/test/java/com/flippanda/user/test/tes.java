package com.flippanda.user.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class tes {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = 
			"jdbc:mysql://127.0.0.1:3306/mysql?useSSL=false&serverTimezone=UTC";
	private final String USER = "root";
	private final String PW = "mysql";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			
			log.info(con);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
