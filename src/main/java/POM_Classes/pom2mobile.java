package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pom2mobile {
	// declare
	@FindBy(xpath="//div[contains(text(),'10R')][1]")private WebElement mobile;
	
	@FindBy(xpath="//input[contains(@title,'Search')]")private WebElement searchmob;
	@FindBy(xpath="//button[@type='submit']")private WebElement clickonsearch;
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")private WebElement addtocart;
	@FindBy(xpath="//span[@class='B_NuCI']")private WebElement clickonmob;
	@FindBy(xpath="//input[@id='pincodeInputId']")private WebElement enterpin;
	
  public pom2mobile(WebDriver driver){
	PageFactory.initElements(driver, this);
	
  }
   public void clickonmobile() {
	mobile.click();
 }
   public void searchmb(String str) {
		searchmob.sendKeys(str);
	}
   public void clickonsearch() {
		clickonsearch.click();
	}
   public void clickonmbl() {
		clickonmob.click();
	}
   public void addcart() {
		addtocart.click();
	}
   public void pincode(String pin) {
		enterpin.sendKeys(pin);
	}
 
   public String gettxt() {
	   String txt=clickonmob.getText();
		return txt;
	}

  
   
}
