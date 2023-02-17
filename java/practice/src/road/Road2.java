package road;

public class Road2 {
	public static void main(String[] args) {
		
		Car mycar = new Car("Ferrari", "Red", 70000);
		Car momcar = new Car("K8", "White", 5000);
		
		momcar.wheel--;
		
		System.out.println(momcar.wheel); // 3
		System.out.println(mycar.wheel); // 3
	}
}
