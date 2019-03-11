package chapter3.ex1_2_3;

public class Employee { // 定义员工类
	String name;
	int age;
	double salary; // 定义 double类型的成员变量salary，表示工资

	Employee(String name, int age) {
		this.name = name;
		this.age = age; // 初始化成员变量age
	}

	void showInfo() {
		System.out.println("姓名是：" + this.name);
		System.out.println("年龄是：" + this.age);
		System.out.println("工资是：" + this.salary); // 显示工资的信息，格式为“工资是：***”
	}
}