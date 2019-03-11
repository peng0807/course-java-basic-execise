package chapter3.ex7;

abstract class Shape { // 定义一个抽象类Shape，表示形状
	public double area; // 面积

	abstract double getArea(); // 声明一个抽象方法 getArea()，方法的返回值类型是double
}

class Rectangle extends Shape { // 定义一个表示矩形的类Rectangle，继承Shape
	public double length; // 长
	public double width; // 宽

	public Rectangle(double length, double width) { // 构造方法
		this.length = length; // 初始化成员变量length
		this.width = width;
	}

	public double getArea() { // 实现父类的抽象方法 getArea()
		return length * width; // 返回矩形的面积
	}
}

class Circle extends Shape { // 定义一个表示圆形的类Circle，继承Shape
	public double radius; // 半径

	Circle(double radius) { // 定义Circle类的构造方法
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}
}

public class TestAbstract {
	public static void main(String[] args) {
		Shape s1 = new Rectangle(4, 5); // 创建一个长为4，宽为5的矩形对象。
		System.out.println(s1.getArea());
		Shape s2 = new Circle(3);
		System.out.println(s2.getArea()); // 打印出形状s2的面积
	}
}
