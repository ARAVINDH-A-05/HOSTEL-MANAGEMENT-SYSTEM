package studentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertdb {
	public static void main(String[]args) {
		Connection conn=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shri","root","Shri123MYSQL");
			st=conn.createStatement();
			String query="create table college1(regnum int,name varchar(20),age int,city varchar(20))";
			st.executeUpdate(query);
			System.out.println("Table created successfully");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
