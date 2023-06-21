package com.pickdropfleet.adminpages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.inject.spi.Element;
import com.pickdropfleet.utils.Utils;

public class Loginpage {

 private static WebDriver driver;
 
	
    @FindBy(how = How.ID, using = "email-login")
    private WebElement username; // enter username

	@FindBy(xpath = "//input[@id= '-password-login']")
	private WebElement password; // enter password
	
	@FindBy(xpath = "//button[@type= 'submit']")
	private WebElement submit;
	
	@FindBy(xpath = "(//div[@id='swal2-html-container'])[1]" )
	private WebElement Errormessage;
	
	By Okbtn = By.xpath("//button[text() = 'OK']");
	
	
	public Loginpage(WebDriver driver) {
       
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
    }
	
	public void loginAction(String userName, String pwd) throws InterruptedException  {
			
		 Utils utils = new Utils(driver);
			
			username.sendKeys(userName);
			
			password.sendKeys(pwd);
			
			utils.clickElementWithWait(driver, submit);
		
   }
	
	public boolean isErrorMessageDisplayed() {
        
		Utils utils = new Utils(driver);
		
		String xpath = "swal2-html-container";
		
	    return utils.findElementByXPath(xpath).isDisplayed();
        
    }

    public String getErrorMessage() {
       
    	Utils utils = new Utils(driver);
    	
    	String xpath = "swal2-html-container";
        
    	return utils.findElementByXPath(xpath).getText();
    }
    
    public void clearField() {
    	
    	username.clear();
    	
    	password.clear();
    }
    
    public String successLogin() {
    	
    	String url = driver.getCurrentUrl();
    	
    	 if(url.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/kitchen")) {
    		 
    		 System.out.println(url);
    	 }
		
    	 return url;
    }
	
}
