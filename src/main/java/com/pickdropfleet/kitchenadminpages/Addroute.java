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
import com.pickdropflett.ss.Screenshot;

public class Addroute {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[@id = 'menu_slider")
	WebElement Dashboard;
	
	// clicks Route on dashboard
	@FindBy(xpath = "//h6[text() = 'Route']")
	WebElement Route;
	
	// create new route
	@FindBy(xpath = "//a[text() = '+ Add Route']")
	WebElement AddRoute;
	
	// enter route name
	@FindBy(id = "route_Name")
	WebElement RouteName;
	
	// enter route code
	@FindBy(id = "route_Code")
	WebElement RouteCode;
	
	// Save btn
	@FindBy(xpath = "//button[text() = 'Save']")
	WebElement Savebtn;
	
	// Ok btn
	@FindBy(xpath = "//button[text() ='OK']")
	WebElement Okbtn;
	
	// it clicks Last page arrow
	@FindBy(xpath = "//button[@id = 'pagination-last-page']")
	WebElement LastPagearrow;
	
	// it clicks view btn
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='View'])[9]")
	WebElement View;
	
	// it clicks map school btn
	@FindBy(xpath = "//a[normalize-space()='+ Map Schools']")
	WebElement Mapschool;
	
	// it clicks on check box
	@FindBy(xpath = "(//div[@role = 'row'] //span[@aria-label = 'select-row-6486d9b060ac2947efe24b4f'])")
	WebElement NumberOne;
	
	@FindBy(xpath = "(//select[@id='sequence'])[1]")
	WebElement Sequence;
	
	// it clicks add btn
	@FindBy(xpath = "//button[text() = 'Add']")
	WebElement Addbtn;
	
	
	public Addroute(WebDriver driver) {
	       
		   this.driver = driver;
		   
			PageFactory.initElements(driver, this);
	   }

	
	public String addRoute(String routeName, String routeCode) throws InterruptedException, IOException {
		
      try {
    	  
  		Screenshot screenshot = new Screenshot(driver);
	
  		Utils utils = new  Utils(driver);
  		
  		utils.clickElementWithWait(driver, Route);
  		
  		utils.clickElementWithWait(driver, AddRoute);
  	
  		utils.setImplicitWait(10);
  		
  		RouteName.sendKeys(routeName);
  		
  		utils.setImplicitWait(10);
  		
  		RouteCode.sendKeys(routeCode);
  		
  		screenshot.takeScreenshot();
  		
  		utils.setImplicitWait(10);
  		
  		utils.clickElementWithWait(driver, Savebtn);
  		
  		utils.setImplicitWait(10);
  		
  		screenshot.takeScreenshot();
  	      
  		utils.setImplicitWait(10);
  		
  		utils.clickElementWithWait(driver, Okbtn);
  		
  		utils.setImplicitWait(1000);
  		
//        utils.clickElementWithWait(driver, View);
//        
//        utils.clickElementWithWait(driver, Mapschool);
//        
//     List<WebElement> inputTag = driver.findElements(By.tagName("input"));
//     
//       if(inputTag.size() > 0) {
//    	  
//    	   for(WebElement element : inputTag) {
//    		   
//    		   String text = element.getText();
//    		   
//    		   System.out.println(text);
//    	   }
//       }
//        
//        utils.clickElementWithWait(driver, Sequence);
//        
//        Select select = new Select(Sequence);
//        
//        select.selectByVisibleText("1");
//        
//  		utils.clickElementWithWait(driver, Addbtn);
    	  
      } catch(Exception e) {
    	  
    	  System.out.println(e.getMessage());
      }
	
      return "New Route Added";
		
		
	}
	
}
