package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestdbConnection {

	public void selectData() {
		
		// Get the connection from DbConnection
		Connection conn = DbConnection.getConnection();

		if (conn != null) {
			try {
				// prepare SQL query to select from table
				String sql = "select top 5 campaign_id  from ref_batch_jobs";
				PreparedStatement statement = conn.prepareStatement(sql);
				// Execute the query
				ResultSet resultSet = statement.executeQuery();
				//Process the results
				while (resultSet.next()) {
					int campaign_id = resultSet.getInt("campaign_id");
					System.out.println("campaign_id =" + campaign_id);
				}

				// Close resources
				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Failed to establish DB connection");
		}
	}
}
