package chapter6.ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyAndTranscodingFile {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/src.txt");
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			FileOutputStream fos = new FileOutputStream("c:/dest.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			int c = 0;
			while ((c = isr.read()) != -1) {
				osw.write(c);
			}
			isr.close();
			osw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
