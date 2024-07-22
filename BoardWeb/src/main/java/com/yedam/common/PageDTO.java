package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int page; // 현재페이지.
	private int startPage, endPage; // << 11 ....... 20 >> 시작 페이지, 끝 페이지 (페이지 네비게이션에서 표시될 범위)
	private boolean prev, next; // 이전 페이지, 다음 페이지 버튼 활성화
	
	// 생성자
	public PageDTO(int page, int totalCnt) {
		// page: 13, totalCnt: 88 (18page)
		this.page = page; // endPage로 계산하는 게 쉬움.
		this.endPage = (int)(Math.ceil(page / 10.0) * 10); // 2*10 // 현재 페이지 번호를 기준으로 끝 페이지 번호 계산 (10단위)
		this.startPage = this.endPage - 9; // 마지막 20일 경우 11부터 시작 (10개 페이지씩 표시)
		
		int realEnd = (int)Math.ceil(totalCnt / 5.0); // 실제건수 계산한 마지막 페이지.
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage; // 계산된 끝 페이지 번호가 실제 마지막 페이지 번호보다 큰 경우 조정
		
		this.prev = this.startPage > 1; // 시작 페이지 번호가 1보다 큰 경우 '이전' 버튼 활성화
		this.next = this.endPage < realEnd; // 끝 페이지 번호가 실제 마지막 페이지 번호보다 작은 경우 '다음' 버튼 활성화
	}
	
}	
