package com.flippanda.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserAuthority {
	private int userId;
	private String auth;
}
