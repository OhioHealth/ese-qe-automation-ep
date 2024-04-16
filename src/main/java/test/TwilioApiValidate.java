package test;


import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import Twilioapi.TwilioApicall;



class TwilioApiValidate {

	   @Test
	    public void TwilioApicall_Success() {
	        String apiUrl = "https://api-staging.ohiohealth.com/enterprise-communications/send-text-message?to=111-111-1111&message=test";
	        String clientId = "";
	        String api_secret = "$2a$10$LNyO.EV3xEpsF9JCBO0KJeJoTyPauSJ6BFsKyLqGkKXleYAr2w1b2";

	        JSONObject response = TwilioApicall.callAPI(apiUrl, clientId, api_secret);

	        assertNotNull(response);
	    }

	    @Test
	    public void TwilioApicall_Failure() {
	        String apiUrl = "https://api-staging.ohiohealth.com/enterprise-communications/send-text-message?to=111-111-1111&message=test";
	        String clientId = "";
	        String api_secret = "$2a$10$LNyO.EV3xEpsF9JCBO0KJeJoTyPauSJ6BFsKyLqGkKXleYAr2w1b2";

	        JSONObject response = TwilioApicall.callAPI(apiUrl, clientId, api_secret);

	        assertNull(response);
	    }

}
