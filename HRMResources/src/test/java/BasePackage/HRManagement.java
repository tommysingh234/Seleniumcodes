package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utility.TimeUtils;

public class HRManagement {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	
	//step1 --> calling constructor,loading file
	
	public HRManagement() {
		try {
			
		FileInputStream file=new FileInputStream("C:\\Users\\RAJA BABU\\Desktop\\eclipse_Practice\\HRMResources\\src\\test\\java\\environmentvaribles\\Config.properties");
	    prop.load(file);
	}
		catch(FileNotFoundException e){
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//step 2  initiating driver,maximize screen  using pageLoadTimeout to set page loading time	
	public static void initiation() { 
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			driver=new ChromeDriver();	
		}
		else if(browsername.equals("edge")){
			driver=new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.TimeforPageLoading));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.TimeforPageLoading));
		driver.get(prop.getProperty("url"));
	   
		
	}
			
	}

		
		
		
		
		
		
		
		
		
		
