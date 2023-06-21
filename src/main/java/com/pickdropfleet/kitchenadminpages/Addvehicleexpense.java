package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

public class Addvehicleexpense {

	WebDriver driver;
	
	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement DashboardIcon; // it selects dashsboars icon
	
	// it clicks Vehicle expense on dashboard
	By Vehicleexpense = By.xpath("//h6[text() = 'Vehicle Expense']");
	
	// create new expense
	By Addexpense = By.xpath("//a[text() = '+ Add Expense']");
	
	// it clicks Vehicle code
	By Vehiclecode = By.id("vehicle_Code");
	
	// it selects Vehiclecode value
	By VehicleCodevalue = By.xpath("//li[text() = 'Veh - 79']");
	
	// it selects Service type
	By Servicetype = By.id("service_Type");
	
	// it selects Service type value
	By ServiceTypevalue = By.xpath("//li[text() = 'TOLL COST']");
	
	// enter No of units
	By NoOfUnits = By.id("no_Units");
	
	// enter per unit cost
	By PerUnitcost = By.id("per_UnitCost");
	
	// enter total service cost
	By TotalServicecost = By.id("total_ServiceCost");
	
	// enter Date of expense
	By DateOfExpense = By.id("date_Expense");
	
	// enter expense details
	By Expensedetails = By.id("expense_Detail");
	
	// Save btn
	By Savebtn = By.xpath("//button[text() = 'Save']");
	
	// Ok btn
	By Okbtn = By.xpath("//button[text() = 'OK']");
	
	
	 public Addvehicleexpense(WebDriver driver) {
	       
		   this.driver = driver;
		   
			PageFactory.initElements(driver, this);
	   }
	
	
	public String addVehicleExpense(String noOfUnits, String perUnitCost, 
			
			String totalServiceCost, String expenseDetails, String dateOfExpense) throws InterruptedException, IOException {

	   Screenshot screenshot = new Screenshot(driver);
	   
	   Utils utils = new Utils(driver);
	   
		utils.clickVisibilityOfElementLocated(driver, Vehicleexpense, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Addexpense, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Vehiclecode, 10);
		
		utils.clickVisibilityOfElementLocated(driver, VehicleCodevalue, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Servicetype, 10);
	
		utils.clickVisibilityOfElementLocated(driver, ServiceTypevalue, 10);
		
		utils.sendKeysWithExplicitWait(driver, NoOfUnits, noOfUnits, 10);
		
		utils.sendKeysWithExplicitWait(driver, PerUnitcost, perUnitCost, 10);
		
		utils.sendKeysWithExplicitWait(driver, TotalServicecost, totalServiceCost, 10);
		
		utils.sendKeysWithExplicitWait(driver, DateOfExpense, dateOfExpense, 10);
		
		utils.sendKeysWithExplicitWait(driver, Expensedetails, expenseDetails, 10);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);
		
		utils.setImplicitWait(1000);
		
		return "New Vehicle Expense Added";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
