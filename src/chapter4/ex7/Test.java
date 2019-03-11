package chapter4.ex7;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
	
	public static void printCalendar(Calendar calendar) {
		calendar.set(Calendar.DATE, 1); // 使用set方法将calendar的日期Calendar.DATE设为本月1号
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 使用get方法获取本月1号是星期几Calendar.DAY_OF_WEEK
		int maxDate = calendar.getActualMaximum(Calendar.DATE); // 获得本月的最大日期数
		System.out.println("日\t一\t二\t三\t四\t五\t六"); // 打印标题行
		for (int i = Calendar.SUNDAY; i < dayOfWeek; i++) { // 打印1号之前的空格，循环次数：从星期天开始到本月1号的天数
			System.out.print("\t");
		}
		for (int i = 1; i < maxDate; i++) { // 循环打印本月的每一天，从本月1号到maxDate号遍历循环变量i
			System.out.print(i + "\t");
			if ((dayOfWeek + i - 1) % 7 == 0) { // 如果本月i号是星期六，则打印换行，i号星期六时，"dayOfWeek+i-1"的值应该是7的整数倍
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dataStr = scanner.nextLine();
		Date date = format.parse(dataStr);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		printCalendar(calendar);
		scanner.close();
	}
}
