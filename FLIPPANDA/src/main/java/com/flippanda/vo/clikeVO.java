package com.flippanda.vo;

import lombok.Data;

@Data
public class clikeVO {
	
	// 테이블 내에 있는 컬럼
	private long clikeNum;
	private long collectionNum;
	private long userNum;
	// 좋아요가 눌렸는지 여부
	private long count;
}
						
