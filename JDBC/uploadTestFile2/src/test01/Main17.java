package test01;

public class Main17 {

	public static void main(String[] args) {
		// �������� �Ϻθ� ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// ������ ����� ���������� ���߾� ����� ������ ����� ������ ������ 3ĭ���� �Ѵ�.
		// ������� ��)2_*_1_=__2___ (_�� ������ ��Ÿ���� ����)
		
		int i=2;
		int j=1;
		int cnt=0;
		
		for(i=2; i<=j+1; i++)
		{
			for(j=1; j<=5; j++)
			{
				System.out.printf("%d * %1d = %2d   ",i, j, i*j);
				cnt++;
				if(cnt%5==0)
				{
					System.out.println();
				}
			}
			if(i==4)
				break;
		}
	}

}
