package com.flippanda.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FreeBoardReplyVO {
	private int freeBoardReplyNum;
	private int userNum;
	private int freeBoardNum;
	private int freeBoardContent;
	private int freeBoardReplyReplyDate;
	private int freeBoardReplyUpdateDate;
	
	public void setFreeBoardContent(int freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}
	public void setFreeBoardReplyUpdateDate(int freeBoardReplyUpdateDate) {
		this.freeBoardReplyUpdateDate = freeBoardReplyUpdateDate;
	}
	
	
}
