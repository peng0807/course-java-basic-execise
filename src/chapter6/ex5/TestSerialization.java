/**
 * 编写程序TestSerialization.java，练习对象流的使用，完成对象的序列化与反序列化。
 * 需要先定义一个学生类Student，定义其成员变量age和name，定义其构造方法并重写toString方法。
 */

package chapter6.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("D:/Object.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos); //由文件输出流fos创建对象输出流oos
		Student s1 = new Student(20, "张三"); // 创建一个Student对象
		oos.writeObject(s1); //使用对象输出流oos写出对象s1
		oos.close();
		fos.close(); // 可以不写
		FileInputStream fis = new FileInputStream("D:/Object.obj");
		ObjectInputStream ois =new ObjectInputStream(fis);
		Student s2 = (Student)ois.readObject(); //使用对象输入ois读入对象，并强制转换为Student类型
		System.out.println(s2);
		ois.close(); //关闭输入流对象
	}
	
}

class Student implements Serializable{
	int age;
	String name;
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
}
