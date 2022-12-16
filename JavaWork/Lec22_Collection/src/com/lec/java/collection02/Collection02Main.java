package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		// TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		// for, Enhanced-for, Iterator

		ArrayList<String> a = new ArrayList<>();

		a.add("Hello");
		a.add("java");
		a.add("oh..");
		a.add("health");
		a.add("rainbow");

		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
		System.out.println("수정 후");
		a.set(1, "C#");
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
		System.out.println("삭제 후");
		a.remove(2);
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();

		System.out.println("foreach");
		for (String b : a) {
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println("Iterater");

		Iterator<String> ite = a.iterator();
		while (ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}
		System.out.println();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
