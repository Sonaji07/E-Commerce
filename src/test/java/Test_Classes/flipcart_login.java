package Test_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Class.utility;
import POM_Classes.Pomclass1;
import POM_Classes.pom2mobile;
import Path_Configuration.configuration;

public class flipcart_login {
	WebDriver driver;
	Pomclass1 login;
	utility util;
	String TCid;
	pom2mobile mb;
	@BeforeClass
	public void launchbrowser() {
		Reporter.log("launch browser" ,true);
		utility util=new utility();
		driver=util.initializebrowser();
        login =new Pomclass1(driver);
        mb=new pom2mobile(driver);
		}
	@BeforeMethod
	public void maxwindow()  {
	driver.manage().window().maximize();
}
	@Test (priority =0)
	public void tc01() throws EncryptedDocumentException, IOException, InterruptedException {
		Reporter.log("---LOGIN FLIPCART---",true);
		Thread.sleep(2000);
		login.username(utility.extdata(1, 0));
		login.password(utility.extdata(1, 1));
		login.loginbtn();
		Thread.sleep(4000);

	}
	@Test (priority =1)
	public void buymobile() throws InterruptedException {
		Thread.sleep(6000);
		mb.searchmb(" OnePlus 10R 5G (Sierra Black, 128 GB) (8 GB RAM)  ");
		Thread.sleep(2000);
		mb.clickonsearch();
		Thread.sleep(2000);
		mb.clickonmobile();
		
		System.out.println(mb.gettxt());
		
	}
	@Test (priority =2)
	public void addcart() throws InterruptedException {
		Thread.sleep(2000);
		mb.pincode("431601");
		Thread.sleep(2000);
		mb.addcart();
		Thread.sleep(2000);

	}
	
	
	
	
	
	
	@AfterMethod 
	public void refreshwindow(ITestResult xyz) throws IOException {
		if(xyz.getStatus()==xyz.FAILURE) {
		utility.screenshot(driver, TCid);
		}
		
	   // driver.navigate().refresh();

	}
	
	/*@AfterClass 
	public void closebrowser() throws InterruptedException {
		Thread.sleep(4000);

		driver.quit();
	}*/
	

}
