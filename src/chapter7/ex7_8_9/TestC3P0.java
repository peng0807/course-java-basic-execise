package chapter7.ex7_8_9;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//导入相关类
public class TestC3P0 {
	public static void main(String[] args) throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource(); // 创建连接池对象
		Connection[] con = new Connection[10];
		for (int i = 0; i < 10; i++) {
			con[i] = cpds.getConnection(); // 从连接池中获取连接
			Thread.sleep(500);
			System.out.print("连接池的连接数量：" + cpds.getNumConnections());
			System.out.print("；已使用的连接数量：" + cpds.getNumBusyConnections());
			System.out.print("；未使用的连接数量：" + cpds.getNumIdleConnections());
			System.out.println();
		}
		for (int i = 0; i < 10; i++) {
			con[i].close(); // 将连接归还到连接池
			Thread.sleep(500);
			System.out.println("关闭连接" + i + "后，空闲的连接数量：" + cpds.getNumIdleConnections());
		}
		cpds.close(); // 关闭连接池
	}
}