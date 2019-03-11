package chapter2.ex4;

public class Student {
	int age;
	String name;
	static int count;  // 定义静态成员变量count，用以存放创建的学生对象数量
	public Student() {
		System.out.println("调用无参的构造方法");
		count ++ ;  // 静态成员变量count自增1，表示新创建了一个学生对象
	}
	public Student(int age) {
		this();  //此处调用无参的构造方法
		System.out.println("调用只有一个参数的构造方法");
		this.age = age;
	}
	public Student(int age, String name) {
		this(age);  //此处调用只有一个参数的构造方法
		System.out.println("调用有两个参数的构造方法");
		this.name = name;  //初始成员变量name
	}
	void printInfo()  { //定义成员方法printInfo()，用以打印学生信息
		System.out.println(this.name + "的年龄是" + this.age);
	}
	static void printCount() { 
		System.out.println("学生的数量是" + count); // 打印学生对象的数量
	}
	public static void main(String[] args) {
		Student s1 = new Student(20, "张三");
		Student s2 = new Student(20, "张三");  //创建学生对象：张三， 20岁
		s1.printInfo(); 
		s2.printInfo();  // 打印学生s2的信息
		printCount();  // 打印学生对象的数量
	}
}
