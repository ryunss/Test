package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");
		// 구구단 2단 ~ 9단

		// 2 x 1 = 2
		// ..
		// 2 x 9 = 18
		// 3 x 1 = 3
		// ..
		// 3 x 9 = 27
		// ...
		// 9 x 1 = 9
		// ..
		// 9 x 9 = 81

		// 구구단 출력 : 중첩 for 사용

		for (int i = 2; i <= 9; i++) {
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		
		System.out.println("중첩 while문 사용해서 구구단 만들기");
		int i=2;
		while(i<=9) {
			System.out.println(i+"단");
			int j=1;
			while(j<=9) {
				System.out.println(i+" * "+j+" = "+ i*j);
				j++;
			}
			i++;
			System.out.println();
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
