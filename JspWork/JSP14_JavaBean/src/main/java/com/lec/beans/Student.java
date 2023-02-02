package com.lec.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 명시적으로 기본생성자 만듬
public class Student {
	// 필드
	private String name;
	private int age;
	private int grade;
	private char gender;
}
