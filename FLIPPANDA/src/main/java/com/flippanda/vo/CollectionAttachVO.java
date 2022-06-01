package com.flippanda.vo;

import lombok.Data;

@Data
public class CollectionAttachVO {
	// 테이블 내에 있는 컬럼
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private long collectionNum;
}

