package com.pickdropfleet.adminpages;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.bouncycastle.util.test.TestResult;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

import ru.yandex.qatools.ashot.AShot;

public class Kitchenpage {
	
    private WebDriver driver;
	
  @FindBy(xpath = "//button[@id = 'menu_slider']")
  WebElement dashboardIcon;  // click for dashboard
 
  @FindBy(xpath = "(//h6[text() = 'Kitchen'])[1][1]")
  WebElement clickKitchen;  // click kitchen on dashboard
  
  @FindBy(xpath = "//a[normalize-space()='+ Add kitchen']")
  WebElement createKitchen;  // create kitchen
  
  @FindBy(xpath = "//input[@id = 'kitchen_Code']")
  WebElement Kitchencode;  // enter kitchen code
  
  @FindBy(id = "kitchen_Name")
  WebElement Kitchenname;  // enter kitchen name
  
  @FindBy(id = "kitchen_Type")
  WebElement kitchenType; //  select kitchen type
  
  @FindBy(xpath = "//li[@data-value = '1']")
  WebElement kitchenTypeValue; // it selects kitchen value
  
  @FindBy(id = "vessel_Type")
  WebElement vesselType;  // select vessel type
  
  @FindBy(xpath = "//li[@data-value = '1']")
  WebElement vesselValue;  // it selects vessel value
  
  @FindBy(xpath = "//input[@id = 'no_Of_Vessels']")
  WebElement NoOfVessel; // enter no of vessels
   
  @FindBy(id = "meal_Type")
  WebElement mealType; //  select meal type
  
  @FindBy(xpath = "//li[@data-value = '1']")
  WebElement mealValue; //  it selects meal value
  
  @FindBy(xpath = "//input[@id = 'address']")
  WebElement Address; // enter address
  
  @FindBy(id = "landmark")
  WebElement Landmark;
  
  @FindBy(xpath = "//input[@id = 'city']")
  WebElement City; // enter city
  
  @FindBy(xpath = "//input[@id = 'state']")
  WebElement State; // enter state
  
  @FindBy(xpath = "//input[@id = 'country']")
  WebElement Country; // enter country
  
  @FindBy(xpath = "//input[@id = 'postal_Code']")
  WebElement Postalcode; // enter pincode
  
  @FindBy(xpath = "//span[normalize-space()='Medium']")
  WebElement medium; // radio btn 
  
  @FindBy(xpath = "//span[normalize-space()='Small']")
  WebElement small; // radio btn
  
  @FindBy(xpath = "//input[@id = 'no_Of_Small_Vessels']")
  WebElement Uparrowsmall;  // enter value 2
  
  @FindBy(xpath = "//input[@id = 'no_Of_Medium_Vessels']")
  WebElement Uparrowmedium; // enter value 2
  
  @FindBy(xpath = "//button[text()='Save'] ")
  WebElement SaveBtn;
  
  @FindBy(xpath = "//button[text() = 'OK']")
  WebElement Okbtn;
  
  @FindBy(xpath = "//button[normalize-space() = 'Back']")
  WebElement backbtn;
  
  public Kitchenpage(WebDriver driver) {
	  
	  this.driver = driver;
      
		PageFactory.initElements(driver, this);
  }
  
      public String addKitchenByAdmin(String kitchenCode, String kitchenName, String noOfVessel,
    		  
    		  String address, String landMark, String city, String state, String country,
    		  
    		  String postalCode, String upArrowMedium, String upArrowSmall) throws InterruptedException, IOException {
	    
    	  Screenshot screenshot = new Screenshot(driver);
    	  
    	  Utils utils = new Utils(driver);
    	 
    	 utils.clickElementWithWait(driver, clickKitchen);
    	 
    	 utils.clickElementWithWait(driver, createKitchen);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Kitchencode.sendKeys(kitchenCode);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Kitchenname.sendKeys(kitchenName);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 utils.clickElementWithWait(driver, kitchenType);
    	 
    	 utils.clickElementWithWait(driver, kitchenTypeValue);
    	
    	 utils.clickElementWithWait(driver, vesselType);
    	 
    	 utils.clickElementWithWait(driver, vesselValue);
    	 
    	 NoOfVessel.sendKeys(noOfVessel);
    	 
    	 utils.setImplicitWait(10);

    	 utils.clickElementWithWait(driver, mealType);
    	 
    	 utils.clickElementWithWait(driver, mealValue);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Address.sendKeys(address);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Landmark.sendKeys(landMark);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 City.sendKeys(city);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 State.sendKeys(state);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Country.sendKeys(country);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Postalcode.sendKeys(postalCode);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 utils.clickElementWithWait(driver, small);
    	 
    	 utils.clickElementWithWait(driver, medium);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Uparrowsmall.sendKeys(upArrowSmall);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 Uparrowmedium.sendKeys(upArrowMedium);
    	 
    	 utils.setImplicitWait(10);
    	 
    	 screenshot.takeScreenshot();
    	 
    	 utils.setImplicitWait(10);
    	 
    	 utils.clickElementWithWait(driver, SaveBtn);
    	 
    	 screenshot.takeScreenshot();
    
    	  utils.setImplicitWait(10);
    	 
          return "Success";
      }
      
        
      public boolean isErrorMessageDisplayed() {
	        
			Utils utils = new Utils(driver);
			
			String xpath = "swal2-html-container";
			
		    return utils.findElementByXPath(xpath).isDisplayed();
	        
	    }
	    
	    public String getErrorMessage() {
	        
	    	Utils utils = new Utils(driver);
	    	
	    	String xpath = "swal2-html-container";
	        
	    	return utils.findElementByXPath(xpath).getText();
	    }
	    
	    public void refreshPage() {
	        
			   driver.navigate().refresh();
		    }
      
  }
