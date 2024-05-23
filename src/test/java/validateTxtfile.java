import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import Utilities.ConfigReader;
import Utilities.ConfigReader.fileName;



public class validateTxtfile {

	@Test
	  public void testTxtFileCreation() {
		createTxtfile.main(new String[]{});

        // Read the content of the created file
        
        //ConfigReader
	
		String localFileName= fileName.file_Name;
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(localFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            // Assert the content of the file matches the e xpected content
            assertEquals("05/11/2022|9:20 AM|Test, Jean M|OhioHealth Primary Care Physicians1|Jeffrey Lee Neuhauser|OPG PCP WASHINGTON [1019222005]|614-599-5587|xxx-xx-0000|6002972585|English|11/23/1958|1196730109|Self|Barlow|Jean|2297388465|Phone^Text message|614-599-5587|75 Washington Blvd,Kenton OH 43326-4001|ESTABLISHED/OFFICE VISIT [220]|10724228|Please bring a photo ID, insurance card, all medication bottles, and method of payment for any co-pay and/or co-insurances.|NEUHAUSER, JEFFREY LEE [103147]|Person||614-599-5587|9:05 AM|ACTIVATED|Completed|Yes|1326080821|http://www.google.com|Not Confirmed||", content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
