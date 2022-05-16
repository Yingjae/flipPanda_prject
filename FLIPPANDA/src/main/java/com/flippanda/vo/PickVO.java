package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PickVO {
	private int pickNum;
	private int userNum;
	private int auctionNum;
	private Date pickDate;
}
