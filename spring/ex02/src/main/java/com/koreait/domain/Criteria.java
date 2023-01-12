package com.koreait.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	// 페이징에 필요한 내용들을 객체로 만들기 위해 만든 클래스
	// list.jsp에서 게시글 목록을 띄워줄 때 그 목록의 기준
	private int pagenum;
	private int amount;
	private String type;
	private String keyword;
	private int startrow;
	
	public Criteria() {
		this(1,10); // 1, 10을 넘기기 때문에 기본은 1 pagenum, 10 amount 로 세팅 된다.
	}
	
	// 검색을 하지 않았을 때
	public Criteria(int pagenum, int amount) {
		this.pagenum = pagenum;
		this.amount = amount;
		this.startrow = (this.pagenum-1) * this.amount;
	}
	
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
		this.startrow = (this.pagenum-1) * this.amount;
	}
	
	public String[] getTypeArr() { // 이거를 #{typeArr} 로 사용할 수 있다.
		// type 이 null 이라면 return {}
		// type 이 "TC"라면 return {"T", "C"}
		return type == null ? new String[] {} : type.split("");
	}
}
