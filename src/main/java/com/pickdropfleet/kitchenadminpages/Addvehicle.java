package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

public class Addvehicle {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement dashboardIcon; // it selects dashsboars icon

	@FindBy(xpath = "//h6[text() = 'Vehicle']")
	WebElement Vehicle; // it clicks vehicle on dashboard
	
	@FindBy(xpath = "//a[text() = '+ Add Vehicle']")
	WebElement Addvehicle; // it clicks Vehicle btn 
	
	@FindBy(id = "vehicle_Make")
	WebElement Vehiclemake; // it clicks vehicke make 
	
	@FindBy(xpath = "//li[text() = 'Ashok Leyland']")
	WebElement Vehiclemakevalue; // it selects vehicle make value
	
	@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
	WebElement Vehiclemodel; // it clicks Vehiclemodel
	
	@FindBy(xpath = "//li[text() = 'Ashok Leyland BADA DOST']")
	WebElement Vehiclemodelvalue; // it selects Vehiclemodel value
	
	@FindBy(id = "vehicle_makeYear")
	WebElement VehicleMakeyear; // enter vehicle year
	
	@FindBy(id = "vehicle_Type")
	WebElement Vehicletype; // enter vehicletype
	
	@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
	WebElement VehicleFueltype; // it clicks Vehicle Fuel type
	
	@FindBy(xpath = "//li[text() = 'Diesel']")
	WebElement VehicleFuetypevalue; // it selects Vehicle Fuel type value
	
	@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > em:nth-child(1)")
	WebElement VehicleOwnership;  // it clicks VehicleOwnership
	
	@FindBy(xpath = "//li[text() = 'Hired']")
	WebElement VehicleOwnershipvalue; // it selects VehicleOwnership value
	
	@FindBy(xpath = "//input[@id = 'engine_Size']")
	WebElement Enginesize; // enter engine size
	
	@FindBy(xpath = "//input[@id = 'drive_Train']")
	WebElement Drivetrain; // enter drive train
	 
	@FindBy(xpath = "//input[@id = 'fuel_Capacity']")
	WebElement Fuelcapacity; // enter fuel capacity
	
	@FindBy(id = "Vehicle_number")
	WebElement Vehiclenumber; // enter vehicle number
	
	@FindBy(xpath = "//input[@id= 'registration_Year']")
	WebElement VehicleRegistrationyear; // enter vehicle registration year
	
	@FindBy(xpath = "//input[@id = 'joined_On']")
	WebElement JoinedAkshayapatra; // enter joined akshayapatra date joine don
	
	@FindBy(xpath = "//input[@name = 'vehiclecode']")
	WebElement Vehiclecode; // enter vehicle code
	
	@FindBy(xpath = "//div[@id='road_Side']")
	WebElement RoadsideAssistance;  // it clicks RoadsideAssistance
	
	@FindBy(xpath = "//li[text() = 'Yes']")
	WebElement RoadsideAssistancevalue; // it selects RoadsideAssistance value
	
	@FindBy(xpath = "//input[@name = 'Vehiclecolor']")
	WebElement Vehiclecolor; // enter Vehiclecolor 
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement Savebtn;
	
	@FindBy(xpath = "//button[text() = 'OK']")
	WebElement Okbtn;
	
	public Addvehicle(WebDriver driver) {
        
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
    }
   
	
	
	public String addVehicle(String vehicleType, String vehicleMakeYear, String engineSize,
			
			String driveTrain, String fuelCapacity, String vehicleNumber, String vehicleRegistrationYear,
			
			String joinedAkshayapatra, String vehicleCode, String vehicleColor) throws InterruptedException, IOException {
		
		Screenshot screenshot = new Screenshot(driver);
		
		Utils utils = new Utils(driver);

		utils.clickElementWithWait(driver, Vehicle);
		
		utils.clickElementWithWait(driver, Addvehicle);
		
		utils.clickElementWithWait(driver, Vehiclemake);
		
	    utils.clickElementWithWait(driver, Vehiclemakevalue);
		
		utils.clickElementWithWait(driver, Vehiclemodel);
		
	    utils.clickElementWithWait(driver, Vehiclemodelvalue);
		
		VehicleMakeyear.sendKeys(vehicleMakeYear);
		
		utils.setImplicitWait(10);
		
		Vehicletype.sendKeys(vehicleType);
		
		utils.setImplicitWait(10);

		utils.clickElementWithWait(driver, VehicleFueltype);
		
		utils.clickElementWithWait(driver, VehicleFuetypevalue);
		
		utils.clickElementWithWait(driver, VehicleOwnership);
		
		utils.clickElementWithWait(driver, VehicleOwnershipvalue);
		
		utils.setImplicitWait(10);
		
		Enginesize.sendKeys(engineSize);
		
		utils.setImplicitWait(10);
		
		Drivetrain.sendKeys(driveTrain);
		
		utils.setImplicitWait(10);
		
		Fuelcapacity.sendKeys(fuelCapacity);
		
		utils.setImplicitWait(10);
		
		Vehiclenumber.sendKeys(vehicleNumber);
		
		utils.setImplicitWait(10);
		
		VehicleRegistrationyear.sendKeys(vehicleRegistrationYear);
		
		utils.setImplicitWait(10);
		
		JoinedAkshayapatra.sendKeys(joinedAkshayapatra);
		
		utils.setImplicitWait(10);
		
		Vehiclecode.sendKeys(vehicleCode);
		
		utils.setImplicitWait(10);
		
		utils.clickElementWithWait(driver, RoadsideAssistance);
		
		utils.clickElementWithWait(driver, RoadsideAssistancevalue);
		
		utils.setImplicitWait(10);
		
		Vehiclecolor.sendKeys(vehicleColor);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickElementWithWait(driver, Savebtn);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickElementWithWait(driver, Okbtn);
		
		utils.setImplicitWait(1000);
		
		return "New Vehicle Added";
		
	}
	
	
	
}
