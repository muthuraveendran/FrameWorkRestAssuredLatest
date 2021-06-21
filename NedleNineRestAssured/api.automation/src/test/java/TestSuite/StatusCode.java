package TestSuite;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import helper.NeedleNineUtils;
import utils.Constants;
import utils.Data;

public class StatusCode {
	NeedleNineUtils needleNineUtils = new NeedleNineUtils();

	@Test
	public void loginPage() {
		int response = needleNineUtils.checkStatusCode(Constants.login);
		assertEquals(response, Data.Status200);
	};

	@Test
	public void AfterloginPage() {
		int response = needleNineUtils.checkAuthStatusCode(Constants.loginData);
		assertEquals(response, Data.Status200);
	};

	@Test
	public void coursePage() {
		int response = needleNineUtils.getStatus(Constants.course);
		assertEquals(response, Data.Status200);
	};

	@Test
	public void schedulePage() {
		int response = needleNineUtils.getStatus(Constants.schedule);
		assertEquals(response, Data.Status200);
	};

};
