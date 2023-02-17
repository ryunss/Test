package road;

public class Road1 {

	public static void main(String[] args) {
//		int data0 = 10;
//		int data1 = 20;
//		int data2 = 25;
//		
//		int[] arData = {10,20,25};
		
		Car[] cars = {
			new Car("Ferrari", "Red", 70000),
			new Car("K8", "White", 5000),
			new Car("Porsche", "Yellow", 25000)
		};
		

		for (int i = 0; i < cars.length; i++) {
			cars[i].engineStart();
		}
		
		Car[] cars2 = new Car[5];
		for (int i = 0; i < cars2.length; i++) {
			cars2[i] = new Car();
			System.out.println(cars2[i]);
			cars2[i].engineStart();
		}
	}

}















