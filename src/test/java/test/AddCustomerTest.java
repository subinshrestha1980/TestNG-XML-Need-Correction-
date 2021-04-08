
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Page.AddCustomerPage;
import Page.BasePage;
import Page.Contactsvalidation;
import Page.DashboardPage;
import Page.Datadeletepage;
import Page.ListcontactpageValidation;
import Page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest extends BasePage {

	WebDriver driver;
	String enterName;
	
	
	/*String userName = null;
	String password = null;
	String fullName = null;
	String companyName = null;
	String emailField = null;
	String phoneField = null;
	String addressField = null;
	String cityField = null;
	String countryField = null;
	String stateField = null;
	String zipField = null;
	String currencyField = null;
	// String GROUP_FIELD = null;
	String PASSWORD_FIELD = null;
	String CONFIRM_PASSWORD_FIELD = null;
	*/
	
	@Test
	@Parameters ({"username","password","FullName","CompanyName","Email","Phone","Address","City", "Country", "State", "Zip", "Currency", "Password", "ConfirmPaassword"})
		
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String companyName, String emailField, String phoneField, String addressField, String cityField, String countryField, String stateField, String zipField, String currencyField, String PASSWORD_FIELD, String CONFIRM_PASSWORD_FIELD) throws InterruptedException {
		enterName = fullName + randomNumGenerator();
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterusername(userName); // userName is a variable to read it from our excel.
		loginpage.enterpassword(password);
		loginpage.logininbutton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashBoardHeader();

		AddCustomerPage addcustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);

		addcustomerPage.clickOncustomerButton();
		addcustomerPage.clickOnAddCustomerButton();

		addcustomerPage.Full_NameField(fullName + randomNumGenerator());
		addcustomerPage.CompanyField(companyName);
		addcustomerPage.Email_Field(emailField);
		addcustomerPage.PHONE_FIELD(phoneField);
		addcustomerPage.ADDRESS_FIELD(addressField);
		addcustomerPage.CITY_FIELD(cityField);
		addcustomerPage.COUNTRY_FIELD(countryField);
		addcustomerPage.STATE_FIELD(stateField);
		addcustomerPage.ZIP_FIELD(zipField);
		addcustomerPage.CURRENCY_FIELD(currencyField); //
		//addcustomerPage.GROUP_FIELD(GROUP_FIELD);
		addcustomerPage.PASSWORD_FIELD(PASSWORD_FIELD);
		addcustomerPage.CONFIRM_PASSWORD_FIELD(CONFIRM_PASSWORD_FIELD);
		addcustomerPage.SIGNIN_FIELD(); // Contactsvalidation.Summary_Field();
		Contactsvalidation contactsvalidation1 = PageFactory.initElements(driver, Contactsvalidation.class);
		contactsvalidation1.Summary_Field();
		contactsvalidation1.LIST_CUSTOMER();

		ListcontactpageValidation customerpagevalid = PageFactory.initElements(driver, ListcontactpageValidation.class);
		customerpagevalid.newcustomerpage();
		
		Datadeletepage Datadeletepage1 = PageFactory.initElements(driver, Datadeletepage.class);
		Datadeletepage1.verifyEnteredName();
	}
}
// addcustomerPage.LIST_CUSTOMER(); Contactsvalidation1.LIST_CUSTOMER(); } }
