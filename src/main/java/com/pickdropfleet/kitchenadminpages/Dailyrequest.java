package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

import jnr.ffi.Struct.BYTE;

public class Dailyrequest {
	
	WebDriver driver;

	// it clicks dashboard icon
	@FindBy(xpath = "//button[@id = 'menu_slider")
	WebElement DashboardIcon;
	
	// it clicks daily request
	By Dailyrequest = By.xpath("(//h6)[7]");  
	
	// enter delivery date
	By Deliverydate = By.xpath("//input[@id = 'delivery_Date']");
	
	// it clicks search btn
	By Search = By.xpath("//button[text() = 'Search']");
	
	// it clicks view btn
	By View = By.xpath("(//button[@type='button'][normalize-space()='View'])[13]");
	
	// enter expected start date
	By ExpectedStartTime = By.id("expected_Start");
	
	// enter expected end date
	By ExpectedEndTime = By.id("end_Time");
	
	// it clicks Vehicle Name
	By Vehiclename = By.id("vehicle_Name");
	
	// it selects Vehicle name value
	By VehicleNamevalue = By.xpath("//li[text() = 'Veh - 80]");
	
	// it clicks delivered by
	By Deliveredby = By.id("delivered_By");
	
	// it selects Delivered By value
	By DeliveredByvalue = By.xpath("//li[text() = 'Rajinikanth']");
	
	// it clicks Save btn
	By Savebtn = By.xpath("//button[text() = 'Save']");
	
	// it clicks Ok btn
	By Okbtn = By.xpath("//button[text() = 'OK']");
	
	public Dailyrequest(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	 public String addDailyRequest(String todaysDate, String startTime, String endTime) throws InterruptedException, IOException {
	
		 Screenshot screenshot = new Screenshot(driver);
		 
		 LocalDate currentDate = LocalDate.now();

	        // Create a formatter
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        // Format the current date using the formatter
	        String todaysDate1 = currentDate.format(formatter);

	        // Print the formatted current date
	        System.out.println("Current Date : " + todaysDate1);
		 
		Utils utils = new Utils(driver);
		
		utils.clickVisibilityOfElementLocated(driver, Dailyrequest, 10);
		
	    utils.sendKeysWithExplicitWait(driver, Deliverydate, todaysDate1, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Search, 10);
		
		utils.clickVisibilityOfElementLocated(driver, View, 10);
		
		utils.sendKeysWithExplicitWait(driver, ExpectedStartTime, startTime, 20);
		
		utils.sendKeysWithExplicitWait(driver, ExpectedEndTime, endTime, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Vehiclename, 10);
		
		utils.clickVisibilityOfElementLocated(driver, VehicleNamevalue, 20);
		
		utils.clickVisibilityOfElementLocated(driver, Deliveredby, 10);
		
		utils.clickVisibilityOfElementLocated(driver, DeliveredByvalue, 10);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
		
		utils.setImplicitWait(1000);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);
		
		utils.setImplicitWait(1000);
		
		return "New Daily Request Added";
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
