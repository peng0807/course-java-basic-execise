package chapter2.ex1;

public class FindWrong {
	public void main(String args) {
		int i = 1, j = 1; // int i=1, j; j是局部变量，在使用前需要进行初始化
		float f1 = 0.1F, f2 = 123; // float f1 = 0.1, f2 = 123; 0.1是double类型的，double类型的无法自动转型为float
		final double PI = 3.1415926;
		char c = 'b'; // char class = 'b'; class是语言关键字，不能作为标识符
		i = j + 5;
		f1 = f2 + 2;
		// PI = PI * 2; PI是常量，只能赋值一次
		c = 'c'; // class =' c'; 空格也是字符，单引号只能包围字符，而不能是字符串
	}
}
