package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class QnAReplyVO {
	private int QnAReplyNum;
	private int QnANum;
	private int AdminNum;
	private Date QnAReplyDate;
	private Date QnAReplyUpdateDate;
	private String QnAReplyContent;
	
	public void setQnAReplyUpdateDate(Date qnAReplyUpdateDate) {
		QnAReplyUpdateDate = qnAReplyUpdateDate;
	}
	public void setQnAReplyContent(String qnAReplyContent) {
		QnAReplyContent = qnAReplyContent;
	}
	
	
}
