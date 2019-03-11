package chapter5.ex4;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

class Dog implements Comparable<Dog> {
	String name;
	int weight;

	public Dog(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return this.name + "重" + this.weight + "公斤";
	}

	@Override
	public int compareTo(Dog o) {
		return this.weight - o.weight;
	}
}

public class TestList {
	public static void main(String[] args) {
		List<Dog> list = new LinkedList<Dog>(); // 创建一个可以存放Dog对象的LinkedList类型的容器
		Dog dog1 = new Dog("dog1", 30);
		Dog dog3 = new Dog("dog3", 10);
		// 使用boolean add(E e)方法，依次将dog1和dog3添加到list中
		list.add(dog1);
		list.add(dog3);
		Dog dog2 = new Dog("dog2", 20);
		int index = list.indexOf(dog3); // 使用int indexOf(Object o)方法，获取dog3在list中的位置
		list.add(index, dog2); // 使用void add(int index, E element)方法，将dog2插入到dog3的位置上

		System.out.println("使用增强型for循环遍历list：");
		for (Dog dog : list) { // 使用增强型for循环遍历list
			System.out.print(dog + "; ");
		}

		System.out.println("\n使用for循环遍历list：");
		for (int i = 0; i < list.size(); i++) { // 使用int size()方法获取list中的元素个数
			Dog dog = list.get(i); // 使用E get(int index)方法获取list中下标为i的元素
			System.out.print(dog + "; ");
		}

		Collections.sort(list); // 使用java.util.Collections类的sort方法对list中的元素进行排序

		System.out.println("\n排序后，使用迭代器遍历list：");
		Iterator<Dog> iterator = list.iterator(); // 使用iterator()方法，获取list中的迭代器
		while (iterator.hasNext()) { // 使用Iterator的boolean hasNext()方法，判断是否存在另一个可访问的元素
			Dog dog = iterator.next(); // 使用Iterator的Object next()方法，返回要访问的下一个元素
			System.out.print(dog + "; ");
		}

		list.remove(dog2); // 使用remove方法删除list中的元素dog2
		System.out.println("\n删除一个元素后，list中的元素数量是：" + list.size());
		list.clear(); // 使用clear方法清空list中的元素
		System.out.println("list是否为空：" + list.isEmpty()); // 判断list是否为空
	}
}