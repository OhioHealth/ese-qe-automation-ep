

import java.io.FileWriter;
import java.io.IOException;

import Utilities.ConfigReader;

public class createTxtfile {

    public static void main(String[] args) {
    	
    	ConfigReader.readConfigdata("InputConfig.json");
		String localFileName= ConfigReader.getTextFilename();
	
        String textFile = localFileName;
        String delimiter = "|";

        // Sample data
        String[][] patientData = {
                {"05/11/2022", "9:20 AM", "Test, Jean M", "OhioHealth Primary Care Physicians1", "Jeffrey Lee Neuhauser", "OPG PCP WASHINGTON [1019222005]", "614-599-5587", "xxx-xx-0000", "6002972585", "English", "11/23/1958", "1196730109", "Self", "Barlow", "Jean", "2297388465", "Phone^Text message", "614-599-5587", "75 Washington Blvd,Kenton OH 43326-4001", "ESTABLISHED/OFFICE VISIT [220]", "10724228","Please bring a photo ID, insurance card, all medication bottles, and method of payment for any co-pay and/or co-insurances.", "NEUHAUSER, JEFFREY LEE [103147]", "Person","", "614-599-5587", "9:05 AM", "ACTIVATED", "Completed", "Yes", "1326080821", "http://www.google.com", "Not Confirmed","|"}
                };
                // Add more data as needed


        try (FileWriter writer = new FileWriter(textFile)) {
            // Writing data
            for (String[] patient : patientData) {
                for (int i = 0; i < patient.length; i++) {
                    writer.write(patient[i]);
                    if (i != patient.length - 1)
                        writer.write(delimiter);
                }
            
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
