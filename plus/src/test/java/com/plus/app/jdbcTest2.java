package com.plus.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class jdbcTest2 {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/projectdb";

	private static final String USER = "yonghwan";
	private static final String PW = "dkffkq123";

	@Test
	public void test() {
		try {
			
			Class.forName(DRIVER);
			//Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
		}

		Connection conn = null;
		try {
		  conn = DriverManager.getConnection(URL, USER, PW);
			} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM test_table");

			// or alternatively, if you don't know ahead of time that
			// the query will be a SELECT...

			if (stmt.execute("SELECT * FROM test_table")) {
				rs = stmt.getResultSet();
			}
		} catch (Exception ex) {
			// handle the error
		}

		try {
			
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println(name + " " + age);
			}
		} catch (Exception ex) {
			// handle the errora
		}
	}//test

}//class