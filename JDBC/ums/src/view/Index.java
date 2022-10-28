package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		System.out.println("220929 국비반 최종 프로젝트 UMS");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 나가기");
			int choice = sc.nextInt();
			if(choice == 3) {
				System.out.println("다음에 또 오세요~");
				break;
			}
			else if(choice == 1) {
				//회원가입
				new JoinView();
			}
			else if(choice == 2) {
				//로그인
				new LoginView();
			}
		}
	}
}





