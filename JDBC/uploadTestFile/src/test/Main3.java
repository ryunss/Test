package test;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// ������ �Է¹޾Ƽ� 3�� ����� �ƴ� ��쿡�� �ƹ� �۾��� ���� �ʰ�
		// 3�� ����� ��쿡�� 3���� ���� ���� ����ϴ� �۾��� �ݺ��ϴٰ�
		// -1�� �ԷµǸ� �����ϴ� ���α׷� �ۼ�
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			int a = sc.nextInt();
			
			if(a%3==0)
			{
				System.out.println(a/3);
			}
			else if(a==-1)
			{
				break;
			}
			
		}
	}

}
