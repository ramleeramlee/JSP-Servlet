package com.multi.www.web02;

public class Car2 {

	String color; //멤버변수
	int price;
	int speed;
	
	// static : 하나만 변수만들때 (객체하나만 제공)
	// public : 제공하는 car2를 아무데서나 쓸 수 있도록
	public static Car2 car2; //null
	
	// 싱글톤은 해당클래스에서 하나만 만들어서 제공
	// getInstance이 있다면 싱글톤이라고 보면 됨
	
	public static Car2 getInstance() { 
		// 이미 만들지 않았다면 
		if (car2 == null) {
			car2 = new Car2("빨강", 100, 110);
		}
		return car2;
	}
	// static 사용했으면 밑에 싱글톤에도 static 있어야 함
	
	public void run( ) {
		System.out.println("달리자~~~");
	}
	// private는 아무데서나 쓸 수 없다
	// new이용해서 객체생성시 new Car2()를 외부에서 부를 수 없도록
	// 해당 클래스내에서만 부르게 함
	private Car2(String color, int price, int speed) {
		
		this.color = color;
		this.price = price;
		this.speed = speed;
	} // 자동호출되는 객체생성자(메서드)


	
}
