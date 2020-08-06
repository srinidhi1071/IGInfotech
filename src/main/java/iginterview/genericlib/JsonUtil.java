package iginterview.genericlib;

import io.restassured.response.Response;

public class JsonUtil {
	
	public static String getJsonString(Response response, String jsonPath) {
		return response.getBody().jsonPath().get(jsonPath).toString();
	}

}
