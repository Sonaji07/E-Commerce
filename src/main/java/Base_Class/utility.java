package Base_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import POM_Classes.Pomclass1;
import Path_Configuration.configuration;


public class utility {
	WebDriver driver;
	Pomclass1 login ;
	public WebDriver initializebrowser() {
		
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", configuration.chromedriver);
		 driver=new ChromeDriver();
		 login = new Pomclass1(driver);
		driver.get(configuration.flipcarturl);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static String extdata(int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream(configuration.extrnldata);
	   Sheet sht = WorkbookFactory.create(file).getSheet("Sheet5");
	   String data = sht.getRow(row).getCell(col).getStringCellValue();
	   return data;
	
	}
	
	public static void screenshot(WebDriver driver, String TCid) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(configuration.Screenshot+TCid+".flipcartpng");
		FileHandler.copy(source, dest);
	}
	
	

}
