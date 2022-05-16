package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreeBoardVO {
	private long freeBoardNum;
	private long userNum;
	private String freeBoardTitle;
	private String freeBoardContent;
	private Date regDate;
	private Date updateDate;
	private int freeBoardViews;
	private String freeBoardNick;
	
	
	
}
