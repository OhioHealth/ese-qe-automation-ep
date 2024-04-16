package Twilioapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class TwilioApicall {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://api-staging.ohiohealth.com/enterprise-communications/send-text-message?to=111-111-1111&message=test";
            String clientId = " ";
            String api_secret = "$2a$10$LNyO.EV3xEpsF9JCBO0KJeJoTyPauSJ6BFsKyLqGkKXleYAr2w1b2";

            JSONObject response = callAPI(apiUrl, clientId, api_secret);

            if (response != null) {
                if (response.has("messageId")) {
                    System.out.println("Response code: 200 OK");
                    System.out.println("ID found in response: " + response.getString("messageId"));
                } else {
                    System.out.println("ID not found in response");
                }
            } else {
                System.out.println("Failed to get response from the API");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject callAPI(String apiUrl, String clientId, String api_secret) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Client_Id", clientId);
            connection.setRequestProperty("Api_Secret", api_secret);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();
                return new JSONObject(response.toString());
            } else {
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
