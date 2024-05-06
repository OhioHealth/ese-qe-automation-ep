package test;


import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import Twilioapi.TwilioApicall;



class TwilioApiValidate {

	   @Test
	    public void TwilioApicall_Success() {
	        String apiUrl = "https://api-staging.ohiohealth.com/enterprise-communications/send-text-message?to=111-111-1111&message=test";
	        String clientId = "";
	        String api_secret = "$2a$10$LNyO.EV3xEpsF9JCBO0KJeJoTyPauSJ6BFsKyLqGkKXleYAr2w1b2";

	        JSONObject response = TwilioApicall.callAPI(apiUrl, clientId, api_secret);
	        
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
        } 
		  


}
