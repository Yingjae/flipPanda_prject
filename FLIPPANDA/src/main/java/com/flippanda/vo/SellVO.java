package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SellVO {
	private int sellNum;
	private int auctionNum;
	private Date sellDate;	
}
