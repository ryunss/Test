package test;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		// 0 �̻��� �������� �������� ���еǾ� �ݺ������� �־�����.
		// 0�� �ԷµǸ� �ݺ����� ���߰� �� ������ �Է¹��� ���鿡 ���Ͽ�
		// Ȧ���� ������ ¦���� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		// �Է� �� / 9 7 10 5 33 65 0 ��� �� / odd : 5 even : 1
		int oddSum = 0;
		int evenSum = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			
			
			int a = sc.nextInt();
			
			if(a==0)
			{
				System.out.println("odd : "+cnt1);
				System.out.println("even : "+cnt2);
				break;
			}
			
			else if(a%2!=0)
			{
				oddSum += cnt1;
				cnt1++;
			}
			else if(a%2==0)
			{
				evenSum += cnt2;
				cnt2++;
			}
			
			
		}
	}

}
