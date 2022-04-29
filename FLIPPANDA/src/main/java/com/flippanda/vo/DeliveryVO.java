package com.flippanda.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DeliveryVO {
	private int deliveryNum;
	private int deliveryCompanyNum;
	private int userNum;
	private int auctionNum;
	private String deliveryRequest;
	private String PayType;
	
	public void setDeliveryCompanyNum(int deliveryCompanyNum) {
		this.deliveryCompanyNum = deliveryCompanyNum;
	}
	public void setDeliveryRequest(String deliveryRequest) {
		this.deliveryRequest = deliveryRequest;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	
	
}
