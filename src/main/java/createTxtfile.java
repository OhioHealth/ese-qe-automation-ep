import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import Utilities.ConfigReader;

public class createTxtfile {
	
	public static String fname="";

    public static void main(String[] args) {
    	
    	ConfigReader.readConfigdata("InputConfig.json");
 
	
		int campaignId= ConfigReader.getCampaignId();
		 String localFileName = getDbFileName(campaignId);
		// Append a random number to the file name for uniqueness
	        localFileName = appendRandomNumberToFilename(localFileName);
	         fname=localFileName;

	        // Read data from the JSON configuration
	        List<List<String>> fileData = ConfigReader.getFileData();
	        
	        // Write data to a text file
	        writeDataToFile(localFileName, fileData, "|");

	        System.out.println("Generated File: " + localFileName);
	        System.out.println("Generated File: " + fname);
	        
}		

    private static String getDbFileName(int campaignId) {
        String dbFileName = null;
        String sql = "SELECT File_name FROM ref_batch_jobs WHERE batch_type = 'INBOUND' AND campaign_id = ?";

        // Use try-with-resources to automatically close resources
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, campaignId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    dbFileName = resultSet.getString("File_name");
                } else {
                    System.out.println("No file name found for campaign ID: " + campaignId);
                }
                
             // Close resources
				
				resultSet.close();
				statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbFileName;
    }
    
    
    private static void writeDataToFile(String fileName, List<List<String>> data, String delimiter) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (List<String> record : data) {
                for (int i = 0; i < record.size(); i++) {
                    writer.write(record.get(i));
                    if (i != record.size() - 1) {
                        writer.write(delimiter);
                    }
                }
                writer.write(System.lineSeparator()); // New line after each record
            }
            
           
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String appendRandomNumberToFilename(String fileName) {
        // Define illegal characters for file names
        String illegalChars = "[\\\\/:*?\"<>|]";  // Illegal characters: \ / : * ? " < > |
        
        // Sanitize the file name by replacing illegal characters with underscores
        String sanitizedFileName = fileName.replaceAll(illegalChars, "_");

        // Generate a random number to append
        Random random = new Random();
        int randomNumber = random.nextInt(1000);  // Generates a number between 0 and 999

        // Determine if the file has an extension
        int dotIndex = sanitizedFileName.lastIndexOf(".");
        if (dotIndex != -1) {
            // Insert the random number before the file extension
            return sanitizedFileName.substring(0, dotIndex) + "_" + randomNumber + sanitizedFileName.substring(dotIndex);
        } else {
            // If no file extension, just append the random number
            return sanitizedFileName + "_" + randomNumber + ".txt";
        }
    }    
    
    
    
    
    
    
    
    
    
    
    
}
