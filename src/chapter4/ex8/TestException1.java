package chapter4.ex8;

public class TestException1 {
	static void m() throws Exception { // 声明该方法会抛出throws异常
		int a = 3;
		int b = 0;
		int c = a / b;
		System.out.println(c);
	}

	public static void main(String[] args) {
		// 以下是异常处理代码结构
		try { // 尝试执行方法m()
			m();
		} catch (Exception e) { // 捕获异常对象e
			e.printStackTrace(); // 打印异常栈信息
		} finally { // 无论是否发生异常都需要执行的代码
			System.out.println("总会执行");
		}
		System.out.println("程序正常结束");
	}
}