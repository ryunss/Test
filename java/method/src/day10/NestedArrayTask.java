package day10;

import java.util.Scanner;

public class NestedArrayTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 성적 입출력 프로그램");
		
		String subjects[] = {"국어", "영어", "수학"};
		
		int scores[][] = new int[4][3]; // 점수를 저장할 배열
		
		while(true){
			System.out.println("1. 학생 성적 입력하기");
			System.out.println("2. 학생 성적 평균점수 보기");
			System.out.println("3. 종료");
			
			int choice = sc.nextInt();
			if(choice == 1) {
				for(int i=0; i<scores.length; i++) {
					System.out.println(i+1 +"번 학생 성적 입력");
					for(int j=0; j<scores[i].length; j++) {
						System.out.print(subjects[j] + "점수 입력 >> ");
						scores[i][j] = sc.nextInt();
					}
					System.out.println("--------------------------");
				}
			}else if(choice == 2 ) {
				System.out.print("몇번 학생의 평균점수를 보시겠습니까? ");
				int sum = 0;
				int no = sc.nextInt();
				for(int i=0; i<scores[no-1].length; i++)
				{
					sum+=(double)scores[no-1][i];
				}
				System.out.println(no+"번 학생의 평균점수는 "+(double)(sum/subjects.length)+" 입니다");
			}else if(choice == 3 ) {
				System.out.println("프로그램을 종료합니다");
				break;
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
		}	
	}

}
