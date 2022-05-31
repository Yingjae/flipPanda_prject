package com.flippanda.vo;

import lombok.Data;

@Data
public class CollectionAttachVO {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	
	private long collectionNum;
}
