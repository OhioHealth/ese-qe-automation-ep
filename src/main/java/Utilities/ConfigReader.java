package Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class ConfigReader {

    private static String sftpHost;
    private static int sftpPort;
    private static String sftpUsername;
    private static String sftpPassword;
    private static String sftpRemoteFilePath;
    private static String textFilename;
    private static int campaignId;
    private static List<List<String>> fileData = new ArrayList<>();
    private static String dbServername;
    private static String dbName;
    private static int dbPort;
    private static String dbUsername;
    private static String dbConnectionurl;
    private static String dbPassword;

    public static void readConfigdata(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Read SFTP configuration
            JsonNode sftpNode = rootNode.get("sftp");
            sftpHost = sftpNode.get("host").asText();
            sftpPort = sftpNode.get("port").asInt();
            sftpUsername = sftpNode.get("username").asText();
            sftpPassword = sftpNode.get("password").asText();
            sftpRemoteFilePath = sftpNode.get("remoteFilePath").asText();
            // Read Textfile configuration
            JsonNode textFileNode = rootNode.get("textFile");
            Random random= new Random();
            int randomNumber=random.nextInt(1000);
            textFilename = textFileNode.get("filename").asText()+randomNumber+".txt";
            campaignId = textFileNode.get(campaignId).asInt();
            JsonNode fileDataNode = textFileNode.get("fileData");
            for (JsonNode recordNode : fileDataNode) {
                List<String> record = new ArrayList<>();
                for (JsonNode fieldNode : recordNode) {
                    record.add(fieldNode.asText());
                }
                fileData.add(record);
            }

            // Read DBConnect configuration
            JsonNode dbConnectNode = rootNode.get("dbConnect");
            dbServername = dbConnectNode.get("servername").asText();
            dbName = dbConnectNode.get("dbname").asText();
            dbPort = dbConnectNode.get("port").asInt();
            dbUsername = dbConnectNode.get("username").asText();
            dbPassword = dbConnectNode.get("password").asText();
            dbConnectionurl = dbConnectNode.get("Connectionurl").asText();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter methods for accessing global variables
    public static String getSftpHost() {
        return sftpHost;
    }

    public static int getSftpPort() {
        return sftpPort;
    }

    public static String getSftpUsername() {
        return sftpUsername;
    }

    public static String getSftpPassword() {
        return sftpPassword;
    }
    public static String getsftpRemoteFilePath() {
        return sftpRemoteFilePath;
    }
    
    public static int getCampaignId() {
        return campaignId;
    }

    public static List<List<String>> getFileData() {
        return fileData;
    }
    
    public static String getTextFilename() {
        return textFilename;
    }
    public static class fileName {
  	  public static final String file_Name = textFilename;
  	}
    public static String getDbServername() {
        return dbServername;
    }

    public static String getDbName() {
        return dbName;
    }

    public static int getDbPort() {
        return dbPort;
    }

    public static String getDbUsername() {
        return dbUsername;
    }
  
    public static String getDbPassword() {
        return dbPassword;
    }
    
    public static String getConnectionurl() {
        return dbConnectionurl;
    }
}

