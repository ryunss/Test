package com.lec.java;

public class Hello {
	public static void main(String[] args) {
		
		
		String str = "Asdkf Askdfjk Nfenj Dnjkfes Djfe ";
		String a = str.toLowerCase();
		String[] splits = a.split("\\+s");
		
		System.out.println(splits.length);
	}
}
