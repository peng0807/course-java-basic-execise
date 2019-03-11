package chapter6.ex4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class CopyFile {

	public static void main(String[] args) {
		try {
			FileInputStream src = new FileInputStream("d:/src.zip");
			FileOutputStream dest = new FileOutputStream("d:/dest.zip");
			BufferedInputStream bis = new BufferedInputStream(src);
			BufferedOutputStream bos = new BufferedOutputStream(dest);
			int b = 0;
			Date d1 = new Date();
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			bis.close();
			bos.close();
			Date d2 = new Date();
			long duration = d2.getTime() - d1.getTime();
			System.out.println("文件已成功复制，所花时间是：" + duration + "毫秒");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}