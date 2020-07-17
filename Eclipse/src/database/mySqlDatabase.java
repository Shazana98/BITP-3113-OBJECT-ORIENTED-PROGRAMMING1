package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mySqlDatabase {

	private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/waowresort?useSSL=false";
	private static String USER = "root";
	private static String PASS = "root";
	
	public static Connection doConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		return conn;
	}
	
	public static void main(String[] args) 
	{
		try {
			Connection conn = mySqlDatabase.doConnection();
			System.out.println(conn);
		} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		
	}
}