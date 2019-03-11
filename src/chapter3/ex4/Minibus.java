package chapter3.ex4;

public class Minibus extends Vehicle {

	int passenger;

	public Minibus(int wheels, float weight, int passenger) {
		super(wheels, weight);
		this.passenger = passenger;
	}

	void show() {
		System.out.println("车型:面包车");
		super.show();
		System.out.println(", 载人:" + this.passenger);
	}
}
