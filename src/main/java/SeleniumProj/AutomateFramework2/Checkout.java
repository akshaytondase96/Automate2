package SeleniumProj.AutomateFramework2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkout extends Operations
{
	WebDriver driver;
	public Checkout(WebDriver driver) 
	{
		super(driver);
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//button[text()='Checkout']")
WebElement checkot;
@FindBy(css="input[placeholder*='Country']")
WebElement countryField;
@FindBy(css="section[class*='ng-star']")
WebElement countryList;
@FindBy(xpath="//span[text()=' India']")
WebElement selectCountry;
@FindBy(css="a[class*='ng-star']")
WebElement placeOrder;
public void checkout(String counrtyName)
{
	
	checkot.click();	
	countryField.sendKeys(counrtyName);
	waitForVisibilityOfElement1(countryList);
	selectCountry.click();
	Actions a = new Actions(driver);
	a.moveToElement(placeOrder).click(placeOrder).click().build().perform();
}
}

