package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class QnAVO {
	private int QnANum;
	private int userNum;
	private String QnATitle;
	private String QnAContent;
	private Date QnAUpdateDate;
	private Date QnAWriter;
	
	public void setQnATitle(String qnATitle) {
		QnATitle = qnATitle;
	}
	public void setQnAContent(String qnAContent) {
		QnAContent = qnAContent;
	}
	public void setQnAWriter(Date qnAWriter) {
		QnAWriter = qnAWriter;
	}
	
	
}
