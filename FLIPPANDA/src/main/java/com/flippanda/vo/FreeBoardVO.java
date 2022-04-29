package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FreeBoardVO {
	private int freeBoardNum;
	private int userNum;
	private String freeBoardTitle;
	private String freeBoardContent;
	private Date regDate;
	private Date updateDate;
	private int freeBoardViews;
	
	public void setFreeBoardTitle(String freeBoardTitle) {
		this.freeBoardTitle = freeBoardTitle;
	}
	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setFreeBoardViews(int freeBoardViews) {
		this.freeBoardViews = freeBoardViews;
	}
	
	
}
