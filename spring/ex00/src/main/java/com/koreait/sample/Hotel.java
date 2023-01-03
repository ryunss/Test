package com.koreait.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
// 인스턴스변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성한다.
//@AllArgsConstructor 
// 특정 변수를 위한 생성자를 만들때 작성한다. final이나 @NonNull이 붙은 인스턴스 변수에 대한 생성자를 만들어 낸다.
@RequiredArgsConstructor 
@Component
public class Hotel {
	@NonNull
	private Chef chef;
}
