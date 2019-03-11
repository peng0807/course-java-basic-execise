package chapter4.ex1;

public class Dog {
	String name;
	int weight; // 重量

	public Dog(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	// Override覆盖Object类的toString()方法
	@Override
	public String toString() {
		return this.name + "重" + this.weight + "公斤";
	}

	// Override覆盖Object类的equals方法
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Dog) { // 如果obj是Dog类的实例
			Dog dog = (Dog) obj;
			if (this.name.equals(dog.name) && this.weight == dog.weight) { // 根据重量和名字判断两条狗是否相等，相等则返回true
				return true;
			}
		}
		return false;
	}

	// Override覆盖Object类的hashCode方法
	@Override
	public int hashCode() {
		return this.name.hashCode() * 11 + this.weight; // 要求能够根据狗的重量和名字返回狗的hashCode
	}

	public static void main(String[] args) {
		Dog dog1 = new Dog("DaHuan", 10);
		Dog dog2 = new Dog("DaHuan", 10);
		System.out.println(dog1);// 应该显示："DaHuan重10公斤"
		System.out.println(dog1.equals(dog2));// 调用equals方法，判断dog1和dog2是否相等，应该显示："true"
		System.out.println(dog1 == dog2); // 为什么显示的是"false"?
	}
}