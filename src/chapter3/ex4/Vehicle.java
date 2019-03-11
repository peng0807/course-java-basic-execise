package chapter3.ex4;

public class Vehicle {
	int wheels; // 车轮数
	float weight; // 车重

	Vehicle(int wheels, float weight) {
		this.wheels = wheels;
		this.weight = weight;
	}

	void show() {
		System.out.print("车轮:" + this.wheels);
		System.out.print(", 车重:" + this.weight);
	}

}
