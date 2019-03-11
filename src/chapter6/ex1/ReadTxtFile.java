package chapter6.ex1;

import java.io.*;

/*
 * 代码的功能是读取一个文本文件的内容
 */
public class ReadTxtFile {
	public static void main(String[] args) {
		try {
			// 创建文件c:\test.txt的字符输入流对象fr
			FileReader fr = new FileReader("c:/test.txt");
			int c = 0;
			// 使用fr读取一个字符，
			// 如果得到的值!=-1，说明还没有读取到文件末尾
			while ((c = fr.read()) != -1) {
				System.out.print((char) c); // 因为c是int，所以强制转换为char
			}
			fr.close(); // 关闭输入流对象
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}