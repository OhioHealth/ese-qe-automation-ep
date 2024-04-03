package filecreation;

import java.io.FileWriter;
import java.io.IOException;

public class CsvfileCreate {

    public static void main(String[] args) {
        String csvFile = "patient_data.csv";
        String delimiter = ",";

        // Sample data
        String[][] patientData = {
                {"123456", "P001", "John Doe", "1980-01-01", "42", "CSN123", "5", "Dr. Smith", "123", "ABC Clinic", "2024-04-01", "Male", "john.doe@example.com", "12345", "123-456-7890", "987-654-3210", "Dr. Johnson", "456", "Yes", "Active", "Internal Medicine", "Main Street", "123-456-7890", "123 Main St", "Yes", "789"},
                {"789012", "P002", "Jane Smith", "1975-05-10", "47", "CSN456", "3", "Dr. Brown", "456", "XYZ Clinic", "2024-03-15", "Female", "jane.smith@example.com", "54321", "555-555-5555", "666-666-6666", "Dr. White", "789", "No", "Active", "Pediatrics", "Park Avenue", "987-654-3210", "456 Park Ave", "No", "012"}
                // Add more data as needed
        };

        try (FileWriter writer = new FileWriter(csvFile)) {
            // Writing header
            writer.write("PAT_MRN_ID" + delimiter + "PAT_ID" + delimiter + "PAT_NAME" + delimiter + "PAT_DOB" + delimiter +
                    "PAT_AGE" + delimiter + "CSN" + delimiter + "NUM_OF_VISITS" + delimiter + "PROVIDER_NAME" + delimiter +
                    "STAR_VISIT_PROVIDER_ID" + delimiter + "PRACTICE_NAME" + delimiter + "CONTACT_DATE" + delimiter +
                    "PAT_GENDER" + delimiter + "PAT_EMAIL_ID" + delimiter + "PAT_ZIP_CODE" + delimiter + "PAT_HOME_PHONE" + delimiter +
                    "PAT_MOBILE_PHONE" + delimiter + "PCP_NAME" + delimiter + "STAR_PCP_PROVIDER_ID" + delimiter + "ACO_PATIENT" +
                    delimiter + "PAT_MYCHART_STATUS" + delimiter + "DEPT_NAME" + delimiter + "DEPT_LOC" + delimiter + "DEPT_PHONE_NUMBER" +
                    delimiter + "DEPT_ADDR" + delimiter + "PROVIDER_SCHEDULING_FLAG" + delimiter + "PROVIDER_NPI" + "\n");

            // Writing data
            for (String[] patient : patientData) {
                for (int i = 0; i < patient.length; i++) {
                    writer.write(patient[i]);
                    if (i != patient.length - 1)
                        writer.write(delimiter);
                }
                writer.write("\n");
            }
            System.out.println("CSV file has been generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
