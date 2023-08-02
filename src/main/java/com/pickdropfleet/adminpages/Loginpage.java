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
		
			username.sendKeys(userName);
			
			password.sendKeys(pwd);	
		
   }
	
   public void submitBtn() {
	   
	   Utils utils = new Utils(driver);
	   
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

    
    public boolean loginValidation() {
    	
   	try {
   		
   		boolean isLoggedIn = driver.findElements(By.xpath("//h5[text()='Dashboard']")).size() > 0;
   	    
        if(isLoggedIn) {
       	 
       	 System.out.println("User is in home page");
        
        } else if(!isLoggedIn) {
        
       	 Utils utils = new Utils(driver);
        	
        String xpath = "swal2-html-container";
        
        String text = utils.findElementByXPath(xpath).getText();
        
        System.out.println("The Error Message is : " +text);
        
        driver.findElement(By.xpath("//button[text() = 'OK']")).click();
        
        WebElement username = driver.findElement(By.id("email-login"));
        
        username.clear();
        
        WebElement passKey = driver.findElement(By.xpath("//input[@id= '-password-login']"));
        
        passKey.clear();
        	
        utils.delay(700);
        
      }
   	
   		
   	} catch (Exception e) {
   		
   		e.getStackTrace();
   		
   		System.out.println(e);
   	}    	
    	
     return true;
    	
  }
    
    
	
}
