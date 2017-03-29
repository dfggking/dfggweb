package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class testMysql {

	
	
	final static String driver = "com.mysql.cj.jdbc.Driver";
	final static String url = "jdbc:mysql://118.178.195.144:3306/dfgg_db";
	final static String username = "jinyf";
	final static String pwd = "!QAZxsw2";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, pwd);
		String sql = "select * from dic where id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "123");
		ResultSet rs = pstm.executeQuery();
		int col = rs.getMetaData().getColumnCount();
		while(rs.next()) {
			for (int i = 1; i < col; i++) {
				System.out.println(rs.getString(i));
			}
		}
		
		
	}

}
