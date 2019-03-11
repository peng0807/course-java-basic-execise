package chapter4.ex5;

import java.util.Random;
import java.util.Scanner;

public class TestRandom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 创建标准输入流System.in的扫描器对象
		Random random = new Random(); // 创建随机数生成器
		int n = 0;
		System.out.println("输入0表示退出循环");
		while (true) {
			System.out.print("请输入n的值：");
			n = scanner.nextInt(); // 将控制台的输入读取为整型
			if (n == 0) { // 如果n=0，则退出while循环
				break;
			}
			System.out.print("生成的[0," + n + "]之间的随机数是：");
			System.out.println(random.nextInt(n + 1)); // 生成[0, n]之间的一个随机整数
		}
		System.out.println("程序执行结束");
		scanner.close(); // 关闭扫描器
	}
}
