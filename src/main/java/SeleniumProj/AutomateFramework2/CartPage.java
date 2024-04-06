package SeleniumProj.AutomateFramework2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Operations
{
  WebDriver driver;
	public CartPage(WebDriver driver) 
	{
		super(driver);
	   this.driver=driver;	 
	   PageFactory.initElements(driver,this);
	}
@FindBy(css="button[routerlink*='/cart']")
WebElement addToCart;
@FindBy(css=".cartSection h3")
List<WebElement> items;

public void verifyItems(String prodName)
{
	goToCart();
	for (WebElement i : items) {

		if (i.getText().equalsIgnoreCase(prodName)) {
			System.out.println("Products are verified");
		}
	}	
}
}

