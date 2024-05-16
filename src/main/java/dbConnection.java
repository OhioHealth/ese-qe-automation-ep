

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Utilities.ConfigReader;

public class dbConnection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			 
			//read config values from Json file
			
			 ConfigReader.readConfig("InputConfig.json");
			 String Connectionurl= ConfigReader.getConnectionurl();
			 
			// Register JDBC driver
			 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
					
			conn = DriverManager.getConnection(Connectionurl);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
