package com.pickdropfleet.adminpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
	
	private WebDriver driver;

	@FindBy(xpath = "//span[@class='anticon anticon-user']//*[name()='svg']")
	public WebElement Clickuserinfo;
	
	@FindBy(xpath = "//span[text() = 'Logout']")
	public WebElement Logoutbtn;
	
	public Logoutpage(WebDriver driver) {
	       
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
    }
	
	
	public void clickUserInfo() {
		
		Actions actions = new Actions(driver);
		
		actions.click(Clickuserinfo).build().perform();
		
		try {
		
			Thread.sleep(1000);
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		Logoutbtn.click();
	}
	
	
	
}
