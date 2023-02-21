package day10;

public class NestedArrayTest {

	public static void main(String[] args) {
		int arr[][] = { 
				{1,2}, 
				{10,20}, 
				{30,40} 
			};
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println("arr.length : "+arr.length); // Ãâ·Â°ª : 3
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}

		int[][] arr2 = new int[2][3];
		System.out.println(arr2.length);
		
		
		
	}

}
