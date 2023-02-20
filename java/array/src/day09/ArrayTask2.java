package day09;

import java.util.Scanner;

public class ArrayTask2 {

	public static void main(String[] args) {
		// 1. 사용자에게 입력받을 정수의 갯수를 입력받는다.
		// 입력받을 정수의 갯수 >> 5
		// 정수 1 입력 >> 10
		// 정수 2 입력 >> 84
		// 정수 3 입력 >> 15
		// 정수 4 입력 >> 25
		// 정수 5 입력 >> 7
	
		// 출력
		// {10, 84, 15, 25, 7}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력받을 정수의 갯수 : ");
		int n = sc.nextInt();
		int num[] = new int[n];
		
		for(int i=0; i<num.length; i++) {
			System.out.print("정수"+(i+1)+"입력 >> ");
			num[i] = sc.nextInt();
		}
		System.out.print("{");
		for(int i=0; i<num.length; i++) {
			if(i==num.length-1) {
				System.out.print(num[i]);
				break;
			}
			System.out.print(num[i]+", ");
		}
		System.out.println("}");
		
		// 2. 해당 배열 속에서 최댓값 출력하기
		// 출력
		// 최댓값 : 84
		
		int max = num[0];
		for(int i=0; i<num.length; i++)
		{
			if(num[i] > max)
			{
				max = num[i];
			}
		}
			System.out.println(max);
		// 3. 해당배열 속에서 최솟값 출력하기
		// 출력
		// 최솟값 : 7
			
		int min = num[0];
		for(int i=0; i<num.length; i++)
		{
			if(num[i] < min)
			{
				min = num[i];
			}
		}
		System.out.println(min);
		
		
	}

}
