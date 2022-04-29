package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AuctionLogVO {
	private int auctionLogNum;
	private int auctionNum;
	private Date auctionDate;
	private int auctionPrice;	
}
