package studentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertdb2 {
	public static void main(String[]args) {
		Connection conn=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shri","root","Shri123MYSQL");
			String query="insert into college1(regnum,name,age,city) values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,"111");
			ps.setString(2,"shri");
			ps.setString(3,"20");
			ps.setString(4,"erode");
			ps.addBatch();
			
			ps.setString(1,"112");
			ps.setString(2,"niki");
			ps.setString(3,"20");
			ps.setString(4,"yercaud");
			ps.addBatch();
			
			ps.executeBatch();
			System.out.println("batch inserted successfully");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
			
		}
	}

