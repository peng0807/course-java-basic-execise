package chapter4.ex3;

public class TestString {
	public static void main(String[] args) {
		String name = "My name is peng zheng"; // 请用你姓名的拼音替换[代码1]
		System.out.println("字符串的长度是:" + name.length()); // 使用length方法，打印字符串name的长度
		System.out.println("字符串中的第一个字符是:" + name.charAt(0)); // 使用charAt方法，打印字符串name中的第一个字符
		System.out.println("字符串中的最后一个字符是:" + name.charAt(name.length() - 1)); // 使用length和charAt方法，打印字符串name中的最后一个字符
		System.out.println("字符串中的第一个单词是:" + name.substring(0, name.indexOf(' '))); // 使用subString和indexOf方法，打印字符串name中的第一个单词
		System.out.println("字符串中的第一个单词是:" + name.substring(name.lastIndexOf(' ') + 1)); // 使用subString和lastIndexOf方法，打印字符串name中的最后一个单词
		String s1 = new String("you are a student");
		String s2 = new String("how are you");
		// 使用equals方法，判断s1与s2是否相同
		if (s1.equals(s2)) {
			System.out.println("s1与s2相同");
		} else {
			System.out.println("s1与s2不相同");
		}
		// 使用startWith方法，判断s1是否以"you"开始。
		if (s1.startsWith("you")) {
			System.out.println("s1是以you开头的");
		}
		if (s2.contains("you")) { // 使用contains方法，判断s2是否包含"you"。
			System.out.println("s2中包含you");
		}
		String path = "c:/java/A.java";
		int index = path.indexOf('/'); // 获取path中第一个目录分隔符/的位置
		System.out.println("c:/java/A.java中第一个/出现的位置是：" + index);
		int lastIndex = path.lastIndexOf('/'); // 获取path中最后一个目录分隔符/的位置
		System.out.println("c:/java/A.java中最后一个/出现的位置是：" + lastIndex);
		String fileName = path.substring(lastIndex + 1); // 获取path中包含的文件名A.java
		System.out.println("c:ava/A.java中包含的文件名是：" + fileName);
	}
}