package road;

public class Road3 {
	public static void main(String[] args) {
		SuperCar mycar = new SuperCar("Fe", "Red", 7000);
		SuperCar mycar2 = new SuperCar("Fe", "Red", 7000, "데일리모드");
		
		Car momcar = new Car("K8", "White", 5000);
		mycar.engineStart();
		mycar.openDoor();
		
		momcar.engineStart();
		
	}
}
