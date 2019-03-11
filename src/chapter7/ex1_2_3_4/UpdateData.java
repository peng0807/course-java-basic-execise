package chapter7.ex1_2_3_4;

import java.sql.*;

//导入相关类
public class UpdateData {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  // 载入MySQL的JDBC驱动类 "com.mysql.jdbc.Driver"
			String url = "jdbc:mysql://localhost/mydb?user=root";  // 定义数据库连接字符串，连接数据库mydb
			//使用DriverManager的getConnection方法获取数据库连接对象
			con = DriverManager.getConnection(url);
			System.out.println("连接数据库成功");
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
		try {
			stmt = con.createStatement();  // 使用con的createStatement方法创建语句对象
			String sql = "delete from student";  //定义delete from语句，删除student表的所有记录
			stmt.executeUpdate(sql);  // 使用stmt的executeUpdate方法更新数据库
			System.out.println("删除数据成功");
			sql = "insert into student values('01', '李四')"; // 定义insert into语句，将你的学号和姓名插入到student表中
			stmt.executeUpdate(sql);
			System.out.println("插入数据成功");
			sql = "update student set name = '张三' where sno = '01'";  // 定义update set语句，将student表中你的名字改为张三，
			stmt.executeUpdate(sql);
			System.out.println("修改数据成功");
		} catch (SQLException e) {
			System.out.println("更新数据库出错");
			e.printStackTrace();
			return;
		}
		ResultSet rs = null;
		try {
			String sql = "select * from student";  // 定义select from语句，查询student所有的记录
			rs = stmt.executeQuery(sql);  //使用stmt的executeQuery方法查询数据库，返回结果集
			System.out.println("数据库中的记录是：");
			while (rs.next()) { //  使用while循环结构遍历结果集
				System.out.println(rs.getString("sno") + ":" + rs.getString("name")); // 将结果集内容以 "学号：姓名" 的格式打印出来
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
	}
}