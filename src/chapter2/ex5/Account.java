package chapter2.ex5;

public class Account {

	static double minBalance;
	static {
		minBalance = 10;
	}

	String account;
	String name;
	double balance;

	public Account(String account, String name, double balance) {
		this.account = account;
		this.name = name;
		this.balance = balance;
	}

	void deposit(double money) {
		System.out.println("原有金额:" + this.balance);
		System.out.println("现存入金额:" + money);
		this.balance += money;
		System.out.println("存入后的总金额:" + this.balance);
	}

	void withdraw(double money) {
		if (minBalance > this.balance - money) {
			System.out.println("该操作失败");
			return;
		}
		System.out.println("原有金额:" + this.balance);
		System.out.println("现取出金额:" + money);
		this.balance -= money;
		System.out.println("取出后的余额:" + this.balance);
	}

	static void setMinBalance(double min) {
		minBalance = min;
	}
}
