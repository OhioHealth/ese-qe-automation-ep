
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Utilities.ConfigReader;

public class createTxtfile {

    public static void main(String[] args) {
    	
    	ConfigReader.readConfigdata("InputConfig.json");
 
		String localFileName= ConfigReader.getTextFilename();
		int campaignId= ConfigReader.getCampaignId();
		List<List<String>> fileData = ConfigReader.getFileData();
        String textFile = "test";
        String delimiter = "|";

      
                // Add more data as needed


        try (FileWriter writer = new FileWriter(textFile)) {
            // Writing data
        	for (List<String> patient : fileData) {
                for (int i = 0; i < patient.size(); i++) {
                    writer.write(patient.get(i));
                    if (i != patient.size() - 1)
                        writer.write(delimiter);
                }
                writer.write(System.lineSeparator()); // New line after each record
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
