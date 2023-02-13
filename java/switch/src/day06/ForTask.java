package day06;

import java.util.Scanner;

public class ForTask {

	public static void main(String[] args) {
		// 1. 1 2 3 4 ... 10 출력하기
		// 2. 1부터 100까지 숫자 중 짝수만 가로로 출력하기   2 4 6 8 ... 100
		// 3. 10 9 8 7 ... 1 출력하기
		// 4. 1부터 10까지의 숫자 총합 출력하기
		// 5. 구구단 3단 출력하기
		//---3단---
		// 3x1=3
		// 3x2=6
		// ...
		// 3x9=27
		
		System.out.println("1번문제======================");
		
		for(int i = 1; i<=10; i++)
		{
			System.out.print(i+" ");
		}
		System.out.println(" ");
		System.out.println("2번문제======================");
		
		for(int i = 1; i<=100; i++)
		{
			if(i%2==0)
			{
				System.out.print(i+" ");
			}
		}
		System.out.println(" ");
		System.out.println("3번문제=====================");
		
		for(int i=10; i>=1; i--)
		{
			System.out.print(i+" ");
		}
		System.out.println(" ");
		System.out.println("4번문제=====================");
		
		int sum = 0;
		for(int i=1; i<=10; i++)
		{
			sum += i;
		}
		System.out.print(sum+" ");
		
		System.out.println(" ");
		System.out.println("5번문제=====================");
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		for(int j=1; j<=9; j++)
		{
			System.out.println(k+"*"+j+"="+k*j);
		}
	
	}

}
