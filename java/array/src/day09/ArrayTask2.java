package day09;

import java.util.Scanner;

public class ArrayTask2 {

	public static void main(String[] args) {
		// 1. ����ڿ��� �Է¹��� ������ ������ �Է¹޴´�.
		// �Է¹��� ������ ���� >> 5
		// ���� 1 �Է� >> 10
		// ���� 2 �Է� >> 84
		// ���� 3 �Է� >> 15
		// ���� 4 �Է� >> 25
		// ���� 5 �Է� >> 7
	
		// ���
		// {10, 84, 15, 25, 7}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է¹��� ������ ���� : ");
		int n = sc.nextInt();
		int num[] = new int[n];
		
		for(int i=0; i<num.length; i++) {
			System.out.print("����"+(i+1)+"�Է� >> ");
			num[i] = sc.nextInt();
		}
		System.out.print("{");
		for(int i=0; i<num.length; i++) {
			if(i==num.length-1) {
				System.out.print(num[i]);
				break;
			}
			System.out.print(num[i]+", ");
		}
		System.out.println("}");
		
		// 2. �ش� �迭 �ӿ��� �ִ� ����ϱ�
		// ���
		// �ִ� : 84
		
		int max = num[0];
		for(int i=0; i<num.length; i++)
		{
			if(num[i] > max)
			{
				max = num[i];
			}
		}
			System.out.println(max);
		// 3. �ش�迭 �ӿ��� �ּڰ� ����ϱ�
		// ���
		// �ּڰ� : 7
			
		int min = num[0];
		for(int i=0; i<num.length; i++)
		{
			if(num[i] < min)
			{
				min = num[i];
			}
		}
		System.out.println(min);
		
		
	}

}
