package test01;

import java.util.Scanner;

public class Main24 {

	public static void main(String[] args) {
		// �� ���� �ڿ����� �Է¹޾� �� ���� ����� ���ʷ� 10�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
	
		for(int i=1; i<=10*a; i++)
		{
			if(i%a==0)
			System.out.print(i+" "); 
		}
	}
}
