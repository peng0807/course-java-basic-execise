package chapter4.ex2;

public class TestMath {
	public static void main(String[] args) {
		int a = (int) (Math.random() * 11); // 使用Math类，生成一个[0,10]范围内的整数
		System.out.println("a=" + a);
		System.out.println(a + "的平方根是：" + Math.sqrt(a)); // 使用Math类求 a的平方根
	}
}