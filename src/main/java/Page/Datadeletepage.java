
package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Datadeletepage  {

	WebDriver driver;
	String enterName;

	public Datadeletepage(WebDriver driver) {
		this.driver = driver;
	}

	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]
	// tbody/tr[i]/td[3] - Coverting no. into int i
	// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]")
	WebElement deletepopalert;

	public void verifyEnteredName() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 20; i++) {
			// @findBy(how=How.XPATH, using ="before_xpath" +i+"after_xpath").getText();
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			//Assert.assertEquals(name, enterName, "Entered name doesnot exist");
			
							
			if (name.contains(enterName)) { 
				System.out.println("entered name exist");
				driver.findElement(By.xpath("//tbody/tr" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
			
			}

		}
	}

	public void deleteokbutton() {
		deletepopalert.click();
	}
}