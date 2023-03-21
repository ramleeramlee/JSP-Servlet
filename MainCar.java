package com.multi.www.web02;

public class MainCar {

	public static void main(String[] args) {
		Car car = new Car("빨강", 10, 200); //12(4바이트 * 3)
		Car car2 = new Car("검정", 30, 400); //12
		
		// car.java 파일에 생성자가 있으므로 ()안에 해당하는 값을 넣어주어야 한다
		// new를 사용하는 것을 프로토타입이라고 하고
		// 새로 만들어질 때마다 용량도 매번 새로 생긴다
		// 값들이 다 다를때는 각각 저장공간이 필요하므로 프로토타입(new)를 사용한다
		System.out.println(car);
		System.out.println(car2); //주소확인 >> 서로 다른 저장공간이 생긴 것을 알 수 있다
	}

}
