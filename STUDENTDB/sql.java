package studentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sql {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Shri123MYSQL");
			stat=conn.createStatement();
			int status=stat.executeUpdate("Create database shri");
			if(status>0) {
				System.out.println("Database created");
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
