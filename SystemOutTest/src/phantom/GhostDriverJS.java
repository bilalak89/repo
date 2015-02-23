package phantom;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GhostDriverJS {
	WebDriver driver;
	
	DesiredCapabilities caps = new DesiredCapabilities();

public static void main(String []args){
	
	//fortimanager
	GhostDriverJS gs1 = new GhostDriverJS("https://10.2.3.40");
	//Fortigate
	GhostDriverJS gs2 = new GhostDriverJS("https://10.2.3.31");

	//fortianalyzer
	GhostDriverJS gs3= new GhostDriverJS("https://10.2.3.41/login.htm");
}

	public  GhostDriverJS (String baseUrl) {
		// TODO Auto-generated method stub

		
		caps.setJavascriptEnabled(true); // not really needed: JS enabled by
											// default
		caps.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"D://phantomjs-2.0.0-windows//bin//phantomjs.exe");
		caps.setCapability("takesScreenshot", true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
//            "--web-security=false",
//            "--ssl-protocol=any",
            "--ignore-ssl-errors=yes"
        });

		driver = new FirefoxDriver(caps);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);   
		long iStart = System.currentTimeMillis(); // start timing
		

		
		WebElement elementUsername = driver.findElement(By.name("username"));
		WebElement elementPassword = driver.findElement(By.name("secretkey"));
		//WebElement elementOpenTab = driver.findElement(By.name("body"));
		elementUsername.sendKeys("kbsl");
		elementPassword.sendKeys("asdf1234");
		
		elementPassword.submit();
		elementUsername.submit();
		
				JavascriptExecutor js=null;
if (driver instanceof JavascriptExecutor) {
    js = (JavascriptExecutor)driver;
}
js.executeScript("try_login();");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("D:\\phantomjs-2.0.0-windows\\sample.jpeg"),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		System.out.println("Single Page Time:" + (System.currentTimeMillis() - iStart)); // end timing
		//driver.close();
	}

	

}
