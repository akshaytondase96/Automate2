package SeleniumProj.AutomateFramework2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public static LoginPage loginpage;
	public static Operations op;
	public static AddToCart adc;
	public static CartPage cartpage;
	public static Checkout check;
	public static ConfirmPage confirm;
	public static MyOrders orders;
	public static Properties prop;
	
	@BeforeMethod(alwaysRun=true)
	public void initializeDriver() throws IOException 
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumProj\\AutomateFramework2\\info.properties");
	     prop=new Properties();
	    prop.load(fis); 
	    String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome"))
	    {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize(); 
	    }
	    else {
	    	WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize(); 
	    }
	  
		loginpage = new LoginPage(driver);
		op = new Operations(driver);
		adc = new AddToCart(driver);
		cartpage = new CartPage(driver);
		check = new Checkout(driver);
		confirm = new ConfirmPage(driver);
		orders=new MyOrders(driver);
	}
	  public String getScreenshot(WebDriver driver) throws IOException
	  {
		  SimpleDateFormat df=new SimpleDateFormat("dd-mm-yyyy h-m-s");
		  Date date=new Date();
		  TakesScreenshot screen=(TakesScreenshot)driver;
		  File file=screen.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(file, new File("C:\\Users\\hp\\eclipse-workspace\\AutomateFramework2\\"+"_"+df.format(date)+".png"));
		  return "C:\\Users\\hp\\eclipse-workspace\\AutomateFramework2\\"+"_"+df.format(date)+".png";
	  }
	  public ExtentReports getExtentObject()
	  {
		  String extentPath="C:\\Users\\hp\\eclipse-workspace\\AutomateFramework2\\Reports\\index.html";
		    ExtentSparkReporter  report=new ExtentSparkReporter(extentPath);
		    report.config().setReportName("Automation results");
		    report.config().setDocumentTitle("Test Results");
		    ExtentReports extent=new ExtentReports();
		    extent.attachReporter(report);
		    extent.setSystemInfo("Tester", "Akshay");
		    return extent;
	  }
		/*
		 * @AfterMethod public void close() { driver.close(); }
		 */
	  
	 
	 }
