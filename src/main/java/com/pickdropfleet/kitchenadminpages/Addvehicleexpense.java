package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

public class Addvehicleexpense {

	WebDriver driver;
	
	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement DashboardIcon; // it selects dashsboars icon
	
	// it clicks Vehicle expense on dashboard
	@FindBy(xpath = "//h6[text() = 'Vehicle Expense']")
	WebElement Vehicleexpense;
	
	// create new expense
	@FindBy(xpath = "//a[text() = '+ Add Expense']")
	WebElement Addexpense;
	
	// it clicks Vehicle code
	@FindBy(id = "vehicle_Code")
	WebElement Vehiclecode;
	
	// it selects Vehiclecode value
	@FindBy(xpath = "//li[text() = 'Veh - 63']")
	WebElement VehicleCodevalue;
	
	// it selects Service type
	@FindBy(id = "service_Type")
	WebElement Servicetype;
	
	// it selects Service type value
	@FindBy(xpath = "//li[text() = 'TOLL COST']")
	WebElement ServiceTypevalue;
	
	// enter No of units
	@FindBy(id = "no_Units")
	WebElement NoOfUnits;
	
	// enter per unit cost
	@FindBy(id = "per_UnitCost")
	WebElement PerUnitcost;
	
	// enter total service cost
	@FindBy(id = "total_ServiceCost")
	WebElement TotalServicecost;
	
	// enter expense details
	@FindBy(id = "expense_Detail")
	WebElement Expensedetails;
	
	// enter Date of expense
	@FindBy(id = "date_Expense")
	WebElement DateOfExpense;
	
	// Save btn
	@FindBy(xpath = "//button[text() = 'Save']")
	WebElement Savebtn;
	
	// Ok btn
	@FindBy(xpath = "//button[text() = 'OK']")
	WebElement Okbtn;
	
	
	 public Addvehicleexpense(WebDriver driver) {
	       
		   this.driver = driver;
		   
			PageFactory.initElements(driver, this);
	   }
	
	
	public String addVehicleExpense(String noOfUnits, String perUnitCost, 
			
			String totalServiceCost, String expenseDetails, String dateOfExpense) throws InterruptedException, IOException {

	   Screenshot screenshot = new Screenshot(driver);
	   
	   Utils utils = new Utils(driver);
	   
		utils.clickElementWithWait(driver, Vehicleexpense);
		
		utils.clickElementWithWait(driver, Addexpense);
		
		utils.clickElementWithWait(driver, Vehiclecode);
		
		utils.clickElementWithWait(driver, VehicleCodevalue);
		
		utils.clickElementWithWait(driver, Servicetype);
	
		utils.clickElementWithWait(driver, ServiceTypevalue);
		
		utils.setImplicitWait(10);
		
		NoOfUnits.sendKeys(noOfUnits);
		
		utils.setImplicitWait(10);
		
		PerUnitcost.sendKeys(perUnitCost);
		
		utils.setImplicitWait(10);
		
		TotalServicecost.sendKeys(totalServiceCost);
		
		utils.setImplicitWait(10);
		
		Expensedetails.sendKeys(expenseDetails);
		
		utils.setImplicitWait(10);
		
		DateOfExpense.sendKeys(dateOfExpense);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickElementWithWait(driver, Savebtn);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickElementWithWait(driver, Okbtn);
		
		utils.setImplicitWait(1000);
		
		return "New Vehicle Expense Added";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
