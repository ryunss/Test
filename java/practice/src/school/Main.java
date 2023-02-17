package school;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("학생 성적 관리 프로그램 v1.0");
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		
		while(true) {
			System.out.println("1. 성적 등록\n2. 성적 수정\n3. 학생 자퇴\n4. 점수조회 \n5. 나가기");
			System.out.print("입력 >> ");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				System.out.println("종료");
				break;
			}
			
			switch(choice) {
			case 1: // 성적 등록
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("반 : ");
				int room = sc.nextInt();
				System.out.print("번호 : ");
				int num = sc.nextInt();
				
				System.out.print("국어점수 : ");
				double kor = sc.nextDouble();
				System.out.print("수학점수 : ");
				double math = sc.nextDouble();
				System.out.print("영어점수 : ");
				double eng = sc.nextDouble();
				
				manager.insert(name, room, num, kor, math, eng);
				
				System.out.println(name + " 점수 등록이 완료되었습니다.");
				break;
			case 2: // 성적 수정
				System.out.print("반 : ");
				room = sc.nextInt();
				System.out.print("번호 : ");
				num = sc.nextInt();
				System.out.print("수정할 과목 : ");
				String subj = sc.next();
				System.out.print("새로운 점수 : ");
				int newScore = sc.nextInt();
				
				System.out.println(manager.update(room, num, subj, newScore));
				break;
			case 3: // 학생 자퇴
				System.out.print("반 : ");
				room = sc.nextInt();
				System.out.print("번호 : ");
				num = sc.nextInt();
				
				System.out.print("자퇴하시겠습니까 ? (진심을 정자로 쓰세요) : ");
				String real = sc.next();
				if(real.equals("진심")) {
					System.out.println(manager.delete(room, num));
				}else {
					System.out.println("다시 한번 생각해보세요~");
				}
				break;
			case 4: // 점수조회
				System.out.print("반 : ");
				room = sc.nextInt();
				System.out.print("번호 : ");
				num = sc.nextInt();
				
				System.out.println(manager.search(room, num));
				break;
			}
		}
	}

}
