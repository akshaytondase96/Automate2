package SeleniumProj.AutomateFramework2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {

	@Test(priority=1)
	public void submitorder() throws InterruptedException
	{ 
    	loginpage.loginApplication(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		adc.addItemsToCart(prop.getProperty("product"));
		cartpage.verifyItems(prop.getProperty("product"));
		check.checkout(prop.getProperty("countryName"));
		confirm.confirmOrder();
	}
	@Test(priority=2,groups="Error")
	public void ErrorValidation()
	{
		loginpage.loginApplication(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(loginpage.errorMessage(), "Login Successfully.");
	}
}
