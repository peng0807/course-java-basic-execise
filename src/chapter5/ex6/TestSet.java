package chapter5.ex6;

///说明： java.lang.Integer类已经重写了equals、hashCode、compareTo方法
import java.util.*;

public class TestSet {
	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>(); // 创建HashSet对象
		Integer e1 = new Integer(111);
		Integer e2 = new Integer(333);
		Integer e3 = new Integer(222);
		// 依次将e1、e2、e3放入hashSet中
		hashSet.add(e1);
		hashSet.add(e2);
		hashSet.add(e3);
		System.out.println("hashSet中元素的数量：" + hashSet.size()); // 获取hashSet中元素数量
		Integer e4 = new Integer(333);
		hashSet.add(e4); // 将e4放入hashSet中，思考：此时hashSet中的元素数量是多少？

		System.out.print("遍历hashSet中的元素：");
		for (Integer e : hashSet) { // 使用增强型for循环遍历hashSet
			System.out.print(e + " ");
		}
		System.out.println("\n是否包含e4：" + hashSet.contains(e4)); // 使用contains方法，判断hashSet中是否包含e4

		SortedSet<Integer> treeSet = new TreeSet<Integer>(hashSet); // 创建TreeSet对象，将hashSet中的所有元素放入此TreeSet中
		System.out.print("遍历treeSet中的元素：");
		Iterator<Integer> iterator = treeSet.iterator(); // 获取treeSet的迭代器
		while (iterator.hasNext()) { // 判断iterator是否仍有元素可以迭代
			System.out.print(iterator.next() + " "); // 返回iterator迭代的下一个元素
		}
	}
}