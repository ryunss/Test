package test01;

import java.util.Scanner;

public class Main19 {

	public static void main(String[] args) {
		// 100 이하의 두 개의 정수를 입력받아 작은 수부터 큰 수까지 차례대로 출력하는 프로그램 작성
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int j = 0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
			if(a>=b)
			{
				for(i=b; i<=a; i++)
				{
					System.out.print(i+" ");
				}
			}
			else if(b>=a)
			{
				for(j=a; j<=b; j++)
				{
					System.out.print(j+" ");
				}
			}
		
	}

}
