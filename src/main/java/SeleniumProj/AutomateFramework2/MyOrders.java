package SeleniumProj.AutomateFramework2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyOrders 
{
   WebDriver driver;
	public MyOrders(WebDriver driver)
	{
     this.driver=driver;
     PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//tr/td[2]")
List<WebElement> orderslist;
@FindBy(css="button[routerlink*='myorders']")
WebElement myOrder;
//
public void verifyOrders(String productName)
{
	myOrder.click();
	for(WebElement o:orderslist)
	{
	  if(o.getText().equalsIgnoreCase(productName))
	  {
		  Assert.fail();
		  System.out.println("Order Verified");
		  break;
	  }
	}
}
}
