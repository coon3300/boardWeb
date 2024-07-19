package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int page; // 현재페이지.
	private int startPage, endPage; // << 11 12 13 14 ... 20 >>
	private boolean prev, next; // 이전 페이지, 다음 페이지
	
	// 생성자
	public PageDTO(int page, int totalCnt) {
		// page: 13, totalCnt: 88 (18page)
		this.page = page; // endPage로 계산하는 게 쉬움.
		this.endPage = (int)(Math.ceil(page / 10.0) * 10); // 2*10
		this.startPage = this.endPage - 9; // 11
		
		int realEnd = (int)Math.ceil(totalCnt / 5.0); // 실제건수 계산한 마지막 페이지.
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
}	
