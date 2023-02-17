package road;

public class Car {
	String brand;
	String color;
	int price;
	static int wheel = 4;
	
	public Car() {}
	
	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	void engineStart() {
		System.out.println(brand + " 열쇠로 시동 켜기");
	}
	
	void engineStop() {
		System.out.println(brand + " 열쇠로 시동 끄기");
	}
	
}
