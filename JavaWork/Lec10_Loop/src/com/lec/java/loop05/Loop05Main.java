package com.lec.java.loop05;

import java.util.Scanner;

public class Loop05Main {

	public static void main(String[] args) {
		System.out.println("순환문 연습 - 언제 100을 넘나?");
		// 1 + (-2) + 3 + (-4) + ...+ (n) >= 100 ?
		// 언제(n) 합이 100을 넘나? 그 합은?
		int i = 1;
		int sum = 0;
		while (true) {
			if (i % 2 == 0) {
				System.out.println(-i);
				sum -= i;
			} else if (i % 2 == 1) {
				System.out.println(+i);
				sum += i;
			}

			if (sum >= 100) {
				System.out.println("합 : " + sum);
				break;
			}
			i++;
		}

		System.out.println();
		System.out.println("순환문 연습 - 두 주사위 눈의 합");
		// 두 주사위 눈의 합 = 6
		// (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
		// x + y = 6를 만족하는 x, y 쌍을 찾으면 됨.

		Scanner sc = new Scanner(System.in);

		System.out.print("두 주사위 눈의 합을 입력하세요 >> ");
		int num = sc.nextInt();

		for (int x = 1; x <= num; x++) {

			for (int y = 1; y <= num; y++) {

				if (x + y == num) {
					System.out.print("(" + x + ", " + y + ")");

					if (!(y == 1)) {
						System.out.print(", ");
					}
				}
			}
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
