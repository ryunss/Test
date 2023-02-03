package com.lec.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor // 모든 매개변수(6개임 여기선)를 받는 생성자가 하나 만들어짐
public class WriteDTO {
	private int id;
	private String subject;
	private String content;
	private String name;
	private int viewCnt;
	private LocalDateTime regDate;
	
	public String getRegDateTime() {
		return this.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	}
}
