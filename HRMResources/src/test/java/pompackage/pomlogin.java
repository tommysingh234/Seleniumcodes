package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.HRManagement;


public class pomlogin extends HRManagement {

	   //object repository
	
	@FindBy(name="username")    //regular driver.findElement(By.  is replaced here
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(id="terms")
	WebElement checkmark;
	
	
	//initiating page elements
	public pomlogin() {
		PageFactory.initElements(driver,this);
		
	}
	public void typeusername(String name) {
		username.sendKeys(name);
		
	}
	public void typeuserpassword(String pass) {
		password.sendKeys(pass);
		
	}
	
	public void check() {
		checkmark.click();
	}
	
	public void loginbtn() {
		loginbutton.click();
		
	}
	public String verify() {
		return driver.getTitle();
	}
		
	
}
