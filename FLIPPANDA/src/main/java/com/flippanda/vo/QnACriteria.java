package com.flippanda.vo;

import lombok.Data;

@Data
public class QnACriteria {
	
	// 현재 페이지
	private int pageNum;
	
	// 한 페이지 당 보여질 게시물 갯수
	private int amount;
	
	// 스킵 할 게시물 수
	private int skip;
	
	// 기본 생성자 -> 기본 세팅 : pageNum = 1;, amount = 10
	public QnACriteria() {
		this(1,10);
	}
	
	public QnACriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum-1)*amount;
		
	}
	
	public void setPageNum(int pageNum) {
		this.skip= (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.skip = (this.pageNum-1)*amount;
		this.amount = amount;
	}
	
	public int getSkip() {
		return skip;
	}
	
	public void setSkip(int skip) {
		this.skip = skip;
	}

	@Override
	public String toString() {
		return "QnACriteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + "]";
	}
	
	

}
