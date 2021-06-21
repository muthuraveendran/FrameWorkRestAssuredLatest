package helper;

import utils.UrlGenerator;

import java.util.Arrays;

import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import utils.Constants;
import utils.RestUtils;

public class NeedleNineUtils extends RestUtils {

	UrlGenerator url;
	Response response;
	RestUtils restutils = new RestUtils(Constants.folder);

	public NeedleNineUtils() {
		super(Constants.folder);
	}

	public int checkStatusCode(String uri) {
		response = restutils.get(uri);
		return response.getStatusCode();
	}

	public int checkAuthStatusCode(String uri) {
		response = restutils.getAuthStatus(uri);
		
//		JSONObject json = new JSONObject(response);
		
//		JsonPath.from(response.getBody().asString());
		
		System.out.println(">>>>>>>>>>>>>>>>jsonjsonjsonjson>>>>>>>>>>>>>>>>>>>>>>"+JsonPath.from(response.getBody().toString()));
	
		Arrays.asList(response); //api_token
		return response.getStatusCode();
	}

	public int getStatus(String uri) {
		Response response = restutils.getStatusAuth(uri);
//		  Arrays.asList(response.getHeaders());
		return response.getStatusCode();
	}

}
