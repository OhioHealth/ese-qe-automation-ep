package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestdbConnection {
	
	public void selectData() {
		Connection conn = DbConnection.getConnection();
		
		if(conn != null) {
		try {
			String sql = "select top 1 campaign_id  from ref_batch_jobs";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
		   System.out.println(resultSet);
		
		resultSet.close();
		statement.close();
		
	}catch (SQLException e) {
		e.printStackTrace();
	}

} else {
	System.out.println("Failed to establish DB connection");
	}	
}
}
