package com.flippanda.vo;

import java.sql.Date;

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
}

// userNum으로 user_tbl에 있는 userNick 을 받아오고 싶은데
// SELECT * FROM my_collection_tbl WHERE user_num LIKE (SELECT * FROM user_tbl WHERE user_nick);
