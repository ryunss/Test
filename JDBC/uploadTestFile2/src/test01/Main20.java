package test01;

import java.util.Scanner;

public class Main20 {

	public static void main(String[] args) {
		// 정수를 입력받아서 1부터 입력받은 정수까지의 5의 배수의 합을 구하여 출력하는 프로그램을 작성.
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		int a = sc.nextInt();
		
		for(i=1; i<=a; i++)
		{
			if(i%5==0)
			{
				sum +=i;
			}
		}
		System.out.println(sum);
	}
}
