package test;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		// ������ �Է¹޾� 1���� �Է¹��� ���������� ���ʴ�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// ex) 5         1 2 3 4 5
		
		Scanner sc = new Scanner(System.in);
		int i;
		
		int a = sc.nextInt();
		
		for(i=1; i<=a; i++)
		{
			System.out.print(i);
			System.out.print(" ");
		}
	}

}
