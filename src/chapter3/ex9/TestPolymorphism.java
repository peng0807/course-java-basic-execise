package chapter3.ex9;

class A {
	public int i = 1;
	public static int j = 11;

	public void m1() {
		System.out.println("A类的实例方法");
	}

	public static void m2() {
		System.out.println("A类的静态方法");
	}
}

class B extends A {
	public int i = 2;
	public static int j = 22;

	public void m1() {
		System.out.println("B类的实例方法");
	}

	public static void m2() {
		System.out.println("B类的静态方法");
	}
}

public class TestPolymorphism {
	public static void main(String[] args) {
		A x = new B();	// x是编译时类型是A，运行时类型是B
		System.out.println(x.i);	// 访问成员变量是根据编译时类型决定的
		System.out.println(x.j);	// 访问静态成员是根据编译时类型决定的
		x.m1();		// 访问虚方法是根据运行时类型决定的
		x.m2();		// 访问静态成员是根据编译时类型决定的
	}
}
