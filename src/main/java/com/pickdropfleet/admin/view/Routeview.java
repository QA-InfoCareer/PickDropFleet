package com.pickdropfleet.admin.view;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pickdropfleet.utils.Utils;

public class Routeview {
	
	WebDriver driver;

	// it clicks Route on dashboard
	@FindBy(xpath = "//h6[text() = 'Route']")
	WebElement Route;
	
	// it clicks Choose Kitchen
	@FindBy(xpath = "//input[@placeholder = 'Select kitchen Name']")
    WebElement Choosekitchen;
	
    // it selects Choose Kitchen value
	@FindBy(xpath = "//li[text() = 'Crescent Kitchen']")
	WebElement ChooseKitchenvalue;
		 	
	// it clicks Search btn
	@FindBy(xpath = "//button[text() = 'Search']")
	WebElement Searchbtn;
		 	
	// it clicks view btn and show existing user
	@FindBy(xpath = "(//button[text() = ' View '])[1][1]")
	WebElement View;
		 	
	// it clicks back btn
	@FindBy(xpath = "//button[text() = 'Back']")
	WebElement Backbtn;
	
	
	public Routeview(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void viewRoute() throws InterruptedException {
		
		Utils utils = new Utils(driver);
		
		utils.clickElementWithWait(driver, Route);
 		
 		utils.clickElementWithWait(driver, Choosekitchen);
 		
 		utils.clickElementWithWait(driver, ChooseKitchenvalue);
 		
 		utils.clickElementWithWait(driver, Searchbtn);
 		
 		utils.clickElementWithWait(driver, View);
 		
 		utils.setImplicitWait(2000);
 		
 		utils.clickElementWithWait(driver, Backbtn);
 		
 		utils.setImplicitWait(700);
		
	}
	
	
	
	
	
	
	
	
}
