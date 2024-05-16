package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;

import utility.TimeUtils;

public class BaseHRMClass {
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	public BaseHRMClass() {
		
		try {
			FileInputStream file = new 
				FileInputStream("/Users/suseeharini/eclipse-workspace/HRmanagement/src/test/java/environmentvariables/Config.properties");
			prop.load(file);
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException a) {
			a.printStackTrace();
		}
	}
	
	public static void initiate() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"/Users/suseeharini/Downloads/chromedriver-mac-arm64/chromedriver");
			driver = new ChromeDriver();
		}
		
		else if (browsername.equals("Firefox")){
			System.setProperty("webdriver.chrome.driver", 
					"/Users/suseeharini/Downloads/chromedriver-mac-arm64/chromedriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void screenshots(String Filename)  {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
	    File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
	    File DestFile=new File("/Users/suseeharini/eclipse-workspace/HRmanagement/src/test/java/screenshot/screenshots"+Filename+".jpg");
	    try {
			FileUtils.copyFile(SourceFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
}
