package chapter7.ex1_2_3_4;

import java.sql.*;
import java.util.Date;

//导入相关类
public class BatchUpdate {
	public static void main(String[] args) throws Exception{ // 忽略异常处理
		//定义学号数组和姓名数组，数组的大小是1000
		int size = 1000;
		String[] sno = new String[size];
		String[] name = new String[size];
		for(int i=0; i<size; i++) {
			sno[i] = String.format("%13d", i);  // 学号的格式是："000000000xxxx"
			name[i] = "name" + i;  // 姓名的格式是："namex"
		}
		Class.forName("com.mysql.jdbc.Driver");
		String url =  "jdbc:mysql://localhost/mydb?user=root&rewriteBatchedStatements=true"; // 定义连接字符串，需要设置以下参数，来启动批处理操作：rewriteBatchedStatements=true
		Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from student");   //定义delete from语句，并使用stmt删除数据库中的所有记录
		//使用stmt和非批处理的方式插入1000条记录
		Date begin = new Date();
		for(int i=0; i<size; i++) {
			stmt.executeUpdate("insert into student values('" + sno[i] + "', '" + name[i] + "')"); //  定义insert into 语句，将sno[i] 和 name[i] 插入到数据库中
		}
		Date end = new Date();
		long duration = end.getTime() - begin.getTime();
		System.out.println("非批量更新所需的时间是：" + duration + "毫秒");
		stmt.executeUpdate("delete from student"); // 定义delete from语句，并使用stmt删除数据库中的所有记录
		String psSql = "insert into student values(?,?)";  // 定义insert into 语句，使用预处理语句格式
		PreparedStatement ps = con.prepareStatement(psSql);  //创建预处理语句对象
		//使用ps和批处理的方式插入1000条记录
		begin = new Date();
		for(int i=0; i<size; i++) {
			ps.setString(1, sno[i]);   // 通过ps的setString方法设置第1个参数为sno[i]
			ps.setString(2, name[i]);   // 通过ps的setString方法设置第2个参数为[i]
			ps.addBatch();   // 添加批处理语句
		}
		ps.executeBatch(); // 执行批处理语句
		end = new Date();
		duration = end.getTime() - begin.getTime();
		System.out.println("批量更新所需的时间是：" + duration + "毫秒");
		stmt.close();
		ps.close();
		con.close();
	}
}