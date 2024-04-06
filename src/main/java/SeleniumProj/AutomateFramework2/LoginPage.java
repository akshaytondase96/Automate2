package SeleniumProj.AutomateFramework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Operations
{
  WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement userpass;
	@FindBy(id="login")
	WebElement signUp;
	@FindBy(id="toast-container")
	WebElement loginMsg;
	
	public void loginApplication(String url,String username,String password)
	{
		driver.get(url);
		useremail.sendKeys(username);
		userpass.sendKeys(password);
		signUp.click();
	}
	public String errorMessage()
	{
		waitForVisibilityOfElement(loginMsg);
		return loginMsg.getText();
	}
}	
