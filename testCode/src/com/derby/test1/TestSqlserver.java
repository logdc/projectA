package com.derby.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by applec on 16/6/15.
 */
public class TestSqlserver {


	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// 载入驱动
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
// 建立连接
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://10.211.55.8:49180;instance=SQLEXPRESS;DatabaseName=collinedb",
				"longbin", "creditderivative");
// 创建状态
		Statement stmt = con.createStatement();
// 执行SQL语句，返回结果集
		ResultSet rs = stmt.executeQuery("SELECT * FROM databaseversion");
// 对结果集进行处理
		while (rs.next()) {
			String versionString = rs.getString("versionString");
			System.out.println("versionString: " + versionString);
		}
// 释放资源
		stmt.close();
		con.close();
	}
}
