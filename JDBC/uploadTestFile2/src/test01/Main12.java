package test01;

import java.util.Scanner;

public class Main12 {

	public static void main(String[] args) {
		// �ϳ��� ������ �Է¹޾� 1���� �Է¹��� ���������� ¦���� ���ʴ�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// �ԷµǴ� ������ 50 �����̴�.
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int a = sc.nextInt();
		
		for(i=1; i<=a; i++)
		{
			if(i%2==0)
			{
				System.out.print(i+" ");
			}
		}
	}
}
