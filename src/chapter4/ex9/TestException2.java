package chapter4.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestException2 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int x = Integer.parseInt(br.readLine());
			int y = Integer.parseInt(br.readLine());
			System.out.println(x / y);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close(); // 将这条语句放到finally结构中
			} catch (IOException e) {
				br = null;
				e.printStackTrace();
			}
		}
	}
}