package chapter7.ex1_2_3_4;

import java.sql.*;
import java.util.*;

public class TestJDBC {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  // 载入MySQL的JDBC驱动类 "com.mysql.jdbc.Driver"
			String url = "jdbc:mysql://localhost/mydb?user=root";  // 定义数据库连接字符串，连接数据库mydb
			//使用DriverManager的getConnection方法获取数据库连接对象
			con = DriverManager.getConnection(url);
			System.out.println("成功连接数据库");
		} catch (ClassNotFoundException e) {
			System.out.println("载入JDBC驱动类出错");
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			System.out.println("创建数据库连接出错");
			e.printStackTrace();
			return;
		}

		Statement stmt = null;
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<Student>();  // 创建java.util.ArrayList类型的集合对象
		try {
			String sql = "select * from student";  // 定义数据库sql语句，查询student表中所有内容
			stmt = con.createStatement();  // 使用con的createStatement方法创建语句对象
			rs = stmt.executeQuery(sql);   // 使用stmt的executeQuery查询数据库，并返回结果集
			while(rs.next()) { // 使用while循环结构遍历结果集
				String sno = rs.getString("sno");  
				String name = rs.getString("name"); // 获取记录中的name字段的值
				Student student = new Student(sno, name);
				studentList.add(student); // 将student对象添加到studentList集合中
			}
		} catch (SQLException e) {
			System.out.println("查询数据库出错");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭资源出错");
				e.printStackTrace();
				rs = null;
				stmt = null;
				con = null;
			}
		}
		// [代码11]遍历studentLisy集合中的所有元素，并打印这些元素的信息
		for(Student student : studentList) {
			System.out.println(student);
		}
	}
}