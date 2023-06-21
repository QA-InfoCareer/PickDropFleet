package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

public class Addvehicle {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement dashboardIcon; // it selects dashsboars icon

	By Vehicle = By.xpath("//h6[text() = 'Vehicle']"); // it clicks vehicle on dashboard
	
	By Addvehicle = By.xpath("//a[text() = '+ Add Vehicle']"); // it clicks Vehicle btn 
	
	By Vehiclemake = By.id("vehicle_Make"); // it clicks vehicke make 
	
	By Vehiclemakevalue = By.xpath("//li[text() = 'Ashok Leyland']"); // it selects vehicle make value
	
	By Vehiclemodel = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"); // it clicks Vehiclemodel
	
	By Vehiclemodelvalue = By.xpath("//li[text() = 'Ashok Leyland BADA DOST']"); // it selects Vehiclemodel value
	
	By VehicleMakeyear = By.id("vehicle_makeYear"); // enter vehicle year
	
	By Vehicletype = By.id("vehicle_Type"); // enter vehicletype
	
	By VehicleFueltype = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"); // it clicks Vehicle Fuel type
	
	By VehicleFuetypevalue = By.xpath("//li[text() = 'Diesel']"); // it selects Vehicle Fuel type value
	
	By VehicleOwnership = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > em:nth-child(1)");  // it clicks VehicleOwnership
	
	By VehicleOwnershipvalue = By.xpath("//li[text() = 'Hired']"); // it selects VehicleOwnership value
	
	By Enginesize = By.xpath("//input[@id = 'engine_Size']"); // enter engine size
	
	By Drivetrain = By.xpath("//input[@id = 'drive_Train']"); // enter drive train
	
	By Fuelcapacity = By.xpath("//input[@id = 'fuel_Capacity']"); // enter fuel capacity
	
	By Vehiclenumber = By.id("Vehicle_number"); // enter vehicle number
	
	By VehicleRegistrationyear = By.xpath("//input[@id= 'registration_Year']"); // enter vehicle registration year
	
	By JoinedAkshayapatra = By.xpath("//input[@id = 'joined_On']"); // enter joined akshayapatra date joine don
	
	By Vehiclecode = By.xpath("//input[@name = 'vehiclecode']"); // enter vehicle code
	
	By RoadsideAssistance = By.xpath("//div[@id='road_Side']");  // it clicks RoadsideAssistance
	
	By RoadsideAssistancevalue = By.xpath("//li[text() = 'Yes']"); // it selects RoadsideAssistance value
	
	By Vehiclecolor = By.xpath("//input[@name = 'Vehiclecolor']"); // enter Vehiclecolor 
	
	By Savebtn = By.xpath("//button[contains(text(),'Save')]");

	By Okbtn = By.xpath("//button[text() = 'OK']");
	
	public Addvehicle(WebDriver driver) {
        
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
    }
   
	
	
	public String addVehicle(String vehicleType, String vehicleMakeYear, String engineSize,
			
			String driveTrain, String fuelCapacity, String vehicleNumber, String vehicleRegistrationYear,
			
			String joinedAkshayapatra, String vehicleCode, String vehicleColor) throws InterruptedException, IOException {
		
		Screenshot screenshot = new Screenshot(driver);
		
		Utils utils = new Utils(driver);

		utils.clickVisibilityOfElementLocated(driver, Vehicle, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Addvehicle, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Vehiclemake, 10);
		
	 List<WebElement> vehicleMakeValue = driver.findElements(By.tagName("li"));
	 
	  if(vehicleMakeValue.size() > 0) {
		  
		  vehicleMakeValue.get(3).click();  // it selects vehicle make value
	  }
		
		utils.clickVisibilityOfElementLocated(driver, Vehiclemodel, 10);
		
	  List<WebElement> vehicleModelValue = driver.findElements(By.tagName("li"));
	  
	    if(vehicleModelValue.size() > 0) {
	    	
	    	vehicleModelValue.get(1).click();
	    }
		
		utils.sendKeysWithExplicitWait(driver, VehicleMakeyear, vehicleMakeYear, 10);
		
		utils.sendKeysWithExplicitWait(driver, Vehicletype, vehicleType, 10);

		utils.clickVisibilityOfElementLocated(driver, VehicleFueltype, 10);
		
		utils.clickVisibilityOfElementLocated(driver, VehicleFuetypevalue, 10);
		
		utils.clickVisibilityOfElementLocated(driver, VehicleOwnership, 10);
		
		utils.clickVisibilityOfElementLocated(driver, VehicleOwnershipvalue, 10);
		
		utils.sendKeysWithExplicitWait(driver, Enginesize, engineSize, 10);
		
		utils.sendKeysWithExplicitWait(driver, Drivetrain, driveTrain, 10);
		
		utils.sendKeysWithExplicitWait(driver, Fuelcapacity, fuelCapacity, 10);
		
		utils.sendKeysWithExplicitWait(driver, Vehiclenumber, vehicleNumber, 10);
		
		utils.sendKeysWithExplicitWait(driver, VehicleRegistrationyear, vehicleRegistrationYear, 10);
		
		utils.sendKeysWithExplicitWait(driver, JoinedAkshayapatra, joinedAkshayapatra, 10);
		
		utils.sendKeysWithExplicitWait(driver, Vehiclecode, vehicleCode, 10);
		
		utils.clickVisibilityOfElementLocated(driver, RoadsideAssistance, 10);
		
		utils.clickVisibilityOfElementLocated(driver, RoadsideAssistancevalue, 10);
		
		utils.sendKeysWithExplicitWait(driver, Vehiclecolor, vehicleColor, 10);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
		
		utils.setImplicitWait(10);
		
		screenshot.takeScreenshot();
		
		utils.setImplicitWait(10);
		
		utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);
		
		utils.setImplicitWait(1000);
		
		return "New Vehicle Added";
		
	}
	
	
	
}
