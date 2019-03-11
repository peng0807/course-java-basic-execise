package chapter5.ex5;

import java.util.*;

class MyKey implements Comparable<MyKey> { // 实现java.lang.Comparable接口
	int key;

	public MyKey(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "key=" + key;
	}

	// 实现compareTo方法，制定大小比较规则：按key值大小比较
	@Override
	public int compareTo(MyKey o) {
		return this.key - o.key;
	}

	// 覆盖hashCode方法，根据key值生成哈希码
	@Override
	public int hashCode() {
		return 11 * key;
	}

	// 覆盖equals方法，指定相等判断规则：如key值相同，则对象相等
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyKey && ((MyKey) obj).key == this.key) {
			return true;
		} else {
			return false;
		}
	}
}

class MyValue {
	String value;

	public MyValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "value=" + value;
	}
}

public class TestMap {
	public static void main(String[] args) {
		MyKey key1 = new MyKey(1);
		MyKey key2 = new MyKey(2);
		MyKey key3 = new MyKey(3);
		MyValue value1 = new MyValue("a");
		MyValue value2 = new MyValue("b");
		MyValue value3 = new MyValue("c");

		Map<MyKey, MyValue> hashMap = new HashMap<MyKey, MyValue>(); // 创建HashMap对象
		// 使用put方法，依次将<key1, value1>、<key2, value2>、<key3, value3>放入hashMap中
		hashMap.put(key1, value1);
		hashMap.put(key2, value2);
		hashMap.put(key3, value3);
		System.out.println("hashMap中元素的数量：" + hashMap.size()); // 使用size方法，获取hashMap中entry的数量
		MyKey key4 = new MyKey(3);
		MyValue value4 = new MyValue("d");
		hashMap.put(key4, value4); // 将<key4, value4>放入hashMap中，思考：此时hashMap中entry的数量是多少？

		System.out.println("遍历hashMap中的entry");
		Set<Map.Entry<MyKey, MyValue>> entries = hashMap.entrySet(); // 使用entrySet方法，获取hashMap中的entry集合
		for (Map.Entry<MyKey, MyValue> entry : entries) {
			MyKey myKey = entry.getKey(); // 使用getKey方法，获取entry中的key
			MyValue myValue = entry.getValue(); // 使用getValue，获取entry中的value
			System.out.println("<" + myKey + " , " + myValue + ">");
		}
		System.out.println("是否包含key3：" + hashMap.containsKey(key3)); // 使用containsKey方法，判断hashMap中是否包含key3
		System.out.println("是否包含value3：" + hashMap.containsValue(value3)); // 使用containsValue方法，判断hashMap中是否包含value3

		SortedMap<MyKey, MyValue> treeMap = new TreeMap<MyKey, MyValue>(hashMap); // TreeMap(Map
																					// m)方法构建TreeMap对象，将hashMap中的所有元素放入此TreeMap中
		System.out.println("遍历treeMap中的entry");
		// 遍历treeMap，观察输出结果是否有序
		entries = treeMap.entrySet(); // 使用entrySet方法，获取hashMap中的entry集合
		for (Map.Entry<MyKey, MyValue> entry : entries) {
			MyKey myKey = entry.getKey(); // 使用getKey方法，获取entry中的key
			MyValue myValue = entry.getValue(); // 使用getValue，获取entry中的value
			System.out.println("<" + myKey + " , " + myValue + ">");
		}
	}
}