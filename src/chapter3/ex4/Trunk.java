package chapter3.ex4;

public class Trunk extends Vehicle {

	float load;

	Trunk(int wheels, float weight, float load) {
		super(wheels, weight);
		this.load = load;
	}

	void show() {
		System.out.println("车型:卡车");
		super.show();
		System.out.println(", 载重量:" + this.load);
	}
}
