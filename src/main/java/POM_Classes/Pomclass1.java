package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomclass1 {
// declaration
	
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")private WebElement uid;
	@FindBy(xpath="//input[@type='password']")private WebElement pass;
    @FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")private WebElement clickonlogin;
	@FindBy(xpath="//span[contains(text(),'enter valid')]")private WebElement getuiderrormsg;
    @FindBy(xpath="//span[contains(text(),'enter Pass')]")private WebElement getpasstext;
	@FindBy(xpath="//button[contains(text(),'OTP')]")private WebElement requestotp;

// initialization
    public Pomclass1(WebDriver driver){
    	PageFactory.initElements(driver, this); 	
    }
// Declaration
    public void username(String user) {
    	uid.sendKeys(user);
    }
    public void password(String password) {
    	pass.sendKeys(password);
    }
    public void loginbtn() {
    	clickonlogin.click();
    }
    public String getmsguid() {
    	String uidmsg = getuiderrormsg.getText();
    	return uidmsg;
    }
}
