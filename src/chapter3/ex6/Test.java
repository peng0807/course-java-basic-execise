package chapter3.ex6;

class F {
	int i = 0;

	void m() {
		System.out.println("f");
	}
}

class S extends F {
	int i = 9;

	void m() {
		System.out.println("s");
	}
}

public class Test {
	public void m(F f1, F f2) {
		System.out.println("ff");
	}

	public void m(F f1, S s1) {
		System.out.println("fs");
	}

	public void m(S s1, S s2) {
		System.out.println("ss");
	}

	public static void main(String[] args) {
		F f = new F();
		F s = new S();
		System.out.println(f.i); // 0, 属性字段是静态绑定的, 访问f的编译时类型F中定义的属性
		System.out.println(s.i); // 0, 属性字段是静态绑定的, 访问s的编译时类型S中定义的属性
		f.m(); // f, 虚方法是动态绑定的, 调用f的运行时类型F中定义的方法
		s.m(); // s, 虚方法是动态绑定的, 调用s的运行时类型F中定义的方法
		Test test = new Test();
		test.m(f, f); // ff, 确定方法签名时，实参的类型根据编译时类型决定
		test.m(f, s); // ff, 如上
		test.m(s, s); // ff, 如上
	}
}
