package com.bridgelabz.qa.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class DB_Test extends Base{
	@Test (priority=1)
	public void getTableData() throws SQLException {
		con=this.setUp();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Emp");
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			System.out.println(id+" "+name+" "+email);
		}
	}
	@Test (priority=2)
	public void insertData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("insert into emp(id,name,email)values(?,?,?)");
		stmt.setInt(1, 6); 
		stmt.setString(2, "Kalpesh.B");
		stmt.setString(3, "kalpesh.1@gmail.com");
		stmt.executeUpdate();
		getTableData();		
	}
	
	@Test (priority=3)
	public void updateData() throws SQLException {   
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("update EMP set name='Neeta' where id = ?"); 
//		stmt.setString(1,"Kalpesh.B");
		stmt.setInt(1, 5);
		stmt.executeUpdate();
		getTableData();
	}
	
	@Test (priority=4)
	public void deleteData() throws SQLException {   
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("delete from EMP where id=? ");
		stmt.setInt(1, 4);
		stmt.executeUpdate();
		getTableData();
	}
	
	
}