package com.multi.www.web02;

public class MainCar2 {

	public static void main(String[] args) {
		Car2 car2;
		for (int i = 0; i < 1000; i++) {
			car2 = Car2.getInstance();
			// static Car2 getInstance() 으로 정의했으므로 대소문자 구분해야함
			System.out.println(car2); //주소확인 >> 1000개의 저장공간
		}
		
		System.out.println("메모리크기>> " + 12 * 1000);
		
	}

}
