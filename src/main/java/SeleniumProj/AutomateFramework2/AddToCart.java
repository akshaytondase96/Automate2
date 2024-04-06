package SeleniumProj.AutomateFramework2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart 
{
   WebDriver driver;
	public AddToCart(WebDriver driver) 
	{
      this.driver=driver;
      PageFactory.initElements(driver,this);
	}

@FindBy(xpath="//h5/b")
List<WebElement> products;
 @FindBy(id="toast-container")
 WebElement addedMsg;

 public void addItemsToCart(String prodName)
 {
	 for (int i = 0; i < products.size(); i++) 
	 {
	if (products.get(i).getText().equalsIgnoreCase(prodName))
	{
				driver.findElements(By.xpath("//div[@class='card-body']//button[2]")).get(i).click();
	}
 }
}
}

//wait.until(ExpectedConditions.visibilityOf(addedMsg));