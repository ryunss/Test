package day07;

import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		// 3. 10 9 8 7 ... 1 ����ϱ�
		int num = 10;
		
		for(int i = 0; i<10; i++)
		{
			System.out.print(num + " ");
			num--;
		}
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������� ������ ���ұ��?");
		int num1 = 10;// sc.nextInt();
	      // 4. 1���� 10������ ���� ���� ����ϱ�
	    int sum = 0;
		
		for(int i = 1; i<=num1; i++) {
			sum+=i;
		}
		System.out.println(sum);
		System.out.println("-------------------------");
		
		System.out.println("����� ����ұ��?");
		int dan = sc.nextInt();
		
		System.out.println("---"+ dan + "��---");
		
		for(int i = 1; i<=9; i++) {
			System.out.println(dan + "x" + i + "=" + (dan*i));
		}
		
	      // 5. ������ 3�� ����ϱ�
	      // ---3��---
	      // 3x1=3
	      // 3x2=6
	      // 3x3=9
	      // 3x4=12
	      // 3x5=15
	      // 3x6=18
	      // 3x7=21
	      // 3x8=24
	      // 3x9=27
		
		
	}

}
