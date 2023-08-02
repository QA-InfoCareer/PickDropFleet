package com.pickdropfleet.adminpages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pickdropfleet.utils.Utils;

public class Importpage {

	WebDriver driver;
	
	@FindBy(xpath = "//span[@aria-label='menu-unfold']//*[name()='svg']")
	WebElement Dashboard;
	
	// it clicks Import on dashboard
	@FindBy(xpath = "//h6[text() = 'Import']")
	WebElement Import;
	
	// it clicks Select excel
	@FindBy(xpath = "//em[normalize-space()='Select Excel']")
	WebElement Selectexcel;
	
	// it clicks Kitchen value
	@FindBy(xpath = "//li[text() = 'Kitchen']")
	WebElement Kitchen;
	
	// it clicks and download Sample user excel
	@FindBy(xpath = "//span[normalize-space()='Sample Kitchen Excel.xlsx']")
	WebElement Downlodadsample;
	
	// it clicks and import that sample excel file
	@FindBy(xpath = "//section//input[contains(@accept,'.xlsx, .xls,.csv')]")
	WebElement Importsample;
	
	// it clicks Save btn
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Savebtn;
	
	public Importpage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	public String importPage() {
		
		try {
			
			Utils utils = new Utils(driver);
			
			utils.clickElementWithWait(driver, Import);
			
			utils.clickElementWithWait(driver, Selectexcel);
			
			utils.clickElementWithWait(driver, Kitchen);

			//utils.clickElementWithWait(driver, Downlodadsample);
			
		List<WebElement> tagName = driver.findElements(By.tagName("input"));
		
		   if(tagName.size() > 0) {
			   
			   tagName.get(0).sendKeys("C:\\Users\\DELL\\Downloads\\kitchen.xlsx");
		   }
			
			utils.clickElementWithWait(driver, Savebtn);
			
		} catch(Exception e) {
			
			e.getMessage();
			
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}
	
	
	
	
	
}
