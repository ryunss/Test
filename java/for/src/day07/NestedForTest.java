package day07;

public class NestedForTest {

	public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			
			System.out.println("°ÑÀÇ for¹® ¾ÈÂÊ, ¾ÈÂÊ for¹®¹Ù±ùÂÊ");
			
			for(int j=0; j<2; j++) {
				System.out.println("i:"+i+"j:"+j);
				System.out.println("¾È³ç");
			}
		}
	}

}
