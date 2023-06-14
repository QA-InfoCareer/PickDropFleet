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

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

public class Dailyrequest {
	
	WebDriver driver;

	// it clicks dashboard icon
	@FindBy(xpath = "//button[@id = 'menu_slider")
	WebElement DashboardIcon;
	
	// it clicks daily request
	@FindBy(xpath = "//h6[text() = 'Daily Requests']")
	WebElement Dailyrequest;
	
	// enter delivery date
	@FindBy(xpath = "//input[@id = 'delivery_Date']")
	WebElement Deliverydate;
	
	// it clicks search btn
	@FindBy(xpath = "//button[text() = 'Search']")
	WebElement Search;
	
	// it clicks view btn
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='View'])[6]")
	WebElement View;
	
	// enter expected start date
	@FindBy(id = "expected_Start")
	WebElement ExpectedStartTime;
	
	// enter expected end date
	@FindBy(id = "end_Time")
	WebElement ExpectedEndTime;
	
	// it clicks Vehicle Name
	@FindBy(id = "vehicle_Name")
	WebElement Vehiclename;
	
	// it selects Vehicle name value
	@FindBy(xpath = "//li[text() = 'Veh - 63']")
	WebElement VehicleNamevalue;
	
	// it clicks delivered by
	@FindBy(xpath = "//div[@id = 'delivered_By']")
	WebElement Deliveredby;
	
	// it selects Delivered By value
	@FindBy(xpath = "//li[text() = 'Shahid']")
	WebElement DeliveredByvalue;
	
	// it clicks Save btn
	@FindBy(xpath = "//button[text() = 'Save']")
	WebElement Savebtn;
	
	// it clicks Ok btn
	@FindBy(xpath = "//button[text() = 'OK']")
	WebElement Okbtn;
	
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

	        // Print the formatted date
	        System.out.println("Current Date : " + todaysDate1);
		 
		Utils utils = new Utils(driver);
		
		Actions actions = new Actions(driver);
	
		actions.click(Dailyrequest).build().perform();
		
		utils.setImplicitWait(10);
		
		Deliverydate.sendKeys(todaysDate1);
		
		utils.setImplicitWait(10);
		
		actions.click(Search).build().perform();
		
		actions.click(View).build().perform();
		
		utils.setImplicitWait(10);
		
		ExpectedStartTime.sendKeys(startTime);
		
		utils.setImplicitWait(10);
		
		ExpectedEndTime.sendKeys(endTime);
		
		utils.setImplicitWait(10);
		
		actions.click(Vehiclename).build().perform();
		
		actions.click(VehicleNamevalue).build().perform();
		
		actions.click(Deliveredby).build().perform();
		
		actions.click(DeliveredByvalue).build().perform();
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		actions.click(Savebtn).build().perform();
		
		utils.setImplicitWait(1000);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		actions.click(Okbtn).build().perform();
		
		utils.setImplicitWait(1000);
		
		return "New Daily Request Added";
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
