package com.lec.java.inherit03;

public class BusinessPerson extends Person {
	String company;

	public void showInfo() {
		super.whoAmI();
		System.out.println("회사는 " + company + "입니다");
	}
}
