package com.lec.java.collection07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// TODO
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기
		
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("C++");
		set.add("hard");
		set.add("very");
		set.add("tired");
		
		for(String s : set) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("===수정 후===");
		set.remove("tired");
		set.add("happy");
		
		for(String s : set) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("===iterator 출력===");
		Iterator<String> ite = set.iterator();
		
		while(ite.hasNext()) {
			System.out.print(ite.next()+" ");
		}
		System.out.println();
		
		// 기존의 List에서 중복된 값을 제거하기 ( Set<> 사용 )
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(10);
		
		System.out.println(list);
		
		// 기존의 List<>로부터 Set<> 생성
		Set<Integer> set2 = new HashSet<Integer>(list);
		System.out.println(set2);
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















