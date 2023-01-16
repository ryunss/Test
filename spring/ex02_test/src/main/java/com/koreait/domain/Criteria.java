package com.koreait.domain;

import org.springframework.web.util.UriComponentsBuilder;

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
	
	public String getListLink() {
		// uri를 만들어내는 클래스									
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("") // ? 앞에 붙는 uri 문자열. 즉 빈문자열
											.queryParam("pagenum", pagenum) // 파라미터 주가
											.queryParam("amount", amount)
											.queryParam("keyword", keyword)
											.queryParam("type", type);
		// ?pagenum=4&amount=10&keyword=apple&type=T 이런식으로 만들어짐.
		return builder.toUriString(); // 빌더가 가지고 있는 설정대로 문자열 만들기				
	}
}
