package test01;

public class Main17 {

	public static void main(String[] args) {
		// 구구단의 일부를 다음과 같이 출력하는 프로그램을 작성하시오.
		// 곱셈의 결과는 오른쪽으로 맞추어 출력을 ㅏㅎ고 결과값 사이의 공백은 3칸으로 한다.
		// 출력형식 예)2_*_1_=__2___ (_는 공백을 나타내는 것임)
		
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
