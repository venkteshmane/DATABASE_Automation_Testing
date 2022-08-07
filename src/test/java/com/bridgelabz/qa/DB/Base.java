package com.bridgelabz.qa.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public static Connection con;
	
	@BeforeTest
	public Connection setUp() throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/db_automation";
		String username = "root";
		String password = "Mysql@18";
		Connection con = DriverManager.getConnection(dburl,username,password);
		 return con;
	}
		 @AfterTest
			public void tearDown() throws SQLException {
		        con.close();
		}}
