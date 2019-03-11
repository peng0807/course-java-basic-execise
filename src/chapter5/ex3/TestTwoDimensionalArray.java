package chapter5.ex3;

import java.util.Arrays;
import java.util.Random;

public class TestTwoDimensionalArray {
	public static void main(String[] args) {
		Random random = new Random();
		int[][] a = new int[3][5]; // 创建一个3行5列的整型二维数组
		/*
		 * 下段代码是想采用增强型for循环对数组元素赋值 观察，二维数组a的元素的值是否有被修改，为什么？
		 */
		for (int[] i : a) {
			for (int j : i) {
				j = random.nextInt(100);
			}
		}
		/*
		 * 下段两层的for循环是用来遍历二维数组a的 请将下段代码封装成方法 static void traverse(int[][] a)
		 */
		for (int i = 0; i < a.length; i++) {
			System.out.print("a[" + i + "]是：");
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		/*
		 * 下段两层的for循环是用来对数组元素赋值的 请使用length遍历数组
		 */
		for (int i = 0; i < a.length; i++) { // 使用length遍历数组a
			for (int j = 0; j < a[i].length; j++) { // 使用length遍历数组a[i]
				a[i][j] = random.nextInt(100);
			}
		}
		traverse(a); // 调用traverse方法遍历数组a
		/*
		 * 下段代码是用for循环对二维数组a中的每一行元素进行排序 请使用java.util.Arrays类的sort方法进行排序
		 */
		for (int i = 0; i < a.length; i++) {
			Arrays.sort(a[i]); // 对二维数组a中的每一行元素进行排序
		}
		traverse(a); // 调用traverse方法遍历数组a
		System.out.println("二维数组a的和是：" + sum(a));
	}

	public static void traverse(int[][] a) {
		// 遍历二维数组a
		for (int i = 0; i < a.length; i++) {
			System.out.print("a[" + i + "]是：");
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static long sum(int[][] a) {
		long sum = 0;
		// 使用两层的增强型for循环对二维数组a中的元素求和
		for (int[] i : a) {
			for (int j : i) {
				sum += j;
			}
		}
		return sum;
	}
}