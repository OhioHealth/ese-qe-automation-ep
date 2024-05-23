
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbConnectionTest {

	public void selectData() {
		
		// Get the connection from DbConnection
		Connection conn = dbConnection.getConnection();

		if (conn != null) {
			try {
				// prepare SQL query to select from table
				
				String sql = "select * from txn_job_instance where job_id = 46 and status = 'COMPLETED' and  job_file_name='PEP_3dayXpilot_outgoing_110.txt'";
				PreparedStatement statement = conn.prepareStatement(sql);
				
				// Execute the query
				
				ResultSet resultSet = statement.executeQuery();
				
				//Process the results
				
				if (resultSet != null) {
					System.out.println(resultSet);
					}
				else{
					System.out.println("The job got skipped");
				}

				// Close resources
				
				resultSet.close();
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				// prepare SQL query to select from table
				
				String sql = "SELECT TOP(1) campaign_id,delivery_status_time FROM txn_subscription_ob_comm_history WHERE campaign_id = 60 and delivery_status_time>= (dateadd(minute, -5, getdate())) ORDER by delivery_status_time desc";
				PreparedStatement statement = conn.prepareStatement(sql);
				
				// Execute the query
				
				ResultSet resultSet = statement.executeQuery();
				//Process the results
				if (resultSet != null) {
					System.out.println(resultSet);
				 }
				else{
					System.out.println("The message was skipped");
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
