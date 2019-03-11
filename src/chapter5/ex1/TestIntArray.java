package chapter5.ex1;

import java.util.Arrays; // 导入数组工具类 Arrays
import java.util.Random;

public class TestIntArray {
	public static void main(String[] args) {
		int[] a = new int[10]; // 创建一个长度为10的整型数组a
		Random random = new Random();
		for (int i = 0; i < a.length; i++) { // 使用for循环遍历数组，使用数组的length属性
			a[i] = random.nextInt(100) + 1; // 使用random生成[1,100]的随机整数
			System.out.print(a[i] + " ");
		}
		Arrays.sort(a); // 使用java.util.Arrays对数组a进行排序
		System.out.println();
		for (int e : a) { // 使用增强型for循环遍历数组
			System.out.print(e + " ");
		}
	}
}