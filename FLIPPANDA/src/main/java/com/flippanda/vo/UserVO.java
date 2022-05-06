package com.flippanda.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private int userNum;
	private String userName;
	private int userPoint;
	private String userAddress;
	private String userId;
	private String userPw;
	private String userNick;
}
