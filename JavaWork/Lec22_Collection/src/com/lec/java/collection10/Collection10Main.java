package com.lec.java.collection10;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");

		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		Set<String> set = new TreeSet<>();
		
		set.add("Java");
		set.add("haryun");
		set.add("C#");
		set.add("house");
		set.add("exception");

		Iterator ite = set.iterator();

		while (ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}
		System.out.println();
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class
