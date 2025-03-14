package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() {
	    Connection connection = null;
	    try {
	        //String url = "jdbc:mysql://192.168.87.24:3306/librarydb"; // change for you
	    	String url = "jdbc:mysql://localhost:3306/hr_schema";
	    	String username = "root"; // change for you
	        String password = "root"; // change for you
	        connection = DriverManager.getConnection(url, username, password);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return connection;
	}
	
	public static void main(String[] args) {
	    Connection conn = DBUtil.getConnection();
	    if (conn != null) {
	        System.out.println("Connection established successfully!");
	    } else {
	        System.out.println("Failed to establish connection.");
	    }
	}
}
	
