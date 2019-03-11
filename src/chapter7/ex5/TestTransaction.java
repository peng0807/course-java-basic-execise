package chapter7.ex5;

import java.sql.*;

//导入相关类
public class TestTransaction {
	// 定义获取数据库连接的方法getConnection
	public static Connection getConnection(String url) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 载入MySQL的JDBC驱动类
			con = DriverManager.getConnection(url); // 获取数据库连接对象
			System.out.println("连接数据库成功");
		} catch (ClassNotFoundException e) {
			System.out.println("载入JDBC驱动类出错");
		} catch (SQLException e) {
			System.out.println("创建数据库连接出错");
		}
		return con;
	}

	// 定义关闭数据库资源的方法close
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			rs = null;
			ps = null;
			con = null;
			e.printStackTrace();
		}
	}

	// 主方法main
	public static void main(String[] args) {
		// 以下三个变量的值可根据你自己数据库中的值进行修改
		int fromId = 1; // 源账号id
		int toId = 2; // 目的账号id
		float amount = 1000; // 转账金额，

		// 创建数据库连接
		String url = "jdbc:mysql://localhost/mydb?user=root"; // 定义数据库连接字符串
		Connection con = getConnection(url); // 调用getConnection方法，获取数据库连接
		if (con == null) {
			System.out.println("创建数据库连接失败");
			return;
		}

		// 查询源账户金额
		PreparedStatement ps = null;
		ResultSet rs = null;
		float fromBalance = 0; // 原账户金额
		try {
			String sql = "select balance from account where id=?"; // 定义sql语句，根据源账户id查询源账户金额
			ps = con.prepareStatement(sql);
			ps.setInt(1, fromId); // 设置ps第一个参数的值
			rs = ps.executeQuery();
			if (rs.next()) {
				fromBalance = rs.getFloat("balance"); // 从rs中获取查询字段 balance的值
			} else {
				System.out.println("源账户不存在，转账失败");
				close(con, ps, rs); // 调用自定义的close方法，关闭数据库资源
				return;
			}
			rs.close();
			ps.close();

			// 查询目的账户是否存在
			sql = "select id from account where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, toId);
			rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("目的账户不存在，转账失败");
				close(con, ps, rs);
				return;
			}
			rs.close();
			ps.close();

			// 只有在源账户金额>转账金额的情况下，才进行转账操作
			if ((fromBalance - amount) > 0) {
				con.setAutoCommit(false); // 禁用事务的自动提交，自定义事务边界（开始）
				sql = "update account set balance=(balance-?) where id=?"; // 将源账户金额减去转账金额
				ps = con.prepareStatement(sql);
				ps.setFloat(1, amount); // 设置ps第一个参数的值
				ps.setInt(2, fromId);
				ps.executeUpdate();
				ps.close();

				// 类似上面的操作，将目的账户的金额加上转账金额
				sql = "update account set balance=(balance+?) where id=?";
				ps = con.prepareStatement(sql);
				ps.setFloat(1, amount);
				ps.setInt(2, toId);
				ps.executeUpdate();
				ps.close();

				try {
					con.commit(); // 手动提交事务
					System.out.println("转账成功");
				} catch (Exception e) {
					con.rollback(); // 进行事务回滚
					System.out.println("事务执行失败，进行事务回滚");
				}
				con.setAutoCommit(true); // 启用事务的自动提交，自定义事务边界（结束）
			} else {
				System.out.println("金额不足，转账失败");
				close(con, ps, rs);
				return;
			}
		} catch (SQLException e) {
			System.out.println("数据库操作异常");
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
	}

}