package io.database;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DataBaseConnection {
	
	
	
	private static String dburl = "jdbc:mysql://localhost:3306/login";
	private static String username = "root";
	private static String  password = "root";
	static Map<String, String> logincred = new HashMap<String,String>();
	static Object[][] logincredentials;
	private static String query = "Select * from login_credentials;";
		
	public static Object[][] createConnection()
	{
		try {
			Connection connection =  DriverManager.getConnection(dburl, username, password);
			Statement stmt= connection.createStatement();
			ResultSet result = stmt.executeQuery(query);
			ResultSetMetaData metaData = result.getMetaData();
			for(int i=0; i<metaData.getColumnCount(); i++)
			{
				for(int j=0; j<metaData.getColumnCount(); j++)
				{
					logincredentials[i][j] = result.getString(j);
				}
//				logincred.put(result.getString(i), result.getString(i+1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logincredentials;
	}
	
}
