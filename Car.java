package com.multi.www.web02;

public class Car {
	//멤머변수
	//멤버메서드
	//toString()
	//객체생성시 멤버변수값을 한꺼번에 넣어서 초기화 하고 싶다면
	//>> 객체생성시 자동호출되는 메서드를 추가한다
	//>> 생성자(메서드), constructor
	String color; //멤버변수
	int price;
	int speed;
	
	public Car(String color, int price, int speed) {
		
		this.color = color;
		this.price = price;
		this.speed = speed;
	} // 자동호출되는 객체생성자(메서드) 
	 // >> 단축키 alt + shift + s 
	 // >> generate constructor using fields

//	@Override
//	public String toString() {
//		return "Car [color=" + color + ", price=" + price + ", speed=" + speed + "]";
//	}
//	
	
	
}
