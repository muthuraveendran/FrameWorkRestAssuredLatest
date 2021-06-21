package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.http.client.methods.RequestBuilder;

import helper.FileReader;


public class RestUtils {
	public String baseurl;
	Properties properties;
	FileReader fileReader = new FileReader();
	RequestSpecification requestSpec;
	
	public RestUtils(String data)  {
		try {	
			properties = fileReader.loadPrperties(Constants.devenv,Constants.folder);
			RequestSpecBuilder requestbuilder = new RequestSpecBuilder();
			requestbuilder.addParam(Constants.contentType,Constants.application);
			requestbuilder.setBaseUri(properties.getProperty(Constants.baseUrl));
			requestSpec = requestbuilder.build();
						
//			String env = System.getProperty("user");
////			System.out.println("envenvenvenvenvenvenvenvenvenvenvenvenv"+env);
////
//			if(env.equals("dev")) {
//			properties = fileReader.loadPrperties(Constants.devenv,Constants.folder);
//			}
//			if(env.equals("qa")) {
//				properties = fileReader.loadPrperties(Constants.qaenv,Constants.folder);
//			} 
//		
			
//			baseurl = properties.getProperty(Constants.baseUrl);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Response get(String uri) {
		String url = uri; //baseurl+
		System.out.println("urlurlurlurlurlurlurlurl"+url);	
		return given().relaxedHTTPSValidation().
		spec(requestSpec).		
		when()
//		.header(Constants.contentType,Constants.application)
		 .get(url);
	}
	
	public Response getAuthStatus(String uri) {
		String url = uri; //baseurl+   //baseurl+uri;
		System.out.println("urlurlurlurlurlurlurlurl"+url);
		return (Response) given().relaxedHTTPSValidation().auth().preemptive().basic(Constants.userName,Constants.password). when()
//		return given().relaxedHTTPSValidation().auth().digest("madhusudhanan@ideas2it.comd","Test1234"). when().
//		.header(Constants.contentType,Constants.application)
		.spec(requestSpec)
		 .post(url);
	}
	
	public Response getStatusAuth(String uri) { // , Map<String, String> param
		String url = uri; //String url = baseurl+uri;
		System.out.println("urlurlurlurlurlurlurlurl"+url);
		return given().relaxedHTTPSValidation().when()
		.spec(requestSpec)		
//		.header(Constants.contentType,Constants.application)
		.header(Constants.apitoken,Constants.apitokenValue)
		.header(Constants.location_uuid,Constants.location_uuidValue)
		.get(url);
	}

}
