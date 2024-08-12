package JDBC_Connectivity.Jdbc_CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBCallableStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String pwd="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,pwd);
		CallableStatement cst=con.prepareCall("{call three(?)}");
		ResultSet rs=cst.executeQuery();
		while(rs.next())
		{
			System.out.print(rs.getInt(0)+"\t");
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.println();
		}
		
		System.out.println("rows are Updated" + cst.executeUpdate());

	}

}
