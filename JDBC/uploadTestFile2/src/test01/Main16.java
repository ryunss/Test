package test01;

public class Main16 {

	public static void main(String[] args) {
		// 아래와 같이 출력되는 프로그램 작성
		// 2 3 4 5 6
		// 3 4 5 6 7
		// 4 5 6 7 8
		// 5 6 7 8 9
		// 6 7 8 9 10
		
		int i = 2;
		int j = 3;
		int cnt = 0;
		
		for(i=2; i<=j; i++)
		{
			for(j=i; j<=i+4; j++)
			{
				System.out.print(j+" ");
				cnt++;
				if(cnt%5==0)
					System.out.println();
			}
			if(j>10)
			{
				break;
			}
		}
	}

}
