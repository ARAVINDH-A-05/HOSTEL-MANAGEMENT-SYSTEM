package studentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class HostelDB {
	static final String URL="jdbc:mysql://localhost:3306/Hogwarts";
	static final String user="root";
	static final String password="Shri123MYSQL";
	static Connection conn;
	
	static Connection ConnectDB() {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(URL,user,password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return conn;
	    
	}

	public static void addb(Scanner sc) {
		System.out.println("Enter your Register Num:");
		long reg=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your Name:");
		String name=sc.nextLine();
		System.out.println("Enter your Department:");
		String dep=sc.nextLine();
		System.out.println("Enter your Year:");
		int yr=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your Block:");
		String blk=sc.nextLine();
		System.out.println("Enter your Room No:");
		int rn=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your Native City:");
		String nc=sc.nextLine();
		try {
			String query="insert into Boys_Hostel(Regno,Name,Dept,Year,Block,Room_No,Native) values(?,?,?,?,?,?,?)";
			conn=ConnectDB();
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setLong(1, reg);
			ps.setString(2,name);
			ps.setString(3,dep);
			ps.setLong(4,yr);
			ps.setString(5,blk);
			ps.setLong(6,rn);
			ps.setString(7,nc);
			ps.executeUpdate();
			System.out.println("Details added Successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	public static void viewb() {
		try {
			conn=ConnectDB();
			Statement st=conn.createStatement();
			String query="select * from Boys_Hostel";
			ResultSet rs= st.executeQuery(query);
			
			System.out.println("===============Boys Hostel===============");
			System.out.println("\n Sl\t\t|\tRegno\t\t|\t\tName\t\t|\tDept\t\t|\tYear\t|\t\tBlock\t\t|\t  Room_No  \t\t|\tNative");
			while(rs.next()) {
				int sl=rs.getInt("Sl_no");
				long rg=rs.getLong("Regno");
				String name=rs.getString("Name");
				String dep=rs.getString("Dept");
				int yr=rs.getInt("Year");
				String bk=rs.getString("Block");
				int r=rs.getInt("Room_No");
				String na=rs.getString("Native");
				System.out.print(sl+"\t\t\t"+rg+"\t\t\t"+name+"\t\t\t"+dep+"\t\t\t"+yr+"\t\t\t"+bk+"\t\t\t"+r+"\t\t\t"+na);
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateb(Scanner sc) throws SQLException {
		conn=ConnectDB();
		System.out.println("Enter the Sl no to be updated:");
		int sl=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter What to Update");
		System.out.println("1.Reg no\n2.Name\n3.Dept\n4.Year\n5.Block\n6.Room no\n7.Native");
		int ca=sc.nextInt();
		sc.nextLine();
		switch(ca) {
		case 1:
			System.out.println("Enter new Reg no:");
			long reg=sc.nextLong();
			String query="update Boys_Hostel set Regno=? WHERE Sl_no=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(2, sl);
			ps.setLong(1, reg);
			int rows=ps.executeUpdate();
			if(rows>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;

		case 2:
			System.out.println("Enter new Name:");
			String na=sc.nextLine();
			String q="update Boys_Hostel set Name=? WHERE Sl_no=?";
			PreparedStatement p=conn.prepareStatement(q);
			p.setInt(2, sl);
			p.setString(1, na);
			int r=p.executeUpdate();
			if(r>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 3:
			System.out.println("Enter new Dept:");
			String dep=sc.nextLine();
			String qu="update Boys_Hostel set Dept=? WHERE Sl_no=?";
			PreparedStatement prs=conn.prepareStatement(qu);
			prs.setInt(2, sl);
			prs.setString(1, dep);
			int ro=prs.executeUpdate();
			if(ro>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 4:
			System.out.println("Enter new Year:");
			int yr=sc.nextInt();
			String que="update Boys_Hostel set Year=? WHERE Sl_no=?";
			PreparedStatement pres=conn.prepareStatement(que);
			pres.setInt(2, sl);
			pres.setInt(1, yr);
			int row=pres.executeUpdate();
			if(row>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 5:
			System.out.println("Enter new Block:");
			String bl=sc.nextLine();
			String quer="update Boys_Hostel set Block=? WHERE Sl_no=?";
			PreparedStatement prest=conn.prepareStatement(quer);
			prest.setInt(2, sl);
			prest.setString(1, bl);
			int rs=prest.executeUpdate();
			if(rs>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 6:
			System.out.println("Enter new Room no:");
			int rno=sc.nextInt();
			String qusq="update Boys_Hostel set Room_No=? WHERE Sl_no=?";
			PreparedStatement presta=conn.prepareStatement(qusq);
			presta.setInt(2, sl);
			presta.setInt(1, rno);
			int rws=presta.executeUpdate();
			if(rws>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 7:
			System.out.println("Enter new Native:");
			String nat=sc.nextLine();
			String querys="update Boys_Hostel set Native=? WHERE Sl_no=?";
			PreparedStatement preds=conn.prepareStatement(querys);
			preds.setInt(2, sl);
			preds.setString(1, nat);
			int ros=preds.executeUpdate();
			if(ros>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
				}
			break;
		}
	}
	
	public static void vacateb(Scanner sc) throws SQLException {
		conn=ConnectDB();
		System.out.println("Enter the Slno to delete:");
		int sl=sc.nextInt();
		String query="delete from Boys_Hostel where Sl_no=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, sl);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Data deleted successfully");
		}else {
			System.out.println("Data not found...");
		}	
	}
	
public static void addg(Scanner sc) {
	conn=ConnectDB();
	System.out.println("Enter your Register Num:");
	long reg=sc.nextLong();
	sc.nextLine();
	System.out.println("Enter your Name:");
	String name=sc.nextLine();
	System.out.println("Enter your Department:");
	String dep=sc.nextLine();
	System.out.println("Enter your Year:");
	int yr=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter your Block:");
	String blk=sc.nextLine();
	System.out.println("Enter your Room No:");
	int rn=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter your Native City:");
	String nc=sc.nextLine();
	try {
		
		String query="insert into Girls_Hostel(Regno,Name,Dept,Year,Block,Room_No,Native) values(?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setLong(1, reg);
		ps.setString(2,name);
		ps.setString(3,dep);
		ps.setLong(4,yr);
		ps.setString(5,blk);
		ps.setLong(6,rn);
		ps.setString(7,nc);
		ps.executeUpdate();
		System.out.println("Details added Successfully");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

		
	}
	public static void viewg() {
		try {
			conn=ConnectDB();
			Statement st=conn.createStatement();
			String query="select * from Girls_Hostel";
			ResultSet rs= st.executeQuery(query);
			
			System.out.println("===============Girls Hostel===============");
			System.out.println("\n Sl\t\t|\tRegno\t\t|\t\tName\t\t|\tDept\t\t|\tYear\t|\t\tBlock\t\t|\t  Room_No  \t\t|\tNative");
			while(rs.next()) {
				int sl=rs.getInt("Sl_no");
				long rg=rs.getLong("Regno");
				String name=rs.getString("Name");
				String dep=rs.getString("Dept");
				int yr=rs.getInt("Year");
				String bk=rs.getString("Block");
				int r=rs.getInt("Room_No");
				String na=rs.getString("Native");
				System.out.print(sl+"\t\t\t"+rg+"\t\t\t"+name+"\t\t\t"+dep+"\t\t\t"+yr+"\t\t\t"+bk+"\t\t\t"+r+"\t\t\t"+na);
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateg(Scanner sc) throws SQLException {
		conn=ConnectDB();
		System.out.println("Enter the Sl no to be updated:");
		int sl=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter What to Update");
		System.out.println("1.Reg no\n2.Name\n3.Dept\n4.Year\n5.Block\n6.Room no\n7.Native");
		int ca=sc.nextInt();
		sc.nextLine();
		switch(ca) {
		case 1:
			System.out.println("Enter new Reg no:");
			long reg=sc.nextLong();
			String query="update Girls_Hostel set Regno=? WHERE Sl_no=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(2, sl);
			ps.setLong(1, reg);
			int rows=ps.executeUpdate();
			if(rows>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;

		case 2:
			System.out.println("Enter new Name:");
			String na=sc.nextLine();
			String q="update Girls_Hostel set Name=? WHERE Sl_no=?";
			PreparedStatement p=conn.prepareStatement(q);
			p.setInt(2, sl);
			p.setString(1, na);
			int r=p.executeUpdate();
			if(r>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 3:
			System.out.println("Enter new Dept:");
			String dep=sc.nextLine();
			String qu="update Girls_Hostel set Dept=? WHERE Sl_no=?";
			PreparedStatement prs=conn.prepareStatement(qu);
			prs.setInt(2, sl);
			prs.setString(1, dep);
			int ro=prs.executeUpdate();
			if(ro>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 4:
			System.out.println("Enter new Year:");
			int yr=sc.nextInt();
			String que="update Girls_Hostel set Year=? WHERE Sl_no=?";
			PreparedStatement pres=conn.prepareStatement(que);
			pres.setInt(2, sl);
			pres.setInt(1, yr);
			int row=pres.executeUpdate();
			if(row>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 5:
			System.out.println("Enter new Block:");
			String bl=sc.nextLine();
			String quer="update Girls_Hostel set Regno=? WHERE Sl_no=?";
			PreparedStatement prest=conn.prepareStatement(quer);
			prest.setInt(2, sl);
			prest.setString(1, bl);
			int rs=prest.executeUpdate();
			if(rs>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 6:
			System.out.println("Enter new Room no:");
			int rno=sc.nextInt();
			String qusq="update Girls_Hostel set Room_No=? WHERE Sl_no=?";
			PreparedStatement presta=conn.prepareStatement(qusq);
			presta.setInt(2, sl);
			presta.setInt(1, rno);
			int rws=presta.executeUpdate();
			if(rws>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
			}
			break;
		case 7:
			System.out.println("Enter new Native:");
			String nat=sc.nextLine();
			String querys="update Girls_Hostel set Native=? WHERE Sl_no=?";
			PreparedStatement preds=conn.prepareStatement(querys);
			preds.setInt(2, sl);
			preds.setString(1, nat);
			int ros=preds.executeUpdate();
			if(ros>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Sl.no not found");
				}
			break;
		}
		
	}
	
	public static void vacateg(Scanner sc) throws SQLException {
		conn=ConnectDB();
		System.out.println("Enter the Slno to delete:");
		int sl=sc.nextInt();
		String query="delete from Girls_Hostel where Sl_no=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, sl);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Data deleted successfully");
		}else {
			System.out.println("Data not found...");
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		int a;
		do {
		System.out.println("==============================Welcome To Sona Hostel===============================");
		System.out.println("************************Please Select an Option**************************");
		System.out.println(" 1. Boys Hostel");
		System.out.println(" 2. Girls Hostel");
		System.out.println(" 3. Exit");
		a=sc.nextInt();
		switch(a) {
		case 1:
			System.out.println("^^^^^^^^^^^^^^^^^^^^^Please Select an Option^^^^^^^^^^^^^^^^^^^^^");
			System.out.println(" 1. Add info");
			System.out.println(" 2. View Student details");
			System.out.println(" 3. Update details");
			System.out.println(" 4. Vacate Hostel");
			int b=sc.nextInt();
			switch(b) {
			case 1:
				addb(sc);
				break;
			case 2:
				viewb();
				break;
			case 3:
				updateb(sc);
				break;
			case 4:
				vacateb(sc);
				break;
			default:
				System.out.println("Enter valid option");
				break;
			}
			break;
		case 2:
			System.out.println("^^^^^^^^^^^^^^^^^^^^^Please Select an Option^^^^^^^^^^^^^^^^^^^^^");
			System.out.println(" 1. Add info");
			System.out.println(" 2. View Student details");
			System.out.println(" 3. Update details");
			System.out.println(" 4. Vacate Hostel");
			int c=sc.nextInt();
			switch(c) {
			case 1:
				addg(sc);
				break;
			case 2:
				viewg();
				break;
			case 3:
				updateg(sc);
				break;
			case 4:
				vacateg(sc);
				break;
			default:
				System.out.println("Enter valid option");
				break;
		    }
			break;
		case 3:
			System.out.println("Existing");
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
	}while(a!=3);
  }
}
