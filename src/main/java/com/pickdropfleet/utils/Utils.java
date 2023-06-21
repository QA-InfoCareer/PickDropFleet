package com.pickdropfleet.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.spi.Element;

public class Utils {

	private static WebDriver driver;
	
	private static final int TIMEOUT_SECONDS = 10;
	
	private static WebDriverWait wait;
	
	public Utils(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void navigateToURL(String url) {
      
    	driver.get(url);
    }

    public static WebElement findElement(By locator) {
       
    	return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        
    	return driver.findElements(locator);
    }

    public static void sendKeys(By locator, String text) {
       
    	findElement(locator).sendKeys(text);
    }

    public static void clear(By locator) {
        
    	findElement(locator).clear();
    }

    public static String getText(By locator) {
        
    	return findElement(locator).getText();
    }

    public static boolean isDisplayed(By locator) {
        
    	return findElement(locator).isDisplayed();
    }

    public static boolean isEnabled(By locator) {
       
    	return findElement(locator).isEnabled();
    }

    public static boolean isSelected(By locator) {
       
    	return findElement(locator).isSelected();
    }

    public static void waitForElementVisible(By locator, Duration timeoutInSeconds) {
        
    	WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementClickable(By locator, Duration timeoutInSeconds) {
       
    	WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        
    	wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
       
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
    	return wait.until(ExpectedConditions.visibilityOf(element));
    	
    }

    public static void switchToFrame(By locator) {
        
    	driver.switchTo().frame(findElement(locator));
    }

    public static void switchToDefaultContent() {
       
    	driver.switchTo().defaultContent();
    }
	
	public WebElement waitForVisibility1(WebDriver driver2, WebElement element2) {
	       
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
    	return wait.until(ExpectedConditions.visibilityOf(element2));
    	
    }
	
	 public WebElement sendKeysWithWait(WebElement locator, String text) {
	        
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	     
		element.sendKeys(text);
		
		return null;
	 }
	 
	 public void setImplicitWait(int seconds) {
	       
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
	   
	 }

	public void clickElement(WebDriver driver, By locator) {
       
		WebElement element = driver.findElement(locator);
        
		element.click();
	}
	
	public void okClickElementWithWait(WebDriver driver, WebElement element) {
	       
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
		wait.until(ExpectedConditions.elementToBeClickable(element));
        
		element.click();
	}
	
	public void clickElementWithWait1(WebDriver driver, WebElement element) {
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
		wait.until(ExpectedConditions.visibilityOf(element));
        
		element.click();
    }
	
	public void clickVisibilityOfElementLocated(WebDriver driver, By locator, int i) {
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
		
		WebElement element2 = driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		element2.click();
	}
	
   public void clickElementWithWait(WebDriver driver, WebElement element) {
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
		wait.until(ExpectedConditions.elementToBeClickable(element));
        
		element.click();
    }
	
	
	
   public void presenceOfElementLocated(WebDriver driver, By element) {
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
        
	    ((WebElement) element).click();
    }
	
	
	
	 public void clickRandomElementByTagName(WebDriver driver, String tagName) {
	       
		 List<WebElement> elements = driver.findElements(By.tagName(tagName));

	        if (elements.size() > 0) {

	        	List<String> values = new ArrayList<>();

	            for (WebElement element : elements) {

	            	String text = element.getText();
	                
	            	System.out.println(text);
	             
	            	values.add(text);
	            }

	            Random random = new Random();

	            int randomIndex = random.nextInt(values.size());
	            
	            System.out.println(randomIndex);

	            WebElement webElement = elements.get(randomIndex);

	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            
	            jsExecutor.executeScript("arguments[0].click();", webElement);
	        }
	    }

	 public void clickElementIfPresent(WebDriver driver, String valueToMatch) {
	        List<WebElement> elements = driver.findElements(By.tagName("li"));

	        for (WebElement element : elements) {
	            String elementText = element.getText();
	            System.out.println(elementText);

	            if (elementText.equalsIgnoreCase(valueToMatch)) {
	                element.click();
	                break;
	            }
	        }
	    }
	 
	 
	 public static void selectGender(WebDriver driver, String gender) {
	       
		 String genderLocator = getGenderLocator(gender);
	     
		 if (genderLocator != null) {
	     
			 WebElement genderElement = driver.findElement(By.xpath(genderLocator));
	         
			 genderElement.click();
	        
		 } else {
	           
			 System.out.println("Invalid gender value: " + gender);
	     
		 }
	    }

	 private static String getGenderLocator(String gender) {
	       
		 String Gender = gender.toString();
	     
		 switch (Gender) {
	            
		 case "Male":
	     
			 return "//li[text() = 'Male']"; 
	         
		 case "Female":
	     
			 return "//li[text() = 'Female']"; 
	            
		 default:
	     
			 return "Gender not takes place";
	        
		    }
	    }

	 public void sendKeysWithExplicitWait(WebDriver driver, By locator, String text, int timeoutInSeconds) {
	       
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	     
		 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	     
		 element.sendKeys(text);
	    
	 }
	 
	 public WebElement findElementByXPath(String xpath) {
	       
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
		 
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(xpath)));
	    
	 }

	
	
}
