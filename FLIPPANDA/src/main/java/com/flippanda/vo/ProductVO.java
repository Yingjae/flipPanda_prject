package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductVO {
	private int productNum;
	private String productTitle;
	private String productCategory;
	private int productPrice;
	private int userNum;
	private Date productDate;
	private String productImg;
	private int productQuantity;
	private String productStatus;
	
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
	
}
