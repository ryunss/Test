package day06;

import java.util.Scanner;

public class SwitchTask {

	public static void main(String[] args) {
		// 사용자에게 월을 입력받아서 해당 월의 마지막 일을 출력하시오
		// 0월은 00일이 마지막 일 입니다.(2월 28일 까지로 가정)
		// 1 31 2 28 3 31 4 30 5 31 6 30 7 31 8 31 9 30 10 31 11 30 12 31
		
		
//		int lastDay = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 방법 1
//		System.out.print("월을 입력하세요 : ");
//		int month = sc.nextInt();
//		
//		switch(month) {
//		case 1:
//		case 3:
//		case 5:
//		case 7:
//		case 8:
//		case 10:
//		case 12:
//			lastDay = 31;
//			break;
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			lastDay = 30;
//			break;
//		case 2:
//			lastDay = 28;
//			break;
//		default:
//				System.out.println("잘못 입력하셨습니다.");
//				break;
//		}
//		
//		if(lastDay != 0) {
//			System.out.println(month + "월은 " + lastDay + " 일이 마지막 일입니다.");
//		}
		// ------------------------------------------------------------------
		// 방법2
//		switch(month) {
//		case 1:
//			System.out.println(month+"월은 31일이 마지막 일입니다.");
//			break;
//		case 2:
//			System.out.println(month+"월은 28일이 마지막 일입니다.");
//			break;
//		case 3:
//			System.out.println(month+"월은 31일이 마지막 일입니다.");
//			break;
//		case 4:
//			System.out.println(month+"월은 30일이 마지막 일입니다.");
//			break;
//		case 5:
//			System.out.println(month+"월은 31일이 마지막 일입니다.");
//			break;
//		case 6:
//			System.out.println(month+"월은 30일이 마지막 일입니다.");
//			break;
//		case 7:
//			System.out.println(month+"월은 31일이 마지막 일입니다.");
//			break;
//		case 8:
//			System.out.println(month+"월은 31일이 마지막 일입니다.");
//			break;
//		case 9:
//			System.out.println(month+"월은 30일이 마지막 일입니다.");
//			break;
//		case 10:
//			System.out.println(month+"월은 31일이 마지막 일입니다.");
//			break;
//		case 11:
//			System.out.println(month+"월은 30일이 마지막 일입니다.");
//			break;
//		case 12:
//			System.out.println(month+"월은 31일이 마지막 일입니다.");
//			break;
//		default:
//			System.out.println("잘못 입력하셨습니다.");
//			break;
		
		
// 		========================================================
		// 방법 3 . 이 방법은 버전에 따라 동작 안될 수도 있음. 확인.
		int lastDay = 0;
		
		System.out.print("월을 입력하세요 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			lastDay = 31;
			break;
		case 4, 6, 9, 11:
			lastDay = 30;
			break;
		case 2:
			lastDay = 28;
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		
		if(lastDay != 0) {
			System.out.println(month + "월은 " + lastDay + "일이 마지막일입니다.");
		}

		// 사용자에게 점수를 입력 받아서, 학점을 출력하시오.
		// 90 이상, 100점 : A
		// 80 이상 90점 미만 : B
		// 70 이상 80점 미만 : C
		// 그 외 : F
		// 당신의 학점은 F 입니다.
	
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		
		switch(score/10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("F");
			break;
		}
		
		// 실제로 사용할때는 if문 쓰는게 좋음. 조건이 더 까다롭기 때문. ex) 120점 입력, 98.8 입력 등..
	}
}			

		


