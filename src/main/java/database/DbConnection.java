package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	
	//public static void main(String[] args) throws ClassNotFoundException, SQLException{
	//	Connection connection = null;
	//	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	//	String Connectionurl="jdbc:sqlserver://wdttsol01:1433;DatabaseName=ent_communications;user=app_ent_communications;password=2Wsx#edc";
	//	connection = DriverManager.getConnection(Connectionurl);
		
	//}

	public static Connection getConnection() {
		Connection conn = null;
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String Connectionurl="jdbc:sqlserver://wdttsol01:1433;DatabaseName=ent_communications;user=app_ent_communications;password=2Wsx#edc";
		conn = DriverManager.getConnection(Connectionurl);
		}catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
			}
		return conn;
        }
}
