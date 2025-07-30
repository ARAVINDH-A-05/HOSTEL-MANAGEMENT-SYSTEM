package studentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertdb1 {
	public static void main(String[]args) {
		Connection conn=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shri","root","Shri123MYSQL");
			st=conn.createStatement();
			String query="insert into college1 values(070,'Mathu',19,'Salem')";
			st.executeUpdate(query);
			System.out.println("Record Inserted successfully");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}