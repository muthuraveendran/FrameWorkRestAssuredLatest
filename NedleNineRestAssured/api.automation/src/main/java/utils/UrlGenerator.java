package utils;

public class UrlGenerator {
	public String login ="/#/login";
	
	public UrlGenerator(String baseUrl) {
		//To Auto Genrate
		login = baseUrl+login;
	}

}
