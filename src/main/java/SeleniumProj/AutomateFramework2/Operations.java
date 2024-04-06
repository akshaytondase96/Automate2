package SeleniumProj.AutomateFramework2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Operations 
{
	
	WebDriver driver;
	WebDriverWait wait;
	public Operations(WebDriver driver) 
	{
		 this.driver=driver;
	}
	@FindBy(id="toast-container")
	WebElement loginMsg;
	@FindBy(css="section[class*='ng-star']")
	WebElement countryList;
	@FindBy(css="button[routerlink*='cart']")
	WebElement addToCart;
	public void waitForVisibilityOfElement(WebElement ele)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(loginMsg));
	}
	public void waitForVisibilityOfElement1(WebElement elem)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(countryList));
	}
	public void goToCart()
	{
		addToCart.click();
	}
}
