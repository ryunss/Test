package day09;

import java.util.Scanner;

public class ArrayTask {

	public static void main(String[] args) {
		// �迭�� �迭 ������� ����Ͻÿ�.
		// {5, 4, 6, 9, 10}
		int ar[] = {5, 4, 6, 9, 10};
		
		System.out.print("{");
		for(int i=0; i<ar.length; i++) {
			if(i==(ar.length-1)) {
				System.out.print(ar[i]);
				break;
			}
			System.out.print(ar[i]+", ");
					
		}
		System.out.println("}");
			
		
		// 2. ����ڿ��� ��������, ��������, ���������� �Է¹޾�
		// ������ ����� ����Ͻÿ�
		// ���������Է� : 90
		// ���������Է� : 90
		// ���������Է� : 90
		
		Scanner sc = new Scanner(System.in);
		int ar2[] = new int[3];
		String sub[] = {"����", "����", "����"};
		int sum = 0;
		int avg = 0;
		
		for(int i=0; i<ar2.length; i++)
		{
			System.out.print(sub[i]+"�����Է� : ");
			ar2[i] = sc.nextInt();
			sum += ar2[i];
		}
		avg = sum/ar2.length;
		System.out.println("����� ������ "+sum+"��, ����� "+avg +"���Դϴ�.");
		// ����� ������ 270��, ����� 90�� �Դϴ�.
		
	
	}

}
