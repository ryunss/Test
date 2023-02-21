package day10;

import java.util.Scanner;

public class MethodTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MethodTask.printName(sc.nextLine(), 3);
		
		MethodTask.age(20);
		
		MethodTask.arr(20);
	}
	
	// 사용자에게 이름과 반복횟수를 입력받고 이를 출력하는 메소드 만들기
	public static void printName(String name, int num) {
		for(int i=0; i<num; i++) {
			System.out.println(name);
		}
	}
	// 사용자에게 나이를 입력받고 성인인지 미성년자인지 판별하는 메소드 만들기
	public static void age(int a) {
		if(a>=20) {
			System.out.println("성인입니다.");
		}else {
			System.out.println("미성년자입니다.");
		}
	}
	// 배열을 배열 모양으로 출력하는 메소드 만들기
	public static void arr(int a) {
		System.out.print("{");
		for(int i=0; i<a; i++) {
			if(i==a-1) {
				System.out.print(i+1+"}");
				break;
			}
			System.out.print(i+1+", ");
		}
	}

}
