package test01;

import java.util.Scanner;

public class Main25 {

	public static void main(String[] args) {
		// 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=1; i<=a; i++)
		{
			for(int j=1; j<=b; j++)
			{
				System.out.print(j*i+" ");
				if(b==j)
				{
					System.out.println();
					
				}
			}
		}
	}
}
