package Twilioapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class TwilioApivalidate {
    public static void main(String[] args) {
        try {
            // URL of the API
            String apiUrl = "https://api-staging.ohiohealth.com/enterprise-communications/send-text-message?to=614-599-5587&message=test";
            // Replace "your_client_id" and "your_secret_id" with your actual client and secret IDs
            String client_Id = " ";
            String api_secret = "$2a$10$LNyO.EV3xEpsF9JCBO0KJeJoTyPauSJ6BFsKyLqGkKXleYAr2w1b2";
         //   String twilio_cert = "MIIFnTCCBIWgAwIBAgIIAjy9H849+E8wDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV.....A==";

            // Create a URL object with the API URL
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");

            // Set request headers for authentication
            connection.setRequestProperty("client_Id", client_Id);
            connection.setRequestProperty("api_secret", api_secret);
           // connection.setRequestProperty("Cert-Id", twilio_cert);

            // Check if the response code is 200 (OK)
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Read the response from the API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the response JSON
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Check if the response contains an "id" field
                if (jsonResponse.has("messageId")) {
                    System.out.println("Response code: 200 OK");
                    System.out.println("ID found in response: " + jsonResponse.getString("messageId"));
                } else {
                    System.out.println("ID not found in response");
                }
            } else {
                System.out.println("Failed to get response from the API. Response code: " + connection.getResponseCode());
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
