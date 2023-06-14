package com.pickdropfleet.adminpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Importpage {

	WebDriver driver;
	
	By Dashboard = By.xpath("//span[@aria-label='menu-unfold']//*[name()='svg']");
	
	// it clicks Import on dashboard
	By Import = By.xpath("//h6[text() = 'Import']"); 
	
	// it clicks Select excel
	By Selectexcel = By.xpath("//em[normalize-space()='Select Excel']");
	
	// it clicks Kitchen value
	By Kitchen = By.xpath("//li[text() = 'Kitchen']");
	
	// it clicks and download Sample user excel
	By Downlodadsample = By.cssSelector("button[class='sampleexcel'] div span");
	
	// it clicks and import that sample excel file
	//By Importsample = By.xpath("//section //label[@class = 'label2']");
	
	// it clicks Save btn
	By Savebtn = By.xpath("//button[normalize-space()='Save']");
	
	public Importpage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	public void importPage() {
		
		driver.findElement(Dashboard).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Import).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Selectexcel).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Kitchen).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Downlodadsample).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		WebElement downloadSample = driver.findElement(By.xpath("//section //label[@class = 'label2']"));
		
		Actions actions = new Actions(driver);
		
		actions.sendKeys(downloadSample, "C:\\Users\\DELL\\Downloads\\kitchen.xlsx");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.findElement(Savebtn).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
	}
	
	
	
	
	
}
