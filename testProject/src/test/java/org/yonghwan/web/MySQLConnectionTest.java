package org.yonghwan.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/projectdb";
	private static final String USER = "yonghwan";
	private static final String PW = "";

	
	@Test
	public void testConnection() throws Exception {

		System.out.println("d");
		Class.forName(DRIVER);
	
		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}