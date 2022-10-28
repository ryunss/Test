package test;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		
//		2. 비회원 게시판 프로그램을 만들던 비오는 각 게시글의 데이터를 위해 게시글 클래스를 구현하려 합니다. 
//		그 때 게시글 데이터는 무엇이 있는지 작성하고 게시글 클래스를 구현하여 텍스트로 작성하세요
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 게시글 등록 \n2. 나가기");
			System.out.print("번호 입력 >> ");
			int choice = sc.nextInt();
			if(choice == 2) {
				System.out.println("안녕히 가세요");
				break;
			}
			switch(choice) {
			case 1:
				View v = new View();
				v.joinview();
				break;
			}
		}
	}
}
