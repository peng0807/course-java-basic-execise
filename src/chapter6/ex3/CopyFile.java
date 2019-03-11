/**
 * 执行程序CopyFile.java，观察文件复制所需的时间。
 * 修改程序CopyFile.java，使用缓冲流BufferedInputStream和BufferedOutputStream提高磁盘文件的读写效率。
 */

package chapter6.ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class CopyFile {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("d:/src.zip"); 
			FileOutputStream fos = new FileOutputStream("d:/dest.zip"); 
			byte[] buf = new byte[8096];
			int count = 0;
			Date d1 = new Date();
			while((count = fis.read(buf)) != -1) { 
				fos.write(buf, 0 , count); 
			}
			fis.close();
			fos.close();
			Date d2 = new Date();
			long duration = d2.getTime()-d1.getTime();
			System.out.println("文件已成功复制，所花时间是：" + duration + "毫秒");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
