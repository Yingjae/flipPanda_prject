package com.flippanda.vo;

import java.sql.Date; 

import lombok.Data;

@Data
public class QnAReplyVO {
	private int qnareplyNum;
	private int qnaNum;
	private int adminNum;
	private Date qnareplyDate;
	private Date qnareplyUpdateDate;
	private String qnareplyContent;	
	private String qnareplyer;
	
}
