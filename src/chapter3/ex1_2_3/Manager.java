package chapter3.ex1_2_3;

public class Manager extends Employee { // 定义Manager类，继承Employee类
	Manager(String name, int age, double salary) {
		super(name, age); // 调用父类构造方法，以初始化成员变量name和age
		this.salary = salary;
	}

	public static void main(String[] args) {
		Manager manager = new Manager("张三", 40, 10000); // 创建一个经理对象：张三、40岁、10000元月薪
		manager.showInfo(); // 调用showInfo()方法，显示该经理的信息。
	}
}
