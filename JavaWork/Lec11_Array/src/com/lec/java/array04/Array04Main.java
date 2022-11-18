package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];
		int sum = 0;
		
		for (int i = 0; i < score.length; i++) {			
			System.out.print("점수 입력 : ");
			score[i] = sc.nextInt();
			sum += score[i];
		}
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+(double)sum/score.length);
		int max = score[0];
		int min = score[0];
		
		for(int i=1; i<score.length; i++) {
			if(max < score[i]) {
				max = score[i];
			}
			
			if(min > score[i]) {
				min = score[i];
			}
		}

		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array04Main








