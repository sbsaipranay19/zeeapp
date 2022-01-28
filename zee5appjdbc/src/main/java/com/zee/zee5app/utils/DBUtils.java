package com.zee.zee5app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	private DBUtils() throws IOException {
		// TODO Auto-generated constructor stub
		properties = loadProperties();
	}
	private static DBUtils dbutils;
	public static DBUtils getInstance() throws IOException {
		if(dbutils ==null)
			dbutils = new DBUtils();
		return dbutils;
	}
	
	public Connection	getConnection() {
		Connection connection = null;
		
		try {
			properties = loadProperties();
			
		connection =	DriverManager.getConnection
			(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.username"),
					properties.getProperty("jdbc.password"));
			
			System.out.println(properties);
			return connection;
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Properties properties ;
	private Properties loadProperties() throws IOException {
	InputStream inputStream = 	DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
	
	Properties properties = new Properties();
	properties.load(inputStream);	
	return properties;
	
	}
}