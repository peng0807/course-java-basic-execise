package chapter3.ex5;

//final class SupClass {	// final class是不能有子类的
class SupClass {
	public final int CONST = 1;
	@SuppressWarnings("unused")
	private int i;
	protected int j;

	public SupClass(int i, int j) {
//		CONST = 2;	// CONST是常量，只能赋值一次
		this.i = i;
		this.j = j;
	}

//	final void m1() {	// final method是不能被覆盖的
	void m1() {
		System.out.println("SupClass m1()");
	}

	void m2() {
		System.out.println("SuperClass m2()");
	}
}

class SubClass extends SupClass {
	public int k;

	public SubClass(int i, int j, int k) {
		super(i, j);
//		this.i = i;		// i是private的，不能在其他类中访问
//		this.j = j;
		this.k = k;
	}

	void m1() {
		System.out.println("SubClass m1()");
		System.out.println("SubClass m1()");
	}

//	private void m2() {	// 父类的m2方法的访问权限是缺省的，子类不能缩小访问权限
	void m2() {
		System.out.println("SubClass m2()");
	}
}

public class FindWrong {
	public static void main(String[] args) {
		SubClass sub = new SubClass(1, 2, 3);
//		System.out.println(sub.i); // 不能访问其他类私有成员
		System.out.println(sub.j);
		System.out.println(sub.k);
		sub.m1();
		sub.m2();
	}
}
