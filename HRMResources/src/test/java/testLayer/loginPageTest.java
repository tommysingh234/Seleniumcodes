package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.HRManagement;
import pompackage.pomlogin;

public class loginPageTest extends HRManagement{
	pomlogin log;
	
	public loginPageTest() {
		
		super();		
	}
	
	@BeforeMethod
	public void initialsetup() {
		
		initiation();
		log=new pomlogin();
	}
	
//	@Test
//	public void Title() {
//		String actual=log.verify();
//		Assert.assertEquals(actual, "OrangeHRM");
//		System.out.print("hurray");
//		
//	}	
	
	@Test
	public void login() {
		log.typeusername(prop.getProperty("username"));
		log.typeuserpassword(prop.getProperty("password"));
		//log.check();
		log.loginbtn();
		
	}
//	
//	@AfterMethod
//	public void close()
//    {
//		driver.close();
//	}
//	
	
	
}
