package com.lec.java.for02;

public class For02Main {
//	구구단 2단
//	2 x 1 = 2
//	2 x 2 = 4
//	2 x 3 = 6
//	2 x 4 = 8
//	2 x 5 = 10
//	2 x 6 = 12
//	2 x 7 = 14
//	2 x 8 = 16
//	2 x 9 = 18

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");

		for (int i = 1; i <= 9; i++) {
			System.out.println(2 + " * " + i + " = " + (i * 2));
		}
		
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			System.out.println(i + " * " + i + " = " + (i * i));
		}

	} // end main()

} // end class For02Main
