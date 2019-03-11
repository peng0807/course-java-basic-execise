package chapter4.ex4;

public class TestStringBuffer {
	public static void main(String[] args) {
		String s = "MicroSoft";
		StringBuffer sb = new StringBuffer(s); // 用s构造sb对象
		System.out.println(sb.append("Oracle")); // 使用append方法在sb末尾添加字符串"Oracle"
		System.out.println(sb.insert(sb.indexOf("Oracle"), "/")); // 使用insert方法在MicroSoft和Oracle之间插入字符'/'
		System.out.println(sb.replace(0, sb.indexOf("/"), "MicroSun")); // 使用replace方法将MicroSoft替换成MicroSun
		System.out.println(sb.delete(0, 5)); // 使用delete方法删除子串"Micro"
	}
}