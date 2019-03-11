package chapter3.ex1_2_3;

public class Worker extends Employee { // 定义“工人”类Worker，继承“员工”类Employee
	int workingDays; // 成员变量workingDays，表示工作天数
	double dailyWage; // 定义 double类型的成员变量 dailyWage，表示日薪

	void setSalary(int workingDays, double dailyWage) {
		this.workingDays = workingDays;
		this.dailyWage = dailyWage;
		this.salary = workingDays * dailyWage; // 工资=工作天数*日薪
	}

	Worker(String name, int age, int workingDays, double dailyWage) {
		super(name, age); // 调用父类构造方法，以初始化name和age
		setSalary(workingDays, dailyWage); // 调用成员方法setSalary，以初始化工作天数、日薪和月薪
	}

	void showInfo() { // 覆盖override父类的showInfo()方法
		super.showInfo(); // 调用父类被覆盖的showInfo()，以显示姓名、年龄、工资的信息
		System.out.println("工作天数是：" + this.workingDays);
		System.out.println("日薪是：" + this.dailyWage);
	}

	public static void main(String[] args) {
		Worker worker = new Worker("李四", 20, 22, 200); // 创建Worker对象：李四、20岁、月工作22天、日薪200
		worker.showInfo();
	}
}