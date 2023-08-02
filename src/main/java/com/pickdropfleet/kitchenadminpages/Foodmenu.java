package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Foodmenu {
	
	WebDriver driver;
	
	// clicks dashboard icon
	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement Dashboardicon;

	// clicks food menu on menu slider
	By Foodmenu = By.xpath("//h6[normalize-space() = 'Food Menu']");
	
	// create new food menu
	By Newmenu = By.xpath("//a[text() = '+ New Menu']");
	
	// enter menu date
	By Menudate = By.id("m_Date");
	
	// enter Menu breakfast
	By MenuBreakfast = By.id("m_Breakfast");
	
	// enter Menu Lunch
	By MenuLunch = By.id("m_Lunch");
	
	// save food menu
	By Savebtn = By.xpath("//button[text() = 'Save']");
	
	// Ok btn
    By Okbtn = By.xpath("//button[text() = 'OK']");
	
	By Pagination = By.xpath("//button[@id='pagination-last-page']//*[name()='svg']");
	
	@FindBy(xpath = "//select[@aria-label='Rows per page:']")
	WebElement rows;
    
    // View btn
    By View = By.xpath("(//button[text() = ' View '])[58]"); // it is your created food menu
	
    // Change btn
    By Change = By.xpath("(//button[text()='Change'])[43]"); // it is your created school name
    
    // It clicks + to increase breakfast small
    By Smallplus = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium incQtyCls css-vubbuv'])[1]");
    
    // It clicks + to increase breakfast full
    By Largeplus = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium incQtyCls css-vubbuv'])[3]");
    
    // Save btn
    By Savebtn1 = By.xpath("(//button[text() = 'Save'])[2]");
    
	public Foodmenu(WebDriver driver) {
        
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
    }
	
	  public String addFoodMenu(String menuDate, String menuBreakFast, String menuLunch) throws InterruptedException, IOException {
		 
		  Screenshots screenshot = new Screenshots(driver);

		  Utils utils = new Utils(driver);
		
		 utils.clickVisibilityOfElementLocated(driver, Foodmenu, 10);
		  
		 utils.clickVisibilityOfElementLocated(driver, Newmenu, 10);
			
		 utils.sendKeysWithExplicitWait(driver, Menudate, menuDate, 10);
		  
		 utils.sendKeysWithExplicitWait(driver, MenuBreakfast, menuBreakFast, 10);
		
		 utils.sendKeysWithExplicitWait(driver, MenuLunch, menuLunch, 10);
		  
		  screenshot.takeScreenshot();
		  
		  utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
		  
		  utils.setImplicitWait(10);
		  
		  screenshot.takeScreenshot();
		  
		  utils.setImplicitWait(10);
		  
		  utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);
		  
		  utils.setImplicitWait(1000);
		 
		  
		///////// Add Food is of what type /////////
		  
      utils.clickElementWithWait(driver, rows);
       
       Select select = new Select(rows);
       
       select.selectByVisibleText("ALL");
       
       utils.clickVisibilityOfElementLocated(driver, View, 10);
       
      utils.clickElementWithWait(driver, rows);
      
       Select select2 = new Select(rows);
       
       select2.selectByVisibleText("ALL");
       
        utils.clickVisibilityOfElementLocated(driver, Change, 10);
        
        utils.clickVisibilityOfElementLocated(driver, Smallplus, 10);
        
        utils.clickVisibilityOfElementLocated(driver, Largeplus, 10);
        
        utils.clickVisibilityOfElementLocated(driver, Savebtn1, 10);
       
		  return "New Food Menu Added";
	  }
	
	
	
	
	
	
	
	
}
