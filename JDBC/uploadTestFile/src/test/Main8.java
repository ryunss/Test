package test;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		// 0 이 입력될 때까지 정수를 계속 입력받아 3의 배수와 5의 배수를 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.
		// 1 2 3 4 5 6 7 8 9 10 0 출력예 : 5
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int count = 0;
		
		while(true)
		{
			int a = sc.nextInt();
			
			if(a==0)
			{
				System.out.println(count-cnt);
				break;
			}
			else if(a%3==0 || a%5==0)
			{
				cnt++;
			}
			count++;
			
		}
	}

}
