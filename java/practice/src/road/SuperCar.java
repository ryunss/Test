package road;

public class SuperCar extends Car{
	
	String mode;
	
	public SuperCar() {
		// super : 상속받고 있는 부모 클래스의 이름 --> Car
		super(); // Car();
	}
	
	// Alt + Shift + s > c : 부모 생성자를 받아와서 생성자 만들기
	public SuperCar(String brand, String color, int price) {
		super(brand,color,price);
	}
	
	// Alt + Shift + s > o : 필드를 이용해서 생성자 만들기
	public SuperCar(String brand, String color, int price, String mode) {
		super(brand,color,price);
		this.mode = mode;
	}
	void engineStart() {
		System.out.println(brand + " 홍채로 시동걸기");
	}

	// @ : 어노테이션
	@Override
	void engineStop() {
//		super.engineStop(); // Car 클래스의 engineStop 이랑 같다는 뜻
		System.out.println(brand + " 홍채로 시동끄기"); // 오버라이딩 (재정의)
	}
	
	void openDoor() {
		System.out.println("위쪽으로 문 열기");
	}
	
	void closeDoor() {
		System.out.println("아래쪽으로 문 닫기");
	}
}
