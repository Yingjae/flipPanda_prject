package com.flippanda.auctionFunk;

import java.sql.Date;

import lombok.Data;

@Data
public class bidVO {

	private Double bid_amount;
	private int bid_count;
	private Date bid_time;

}
