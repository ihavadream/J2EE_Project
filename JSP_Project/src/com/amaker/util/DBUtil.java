package com.amaker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mvc_project";
		String user="root";
		String password="";
		
//		String driver="oracle.jdbc.driver.OracleDriver";
//		String url="jdbc:oracle:thin:@localhost:1521:orcl";
//		String user="xishi";
//		String password="123456";
		
		
		
		public Connection getConnection(){
				try {
					Class.forName(driver);
					return DriverManager.getConnection(url, user, password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return null;
		}

		public void close(Connection conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
