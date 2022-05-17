package com.flippanda.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class auctionLogVO {
		
		private int auction_log_num; 
		
		private Long auction_num;
		
		private int user_num;
		
		private Date auction_log_date;
		
		private int auction_bid_log; 
		
	}


