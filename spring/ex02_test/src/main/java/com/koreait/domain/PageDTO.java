package com.koreait.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private int realEnd;
	private int total;
	private boolean prev;
	private boolean next;
	private Criteria cri;
	
	public PageDTO(int total, Criteria cri) {
		int pagenum = cri.getPagenum();
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)Math.ceil(pagenum/10.0)*10; // 더블타입이기 때문에 int로 바꿈. 바꿔서 반올림
														// ex. 마지막17페이지면 17/10.0 
														// 1.7 반올림하면 2 -> 2*10 20페이지.
		this.startPage = this.endPage - 9;
		this.realEnd = (int)Math.ceil(total*1.0/10); // ex. 168개 있으면 168.0 으로 만들고,
													// 10으로 나누면 16.8 여기서 반올림하면 17 페이지 나옴. 마지막페이지
		this.endPage = endPage > realEnd ? realEnd : endPage;
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
	}
}
