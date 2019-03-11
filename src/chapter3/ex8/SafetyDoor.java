package chapter3.ex8;

public class SafetyDoor extends Door implements Alarmable {

	@Override
	public void alarm() {
		System.out.println("alarm");
	}

	@Override
	void open() {
		System.out.println("open");
	}

	@Override
	void close() {
		System.out.println("close");
	}

}
