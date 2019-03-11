package chapter5.ex2;

import java.util.Arrays;

class Dog implements Comparable<Dog> { // 实现接口Comparable<Dog>
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

	// @Override public int compareTo(Dog
	// o)，实现compareTo方法，根据Dog对象中的weight属性比较两条Dog的大小
	@Override
	public int compareTo(Dog o) {
		return this.weight - o.weight;
	}
}

public class TestObjectArray {
	public static void main(String[] args) {
		Dog[] dogs = new Dog[3]; // 创建一个长度为3的Dog类型数组dogs
		dogs[0] = new Dog("大黄", 30);
		dogs[1] = new Dog("旺财", 20);
		dogs[2] = new Dog("福娃", 10);
		System.out.println("排序前：");
		for (Dog e : dogs) { // 使用增强型for循环遍历数组dogs
			System.out.print(e + " ");
		}
		Arrays.sort(dogs); // 使用java.util.Arrays对数组dogs进行排序
		System.out.println("\n排序后：");
		for (int i = 0; i < dogs.length; i++) {
			System.out.print(dogs[i] + " ");
		}
	}
}