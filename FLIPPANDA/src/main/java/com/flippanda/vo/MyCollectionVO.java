package com.flippanda.vo;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class MyCollectionVO {
	private long collectionNum;
	private long userNum;
	private String collectionNick;
	private String collectionTitle;
	private String collectionContent;
	private Date collectionDate;
	private Date collectionUpdateDate;
	private long collectionLike;
	private String collectionFname;
	
	private List<CollectionAttachVO> attachList;
}
