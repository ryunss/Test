package test;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		// 정수를 입력받아 1부터 입력받은 정수까지를 차례대로 출력하는 프로그램을 작성하시오.
		// ex) 5         1 2 3 4 5
		
		Scanner sc = new Scanner(System.in);
		int i;
		
		int a = sc.nextInt();
		
		for(i=1; i<=a; i++)
		{
			System.out.print(i);
			System.out.print(" ");
		}
	}

}
