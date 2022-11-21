package com.lec.java.class06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter // 게터 생성
//@Setter // 세터 생성
//@ToString // tostring 생성 (오버로딩)
@NoArgsConstructor // 기본생성자(디폴트생성자) 생성
@AllArgsConstructor // 매개변수생성자 생성 (디폴트생성자는 만들어줘야함)
@RequiredArgsConstructor // @NonNull 이 붙은 필드 생성자
					// 프리미티타입은 안됨. 그래서 integer 썻음
@Data // getter, setter, toString, equals, hashCode 다 생성

@Builder // builder 패턴 제공

public class Score {
	
	@NonNull
	private String name;
	@NonNull
	private Integer kor;
	private Integer eng;
	private Integer math;
	
	
}


















