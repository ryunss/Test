package day10;

import java.util.Scanner;

public class MethodTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MethodTask.printName(sc.nextLine(), 3);
		
		MethodTask.age(20);
		
		MethodTask.arr(20);
	}
	
	// ����ڿ��� �̸��� �ݺ�Ƚ���� �Է¹ް� �̸� ����ϴ� �޼ҵ� �����
	public static void printName(String name, int num) {
		for(int i=0; i<num; i++) {
			System.out.println(name);
		}
	}
	// ����ڿ��� ���̸� �Է¹ް� �������� �̼��������� �Ǻ��ϴ� �޼ҵ� �����
	public static void age(int a) {
		if(a>=20) {
			System.out.println("�����Դϴ�.");
		}else {
			System.out.println("�̼������Դϴ�.");
		}
	}
	// �迭�� �迭 ������� ����ϴ� �޼ҵ� �����
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
