package chapter6.ex6;

import java.io.*;
public class TestFile {
	public static void main(String[] args) {
		String path = "c:/dir1/file1.txt";
		File file = new File(path);  // 根据字符串path创建File对象
		File dir = file.getParentFile();  // 使用getParentFile方法，获取file的父目录
		if (dir != null && !dir.exists() ) {  // 使用dir的exists方法判断dir表示的目录是否存在，如果不存在，则创建目录
			if( !dir.mkdirs() ) { // 使用dir的mkdirs方法创建dir表示的目录，如果创建失败，则结束程序
				System.out.println("目录创建失败，程序结束运行");
				return;
			}; 
		}
		
		try {
			file.createNewFile();  // 使用file的createNewFile方法创建file表示的文件
			System.out.println("文件创建成功");
		} catch (IOException e) {
			System.out.println("创建文件失败");
			e.printStackTrace();
			return;
		}
		
		try {
			FileWriter out = new FileWriter(file);  //  通过构造方法FileWriter(File file)，创建file的文件字符输入流
			out.write("abcdefxyijklmn"); 
			out.close();
			System.out.println("文件写入成功");
		} catch (IOException e) {
			System.out.println("文件写入失败");
			e.printStackTrace();
			return;
		} 
		
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw"); // 通过构造方法RandomAccessFile(File file, String mode)，以可读可写”rw”的方式创建file的随机访问文件对象
			raf.seek(7);  // 使用seek(long pos)方法，将raf的读写指针指向字符 'x' ，文件的pos是从0开始的。
			raf.write("gh".getBytes());  // 使用raf的write(byte[] b)方法，将字符串"gh"替换文件中的"xy"
			raf.close();
			System.out.println("文件修改成功");
		} catch (Exception e) {
			System.out.println("文件修改失败");
			e.printStackTrace();
			return;
		}
		
		try {
			FileReader in = new FileReader(file);
			BufferedReader br = new BufferedReader(in); // 通过文件字符输入流in 创建 缓冲字符输入流
			System.out.println(br.readLine());
			br.close();
			in.close();
			System.out.println("文件读取成功");
		} catch (Exception e) {
			System.out.println("文件读取失败");
			e.printStackTrace();
			return;
		}
		
		//选做部分：将c:/dir1 复制到 d:/dir1 
		//选择部分：将c:/dir1 移动到 d:/dir2 
	}
}