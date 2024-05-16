package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	
	@FindBy(id="username") WebElement Username;
	@FindBy(id="password") WebElement Password;
	@FindBy(id="submit") WebElement LoginButton;
	
	public PomLogin(){
		PageFactory.initElements(driver,this); 
	}
	
	public void typeusername(String username) {

		Username.sendKeys(username); 

	}
	
	public void typepassword(String password) {

		Password.sendKeys(password);

	}
	
	public void clickloginbutton() {

		Password.click();

	}
	
	public String verify() {
		return driver.getTitle();
	}
}
