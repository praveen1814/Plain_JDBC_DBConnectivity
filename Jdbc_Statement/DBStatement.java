package JDBC_Connectivity.jdbc_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBStatement {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String pwd="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,pwd);
		Statement st=con.createStatement();
		int rows =st.executeUpdate("update employee set name='sanku' where empid=156;");
		System.out.println(rows +" successfully updated");
		ResultSet rs=st.executeQuery("select * from employee;");
		System.out.println("empid\tempname\tdept\tloc");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\n");
		}
		

	}

}
