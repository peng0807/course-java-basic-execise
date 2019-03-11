package chapter7.ex7_8_9;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//导入相关类
public class TestProperties {
	public static void main(String[] args) throws Exception {
		Properties pro = new Properties(); // 创建java.util.Properties对象
//		FileInputStream fis = new FileInputStream((new File("")).getAbsoluteFile() + "/db.properties");
		InputStream fis = TestProperties.class.getClassLoader().getResourceAsStream("./db.properties"); // 创建数据库配置文件的文件字节输入流对象
		pro.load(fis); // 使用pro的load方法，载入配置文件
		fis.close(); // 关闭fis
		// [使用pro的getProperty方法获取配置文件中的相关属性值
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		Class.forName(driver); // 载入驱动类
		Connection con = DriverManager.getConnection(url, user, password); // 创建数据库连接对象
		// 创建语句对象，定义查询sql语句，获取user表中的所有记录
		Statement stmt = con.createStatement();
		String sql = "select * from user";
		ResultSet rs = stmt.executeQuery(sql);
		// 遍历结果集对象，打印结果集中所有内容
		while (rs.next()) {
			System.out.println(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password")));
		}
		// 关闭数据库资源
		rs.close();
		stmt.close();
		con.close();
	}
}