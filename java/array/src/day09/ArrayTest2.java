package day09;

public class ArrayTest2 {

	public static void main(String[] args) {
		int ar1[] = new int[5];
		
		System.out.println("ar1.length : "+ ar1.length);
		System.out.print("{");
		for (int i = 0; i < ar1.length; i++) {
			if(i==ar1.length-1)
			{
				System.out.print(ar1[i]);
				break;
			}
			System.out.print(ar1[i]+", ");
		}
		System.out.print("}");
		System.out.println();
		// ºü¸¥ for¹®, Çâ»óµÈ for¹®, foreach¹®
		int scores[] = {10, 20, 30, 40};
		for(int i=0; i< scores.length; i++) {
			int score = scores[i];
			System.out.println(score);
		}
		
		System.out.println("-----------------");
		
		for(int num : scores) {
			System.out.println(num);
		}
		
		String names[] = {"±èÃ¶¼ö", "±è¿µÈñ", "È«±æµ¿"};
		
		for(String name : names) {
			System.out.println(name);
		}
		
		
		
		
		
		
		
	}	
}