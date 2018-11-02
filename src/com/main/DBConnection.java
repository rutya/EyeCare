package com.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection;
	public static Connection getConnection()
	{
		try {
			if(connection==null||connection.isClosed())
				new DBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  connection;
	}
	
	private DBConnection()
	{
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String username="sqlserveruser1";
			String password="sqlserver";
			String url="jdbc:sqlserver://127.0.0.1\\SQLEXPRESS"+";databaseName=EyeCare";
			connection=DriverManager.getConnection(url,username,password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	
	
}
