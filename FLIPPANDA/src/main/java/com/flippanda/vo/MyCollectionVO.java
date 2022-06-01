package com.flippanda.vo;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class MyCollectionVO {
	// 테이블 내에 있는 컬럼
	private long collectionNum;
	private long userNum;
	private String collectionTitle;
	private String collectionContent;
	private Date collectionDate;
	private Date collectionUpdateDate;
	private long collectionLike;
	
	// 쿼리를 통해 userNum을 비교하여 userNick을 받아야함
	private String collectionNick;
	
	// 파일 업로드 
	private String collectionFname;
	
	private List<CollectionAttachVO> attachList;
}
