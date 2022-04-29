package com.flippanda.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class UserVO {
	private int userNum;
	private String userName;
	private int userPoint;
	private String userAdress;
	private String userId;
	private String userPw;
	private String userNick;
	
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
}
