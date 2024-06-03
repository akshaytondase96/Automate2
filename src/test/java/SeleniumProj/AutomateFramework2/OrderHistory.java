package SeleniumProj.AutomateFramework2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderHistory extends BaseTest
{
  @Test(priority=1)
  public void viewOrders()
  {
	  loginpage.loginApplication(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
	  orders.verifyOrders(prop.getProperty("product"));
  }
  @Test(priority=2)
	public void ErrorValidation2()
	{
		loginpage.loginApplication(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(loginpage.errorMessage(), "Login Successfullyuu");
	}
}
