package day06;

import java.util.Scanner;

public class ForTask {

	public static void main(String[] args) {
		// 1. 1 2 3 4 ... 10 ����ϱ�
		// 2. 1���� 100���� ���� �� ¦���� ���η� ����ϱ�   2 4 6 8 ... 100
		// 3. 10 9 8 7 ... 1 ����ϱ�
		// 4. 1���� 10������ ���� ���� ����ϱ�
		// 5. ������ 3�� ����ϱ�
		//---3��---
		// 3x1=3
		// 3x2=6
		// ...
		// 3x9=27
		
		System.out.println("1������======================");
		
		for(int i = 1; i<=10; i++)
		{
			System.out.print(i+" ");
		}
		System.out.println(" ");
		System.out.println("2������======================");
		
		for(int i = 1; i<=100; i++)
		{
			if(i%2==0)
			{
				System.out.print(i+" ");
			}
		}
		System.out.println(" ");
		System.out.println("3������=====================");
		
		for(int i=10; i>=1; i--)
		{
			System.out.print(i+" ");
		}
		System.out.println(" ");
		System.out.println("4������=====================");
		
		int sum = 0;
		for(int i=1; i<=10; i++)
		{
			sum += i;
		}
		System.out.print(sum+" ");
		
		System.out.println(" ");
		System.out.println("5������=====================");
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		for(int j=1; j<=9; j++)
		{
			System.out.println(k+"*"+j+"="+k*j);
		}
	
	}

}
