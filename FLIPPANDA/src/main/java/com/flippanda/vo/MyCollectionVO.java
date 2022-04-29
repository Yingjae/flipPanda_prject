package com.flippanda.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MyCollectionVO {
	private int collectionNum;
	private int userNum;
	private String collectionTitle;
	private String collectionContent;
	private Date collectionDate;
	private Date collectionUpdateDate;
	private int CollectionLike;
	
	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}
	public void setCollectionContent(String collectionContent) {
		this.collectionContent = collectionContent;
	}
	public void setCollectionUpdateDate(Date collectionUpdateDate) {
		this.collectionUpdateDate = collectionUpdateDate;
	}
	public void setCollectionLike(int collectionLike) {
		CollectionLike = collectionLike;
	}
	
	
}
