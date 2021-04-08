
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.DashboardPage;
import Page.LoginPage;
import util.BrowserFactory;


public class LoginTest {

	WebDriver driver;

	
	//String userName = null;
	//String password = null;

	@Test
	
	@Parameters ({"username","password"}) // helping is to read from the regression.xml page
	public void validusershouldbeabletoLogin(String userName, String password) { // put the userName and Password from  line no. 28 and 29
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterusername(userName);
		loginPage.enterpassword(password);
		loginPage.logininbutton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashBoardHeader();

		BrowserFactory.tearDown();
	}
}
