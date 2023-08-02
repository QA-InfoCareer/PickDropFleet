package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshots;

public class Addroute {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@id = 'menu_slider")
	WebElement Dashboard;
	
	// clicks Route on dashboard
	By Route = By.xpath("//h6[text() = 'Route']");
	
	// create new route
	By AddRoute = By.xpath("//a[text() = '+ Add Route']");
	
	// enter route name
	By RouteName = By.id("route_Name");
	
	// enter route code
	By RouteCode = By.id("route_Code");
	
	// Save btn
	By Savebtn = By.xpath("//button[text() = 'Save']");
	
	// Ok btn
	By Okbtn = By.xpath("//button[text() ='OK']");
	
	// it clicks Last page arrow
	@FindBy(xpath = "//select[@aria-label = 'Rows per page:']")
	WebElement rows;
	
	// it clicks view btn
	By View = By.xpath("(//button[text() = ' View '])[32]"); // it is your created route
	
	// it clicks map school btn
	By Mapschool = By.xpath("//a[normalize-space()='+ Map Schools']");
	
	// it clicks on check box
	By checkSchool = By.xpath("(//div[@class='sc-hLseeU sc-gLDzan efVpVk gNRcrj rdt_TableCell'])[19]"); // it is your created school
	
	//it selects sequential order
	@FindBy(xpath = "(//select[@id='sequence'])[19]")
	WebElement Sequence; // it is your created school same sequence
	
	// it clicks add btn
	By Addbtn = By.xpath("//button[text() = 'Add']");
	
	
	public Addroute(WebDriver driver) {
	       
		   this.driver = driver;
		   
			PageFactory.initElements(driver, this);
	   }

	
	public String addRoute(String routeName, String routeCode) throws InterruptedException, IOException {
		
      try {
    	  
  		Screenshots screenshot = new Screenshots(driver);
	
  		Utils utils = new  Utils(driver);
  		
  		utils.clickVisibilityOfElementLocated(driver, Route, 10);
  		
  		utils.clickVisibilityOfElementLocated(driver, AddRoute, 10);
  
  		utils.sendKeysWithExplicitWait(driver, RouteName, routeName, 10);
  	
  		utils.sendKeysWithExplicitWait(driver, RouteCode, routeCode, 10);
  		
  		screenshot.takeScreenshot();
  		
  		utils.setImplicitWait(10);
  		
  		utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
  		
  		utils.setImplicitWait(10);
  		
  		screenshot.takeScreenshot();
  	      
  		utils.setImplicitWait(10);
  		
  		utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);
  		
  		utils.setImplicitWait(1000);
  		
  		///////////// Map School /////////////
  		
  		utils.clickElementWithWait(driver, rows);
  		
  		Select select = new Select(rows);
  		
  		select.selectByVisibleText("ALL");
  		
  		utils.clickVisibilityOfElementLocated(driver, View, 10);
  		
  		utils.clickVisibilityOfElementLocated(driver, Mapschool, 10);
  		
  		utils.clickElementWithWait(driver, rows);
  		
  		Select select2 = new Select(rows);
  		
  		select2.selectByVisibleText("ALL");
  		
  		utils.clickVisibilityOfElementLocated(driver, checkSchool, 10);
  		
  		utils.clickElementWithWait(driver, Sequence);
  		
  		Select select3 = new Select(Sequence);
  		
  		select3.selectByVisibleText("1");
  		
  		utils.clickVisibilityOfElementLocated(driver, Addbtn, 10);
    	  
      } catch(Exception e) {
    	  
    	 e.getStackTrace();
    	 
    	 System.out.println(e.getMessage());
      }
	
      return "New Route Added";
		
		
	}
	
}
