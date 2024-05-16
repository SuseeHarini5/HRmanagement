package testLayer;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
//import dev.failsafe.internal.util.Assert;
import pompackage.PomLogin;
//import testdata.ExcelSheet;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	
	PomLogin Log; 
	public LoginTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshots("Login");
		Log  = new PomLogin();
		
	}
	
	  @DataProvider 
	  public Object[][]Details(){ 
		 
		 Object result[][]=ExcelSheet.readdata("Sheet1"); 
		 return result; 
		 }
	  
	  @Test(dataProvider="Details")
	  public void Login(String name, String password) {
		  Log.typeusername(name);
		  Log.typepassword(password);
		  Log.clickloginbutton();
	  }
	 
		 
	
			/*
			 * @Test public void Login() { Log.typeusername(prop.getProperty("username"));
			 * Log.typepassword(prop.getProperty("password")); Log.clickloginbutton(); }
			 */
	
	/*
	 * @Test public void title() { Log.typeusername(prop.getProperty("username"));
	 * Log.typepassword(prop.getProperty("password")); Log.clickloginbutton();
	 * String actual = Log.verify(); Assert.assertEquals(actual,
	 * "Logged In Successfully | Practice Test Automation");
	 * 
	 * }
	 */
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
