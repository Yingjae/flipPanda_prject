package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BuyVO {
	private int buyNum;
	private int auctionNum;
	private Date buyDate;
}
