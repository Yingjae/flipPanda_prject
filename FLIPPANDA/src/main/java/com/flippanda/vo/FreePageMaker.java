package com.flippanda.vo;

import lombok.Data;

@Data
public class FreePageMaker {

	private int totalBoard;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum;
	
	private FreeSearchCriteria freecri;
	
	public void calcData() {
		// 한 페이지에 하단에 깔고싶은 버튼 개수
		this.displayPageNum = 10;
		
		// 현재 페이지(cri.getPageNum())을 근거로 페이지 그릅중 끝나는 페이지를 구함.
		this.endPage = (int)(Math.ceil(freecri.getPageNum() /
				(double) displayPageNum) * displayPageNum);
		
		// 끝나는 페이지를 토대로 페이지 그룹의 시작페이지를 구함
		this.startPage = (endPage - displayPageNum) + 1;
		
		// 위의 endPage는 명목상의(단순 그룹계산으로) 끝나는 페이지이기때문에 실질적인 글 개수를 통해 보정
		int tempEndPage = (int)(Math.ceil(totalBoard / (double)freecri.getNumber()));
		if(endPage > tempEndPage) {
			endPage =  tempEndPage;
		}
		
		// next, prev버튼 여부
		
		// prev는 startPage가 1인 경우에만 비활성화 이므로 삼항연산자로 간단히 처리
		prev = startPage == 1 ? false : true;
		
		// next는 여태까지 출력한 페이지에 속한 글 개수보다 DB내 전체 글이 더 많은경우 활성화
		next = endPage * freecri.getNumber() >= totalBoard ? false : true;
				
	}
	
	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
		calcData(); // prev, next, endPage, startPage 
	}
	
	
}
