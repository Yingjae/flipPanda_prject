package com.flippanda.auctionFunk;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class auctionVO {
	
		private Long auction_num; 
		
		//Auction details //
		private String auction_title;
		private String product_name;
		private String product_category;
		private String auction_description;
		private String user_num;
		
		// Broadcast bid amount, idk much bout auction_log logic btw //
		private int start_amount;
		private double current_amount;
		private double close_amount;

		// Bidding information of user in active auction //
		private List<bidVO> bid_info;
		
		// "1" = true / "0" = false
		private String launch_auction;
		// Possible to bidding or not //
		private String bid_available;
		
		// Ready to Buy price //
		private double RTB_price;
		
		// RTB information //
		private String soldout;
		
		private Date launch_date;
		private Date update_date;
		
		
	}


