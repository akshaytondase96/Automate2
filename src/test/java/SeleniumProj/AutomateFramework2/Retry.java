package SeleniumProj.AutomateFramework2;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	int maxCount=1,count=0;
	@Override
	public boolean retry(ITestResult result) 
	{
	  
	  if(count<maxCount)
	  {
		  count++;
		  return true;
	  }
		return false;
	}

}
