package com.lec.java.array14;

import java.util.Arrays;

public class Array14Main {

	public static void main(String[] args) {
		System.out.println("Reference 타입 주의할 사항");

		int a = 10;
		int b = 20;

		System.out.println("a: " + a + " b: " + b);

		a = b;

		System.out.println("a: " + a + " b: " + b);

		a = 30;

		System.out.println("a: " + a + " b: " + b);

		// 배열
		int[] arrA = new int[] { 10, 10, 10 };
		int[] arrB = new int[] { 20, 20, 20 };
		System.out.println("A: "+Arrays.toString(arrA)+", B: "+Arrays.toString(arrB));
		
		arrA = arrB;
		System.out.println("A: "+Arrays.toString(arrA)+", B: "+Arrays.toString(arrB));
		
		arrA[0] = 500;
		System.out.println("A: "+Arrays.toString(arrA)+", B: "+Arrays.toString(arrB));
		// ?? arrA[0] 만 500으로 바꿨는데 arrB[0] 도 500으로 바뀜.
		// 메모리상으로 보면 주소의 값이 복사가 되었기 때문 !! heap 에서 !
		// 레퍼런스에서 끊길 때 G.C 에서 알아서 삭제 시킴.
		// A메모리 0x100 B메모리 0x200
		// A 메모리에서 0x100 -> 0x200 으로 바뀜 복사되면서.
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class
