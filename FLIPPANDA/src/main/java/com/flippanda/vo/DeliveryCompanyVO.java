package com.flippanda.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DeliveryCompanyVO {
	private int deliveryCompanyNum;
	private String deliveryCompanyTitle;
	private String deliveryCompanyCallNum;
	
	public void setDeliveryCompanyTitle(String deliveryCompanyTitle) {
		this.deliveryCompanyTitle = deliveryCompanyTitle;
	}
	public void setDeliveryCompanyCallNum(String deliveryCompanyCallNum) {
		this.deliveryCompanyCallNum = deliveryCompanyCallNum;
	}
	
	
}
