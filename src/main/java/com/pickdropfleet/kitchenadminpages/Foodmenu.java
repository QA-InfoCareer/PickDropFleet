package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
import com.pickdropflett.ss.Screenshot;

public class Foodmenu {
	
	WebDriver driver;
	
	// clicks dashboard icon
	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement Dashboardicon;

	// clicks food menu on menu slider
	@FindBy(xpath = "//h6[normalize-space() = 'Food Menu']")
	WebElement Foodmenu;
	
	// create new food menu
	@FindBy(xpath = "//a[text() = '+ New Menu']")
	WebElement Newmenu;
	
	// enter menu date
	@FindBy(id = "m_Date")
	WebElement Menudate;
	
	// enter Menu breakfast
	@FindBy(id = "m_Breakfast")
	WebElement MenuBreakfast;
	
	// enter Menu Lunch
	@FindBy(id = "m_Lunch")
	WebElement MenuLunch;
	
	// save food menu
	@FindBy(xpath = "//button[text() = 'Save']")
	WebElement Savebtn;
	
	// Ok btn
	@FindBy(xpath = "//button[text() = 'OK']")
    WebElement Okbtn;
	
	@FindBy(xpath = "//button[@id='pagination-last-page']//*[name()='svg']")
	WebElement Pagination;
	
	@FindBy(xpath = "//select[@aria-label='Rows per page:']")
	WebElement rows;
    
    // View btn
	@FindBy(xpath = "//div[@id='row-23']//button[@type='button'][normalize-space()='View']")
    WebElement View;
	
    // Change btn
	@FindBy(xpath = "//div[@id='row-24']//button[contains(text(),'Change')]")
    WebElement Change;
    
    // It clicks + to increase breakfast small
	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[26]")
    WebElement Smallplus;
    
    // It clicks + to increase breakfast full
	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[36]")
    WebElement Largeplus;
    
    // Save btn
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-1j2ak2r'][normalize-space() = 'Save']")
    WebElement Savebtn1;
    
	public Foodmenu(WebDriver driver) {
        
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
    }
	
	  public String addFoodMenu(String menuDate, String menuBreakFast, String menuLunch) throws InterruptedException, IOException {
		 
		  Screenshot screenshot = new Screenshot(driver);

		  Utils utils = new Utils(driver);
		  
		  Actions actions = new Actions(driver);
		
		  actions.click(Foodmenu).build().perform();
		  
		  actions.click(Newmenu).build().perform();
		
		  Menudate.sendKeys(menuDate);
		  
		  utils.setImplicitWait(10);
		  
		  MenuBreakfast.sendKeys(menuBreakFast);
		  
		  utils.setImplicitWait(10);
		  
		  MenuLunch.sendKeys(menuLunch);
		  
		  utils.setImplicitWait(10);
		  
		  screenshot.takeScreenshot();
		  
		  utils.setImplicitWait(10);
		  
		  utils.clickElementWithWait(driver, Savebtn);
		  
		  utils.setImplicitWait(10);
		  
		  screenshot.takeScreenshot();
		  
		  utils.setImplicitWait(10);
		  
		  utils.clickElementWithWait(driver, Okbtn);
		  
		  utils.setImplicitWait(1000);
		  
		///////// Add Food is of what type /////////
		  
		  utils.clickElementWithWait(driver, rows);
		  
		Select select = new Select(rows);
		
		select.selectByVisibleText("ALL");
		 
		  utils.clickElementWithWait(driver, View);
		  
		  utils.clickElementWithWait(driver, rows);
		  
		Select select2 = new Select(rows);
		
		select2.selectByVisibleText("ALL");
		 
		  utils.clickElementWithWait(driver, Change);
		  
	List<WebElement> pathTag = driver.findElements(By.tagName("path"));
	
	  if(pathTag.size() > 0) {
		
		 Actions actions2 = new Actions(driver);
		 
		 actions2.moveToElement(Smallplus).click().build().perform();
		 
		 actions2.moveToElement(Largeplus).click().build().perform();
		  
	  }
		  
		  utils.clickElementWithWait(driver, Smallplus);
		  
		  utils.clickElementWithWait(driver, Largeplus);
		  
		  Thread.sleep(1000);
		  
		  utils.clickElementWithWait(driver, Savebtn1);
		  
		  Thread.sleep(1000);
		
		  return "New Food Menu Added";
	  }
	
	
	
	
	
	
	
	
}
