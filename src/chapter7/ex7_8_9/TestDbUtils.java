package chapter7.ex7_8_9;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//导入相关类
public class TestDbUtils {
	public static void main(String[] args) throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource(); // 创建连接池对象
		Connection con = cpds.getConnection(); // 使用cpds的getConnection方法，从连接池中获取连接
		QueryRunner runner = new QueryRunner(); // 创建QueryRunner对象

		// 根据id，查找某条记录
		String sql = "select * from user where id=?";
		BeanHandler<User> beanHandler = new BeanHandler<User>(User.class); // 创建BeanHandler对象，能将查询结果转换为User对象
		User user = runner.query(con, sql, beanHandler, 1); // 提供查询sql语句中的参数：id的值
		System.out.println(user);

		// 根据id，修改某条记录的name
		sql = "update user set name=? where id=?";
		runner.update(con, sql, "张三", 1);

		// 获取user表中的所有记录
		sql = "select * from user";
		BeanListHandler<User> beanListHandler = new BeanListHandler<User>(User.class); // 创建BeanListHandler对象，能将查询结果转换为List<User>集合
		List<User> list = runner.query(con, sql, beanListHandler); // 使用runner的query方法，传递实参：con, sql, beanListHandler
		for (User u : list) { // 遍历list集合
			System.out.println(u);
		}

		con.close();
		cpds.close();
	}
}