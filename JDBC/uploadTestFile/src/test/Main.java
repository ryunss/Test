package test;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		// 100 ������ ���� ������ �Էµȴ�. while ���� �̿��Ͽ� 1���� �Է¹��� ���������� ���� ���Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		int a = sc.nextInt();
		
		while(i<=a)
		{
			sum+=i;
			i++;
		}
		System.out.println(sum);
		
	}
}
	
