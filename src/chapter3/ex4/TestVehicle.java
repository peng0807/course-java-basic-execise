package chapter3.ex4;

public class TestVehicle {

	public static void main(String[] args) {
		Vehicle trunk = new Trunk(6, 7500, 80);
		trunk.show();
		Vehicle minibus = new Minibus(4, 3000, 12);
		minibus.show();
	}

}
