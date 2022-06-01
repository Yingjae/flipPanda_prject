package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreeBoardReplyVO {
	private long freeBoardReplyNum;
	private long userNum;
	private Long freeBoardNum;
	private String freeBoardReplyContent;
	private String freeBoardReplyer;
	private Date freeBoardReplyReplyDate;
	private Date freeBoardReplyUpdateDate;
	private String freeBoardReplyNick;
	
	
}
