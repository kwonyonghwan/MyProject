package org.yonghwan.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class jdbcTest {
	@Test
	public void testConnection() throws Exception {
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectdb", "yonghwan", "dkffkq123");
			System.out.println(conn);
		} catch (SQLException ex) {
			ex.printStackTrace();
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
}