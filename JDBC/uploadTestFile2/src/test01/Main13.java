package test01;

import java.util.Scanner;

public class Main13 {

	public static void main(String[] args) {
		// 100 이하의 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int a = sc.nextInt();
		int sum = 0;
		
		for(i=0; i<=100; i++)
		{
			if(i>=a)
			{
				sum +=i;
			}
		}
		System.out.println(sum);
			
	}

}
