package SeleniumProj.AutomateFramework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmPage 
{
	WebDriver driver;
	public ConfirmPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(css="h1[class*='primary']")
WebElement successMsg;

public void confirmOrder()
{
	Assert.assertEquals(successMsg.getText(),"THANKYOU FOR THE ORDER.");
}
}


