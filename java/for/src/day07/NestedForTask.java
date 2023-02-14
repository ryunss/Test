package day07;

import java.util.Iterator;

public class NestedForTask {

	public static void main(String[] args) {
		// 1.
		// *****
		// *****
		// *****
		// *****
		// *****
		
		for(int i = 0; i<5; i++)
		{
			for(int j = 0; j<5; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println();
		System.out.println();
		
		// 2.
		// *
		// **
		// ***
		// ****
		// *****
		
		for(int i = 0; i<5; i++)
		{
			for(int j = 0; j<(i+1); j++)
			{
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println();
		
		// 3.
		//     *
		//    **
		//   ***
		//  ****
		// *****
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4-i; j++) { // 띄어쓰기 출력 for문
				System.out.print(" ");
			}
			for(int j = 0; j < i+1; j++) { //별 출력 for문
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(j < 4-i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for (int j = 1; j <= 5; j++) {
			for (int k = 5; k > 0; k--) {
				if (j < k) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		
		// 구구단 2단부터 9단 출력하기
		
		for(int dan = 2; dan<=9; dan++)
		{
			System.out.println("---"+dan+"단---");
			for(int i = 1; i <=9; i++ ) {
				System.out.println(dan + "x" + i + "=" + dan *i);
			}
		}
	}

}
