package chapter7.ex1_2_3_4;

public class Student {
	
	String sno;
	String name;
	
	public Student() {
		
	}

	public Student(String sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + "]";
	}
	
}
