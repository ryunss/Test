package practice.game369;

public class Game369Main {

	public static void main(String[] args) {
		int num = 100;
		int cnt = 1;
		int n = 1;
		System.out.println("1~100까지 수 나열");
		
		for(int i=1; i<=num; i++) {
			
			if(i%10==3 || i%10==6 || i%10==9 ) {
				System.out.print("* ");
				i++;
			}else if(i/10==3) {
				System.out.print("* ");
				i++;
			}
			
			System.out.print(i+" ");
			
			if(i==cnt*10) {
				cnt++;
				System.out.println();
			}
		}
	}

}
