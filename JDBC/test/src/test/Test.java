package test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// 2. 빅뱅고등학교의 수학교사 권지용은 학생들의 점수 평균이 궁금해졌습니다. 학생들의 인원수와 점수들을 입력받고 평균을 구해주는 코드를 작성하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생들의 인원 수 >> ");
		int std = sc.nextInt();
		int sum = 0;
		int[] score = new int[std];
		
		for(int i=0; i<std; i++) {
			System.out.print("학생들의 점수 입력 >> ");
			score[i] = sc.nextInt();
		}
		
		for(int a : score) {
			sum+=a;
		}

		System.out.println("학생들의 인원수 : "+std);
		System.out.println("학생들의 점수 총합 : "+sum);
		System.out.println("학생들의 점수 평균 : "+sum/std);
	}

}
