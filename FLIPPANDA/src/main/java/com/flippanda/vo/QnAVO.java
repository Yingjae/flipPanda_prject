package com.flippanda.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class QnAVO {
	private int qnaNum;
	private int userNum;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaDate;
	private Date qnaUpdateDate;
	private String qnaWriter;
	private int qnareplyCount;
	private String userNick;
	private boolean qnaSecret;
}


