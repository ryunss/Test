package test;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		// 0 �� �Էµ� ������ ������ ��� �Է¹޾� 3�� ����� 5�� ����� ������ ������ ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// 1 2 3 4 5 6 7 8 9 10 0 ��¿� : 5
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int count = 0;
		
		while(true)
		{
			int a = sc.nextInt();
			
			if(a==0)
			{
				System.out.println(count-cnt);
				break;
			}
			else if(a%3==0 || a%5==0)
			{
				cnt++;
			}
			count++;
			
		}
	}

}
