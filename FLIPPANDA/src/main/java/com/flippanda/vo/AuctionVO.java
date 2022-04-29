package com.flippanda.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AuctionVO {
	private int auctionNum;
	private int adminNum;
	private int startPrice;
	private int currentPrice;
	private int endPrice;
	private int instandBid;
	private int bidUser;
	private int bidCount;
	
	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
	public void setEndPrice(int endPrice) {
		this.endPrice = endPrice;
	}
	public void setBidUser(int bidUser) {
		this.bidUser = bidUser;
	}
	public void setBidCount(int bidCount) {
		this.bidCount = bidCount;
	}
	
	
}
