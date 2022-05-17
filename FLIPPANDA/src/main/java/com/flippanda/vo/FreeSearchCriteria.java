package com.flippanda.vo;

import lombok.Data;

@Data
public class FreeSearchCriteria extends FreeCriteria {

	private String searchType;
	private String keyword;
}