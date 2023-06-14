package com.pickdropfleet.adminpages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Loginpage {

 private WebDriver driver;
	
    @FindBy(how = How.ID, using = "email-login")
    private WebElement username; // enter username

	@FindBy(xpath = "//input[@id= '-password-login']")
	private WebElement password; // enter password
	
	@FindBy(xpath = "//button[@type= 'submit']")
	private WebElement submit;
	
	
	public Loginpage(WebDriver driver) {
       
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
    }
	
	public void loginAction(String userName, String pwd) throws InterruptedException  {
			
			username.sendKeys(userName);
			password.sendKeys(pwd);
			
		}
	
	public void clickLoginBtn() {
		
		submit.click();
	}
	

   }
