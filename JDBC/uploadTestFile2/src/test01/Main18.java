package test01;

import java.util.Scanner;

public class Main18 {

	public static void main(String[] args) {
		// 10 이하의 자연수 n을 입력받아 "JUNGOL"을 n번 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int i = 0;
		
		for(i=0; i<a; i++)
		{
			System.out.println("JUNGOL");
		}
		
	}

}
