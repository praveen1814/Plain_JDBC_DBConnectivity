package JDBC_Connectivity.Jdbc_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPrepardStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String pwd="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,pwd);
		String quary="insert into employee values(?,?,?,?);";
		PreparedStatement pt=con.prepareStatement(quary);
		pt.setInt(1,881);
		pt.setString(2, "ragav");
		pt.setString(3, "tech");
		pt.setString(4, "hyd");
		System.out.println("no of changes to "+ pt.executeUpdate());
		
		String q="select *from employee";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		System.out.println("deptid\tname\tdept\tloc");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.println(rs.getString(4)+"\n");
		}
		rs.close();
		pst.close();
		pt.close();
		con.close();
		
	}

}
