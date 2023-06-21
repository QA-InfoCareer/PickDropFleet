package com.pickdropfleet.adminpages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.StaticInitializerCoercer;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.icu.impl.Utility;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;
import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Randomemail;
import com.pickdropflett.ss.Screenshot;

public class Userpage {
	
	private WebDriver driver;
	
    // it clicks on dashboard icon
	@FindBy(xpath = "//span[@aria-label='menu-unfold']//*[name()='svg']")
   WebElement dashboardIcon;
   
   // It selects user in dashboard
   By clickUser = By.xpath("//h6[text() = 'User']");
   
   // It selects user
   By createUser = By.xpath("//a[text()='+ Create User']");
   
   // it upload image
   By imageUpload = By.xpath("//input[@type='file']");
   
    // It selects kitchen name
   By kitchenName = By.xpath("//em[normalize-space()='Select Kitchen Name']");
   
    // It selects kitchen value
   By kitchenNameValue = By.xpath("//li[text() = 'Dominos Kitchens']");
   
    // enter firstname
   By firstname = By.xpath("//input[@id = 'user_FirstName']");
   
   // enter lastname
   By lastname = By.xpath("//input[@id = 'user_LastName']");
   
   // enter usercode
   By usercode = By.xpath("//input[@id = 'user_Code']");
   
    // It selects role
   By role = By.xpath("//div[normalize-space()='Kitchen Admin']");
   
    // It selects role value
   By roleValue = By.xpath("//li[normalize-space()='Kitchen Admin']");
   
    // enter mobile number
   By mobileno = By.xpath("//input[@id = 'user_Mobile']");
   
   // enter dob
   By dob = By.xpath("//input[@type = 'date']");
   
   // It clicks gender
   By clickGender = By.xpath("//div[@id = 'user_Gender']");
   
   // It selects gender value
   By selectGender = By.xpath("//li[text() = 'Male']");
   
   // It clicks blood group
   By clickBloodGroup = By.xpath("//em[text() = 'Select Blood Group']");
		   
   // It selects blood group value
   By bloodGroupValue = By.xpath("//li[text() = 'O+VE']");
   
   // It clicks marital status
   By clickMaritalStatus = By.xpath("//div[@id = 'user_Maritalstatus']");
   
   // It selects marital status value
   By maritalStatusValue = By.xpath("//li[text()='Unmarried']");
   
   // enter email
   By email = By.xpath("//input[@id = 'user_Email']");
   
   // enter aadhar number
   By AadharNumber = By.xpath("//input[@id = 'user_Aadhar']");
   
   // enter pan number
   By PanNumber = By.xpath("//input[@id = 'user_Pan']");
   
   // enter education
   By Education = By.xpath("//input[@id = 'user_Education']");
   
   // enter address
   By Address = By.xpath("//input[@id = 'user_Address']");
   
   // enter country
   By Country = By.cssSelector("div:nth-child(18) div:nth-child(1) div:nth-child(2) input:nth-child(1)");
   
   // enter state
   By State = By.cssSelector("div:nth-child(17) div:nth-child(1) div:nth-child(2) input:nth-child(1)");
   
   // enter city
   By City = By.xpath("//input[@id = 'user_City']");
   
   // enter postal code
   By Postalcode = By.xpath("//input[@id = 'user_Postal']");
   
    // It clicks Save btn
   By Savebtn = By.xpath("//button[text() = 'Save']");
   
    // It clicks Ok btn
   By Okbtn = By.xpath("//button[text() = 'OK']");
   
   //////// Validation Locators /////////
   public WebElement getEmailErrorMessage() {
       return driver.findElement(By.xpath("//div[text() = 'Please Enter a Valid Email Id']"));
   }

   public WebElement getAadhaarErrorMessage() {
       return driver.findElement(By.xpath("//div[text() = 'Please Enter Valid Aadhar Number']"));
   }

   public WebElement getPanErrorMessage() {
       return driver.findElement(By.xpath("//div[text() = 'Please Enter a valid Pan Number']"));
   }
   
   public Userpage(WebDriver driver) {
       
	   this.driver = driver;
	   
		PageFactory.initElements(driver, this);
   }

	 public String addUserByAdmin(String firstName, String lastName, String userCode,
			 
			 String mobileNumber, String Dob, String emailId, String aadharNumber, String panNumber,
			 
			 String education, String address, String country, String state, String city,
			 
			 String postalCode) throws InterruptedException, IOException { 
		 
	Utils utils = new Utils(driver);
		 
		 /////// Generate random Email id ///////
	    String randomEmail = generateRandomEmail();
	     
    //////////aadhar number auto generate 12 digits //////////
	     Random random = new Random();

	        // Generate a random 12-digit Aadhaar number
	        String aadhaarNum = "";
	       
	        for (int i = 0; i < 12; i++) {
	          
	        	int digit = random.nextInt(10); // Generate a random digit between 0 and 9
	            
	        	aadhaarNum = aadhaarNum.concat(String.valueOf(digit)); // Concatenate the digit to the Aadhaar number
	        
	        }

	    	System.out.println("Aadhaar Number : "+aadhaarNum);
		 
	     
	     
	   /////// pan number auto generate 10 digits ///////////
	    	 Random random2 = new Random();
	         
	         String panNum = "";
	         
	         for(int i = 0; i < 10; i++) {
	         	
	         	int digit = random2.nextInt(10); // // Generate a random digit between 0 and 9
	         	
	         	panNum = panNum.concat(String.valueOf(digit));
	        
	         }
	 		
	     	System.out.println("Pan Number : "+panNum);
	     	
	     	 Random random3 = new Random();

	         // Generate a random 10-digit mobile number
	         String mobileNum = "9"; // Start with 9 to ensure it's a mobile number
	         
	         for (int i = 0; i < 9; i++) {
	         
	         	int digit = random3.nextInt(10); // Generate a random digit between 0 and 9
	             
	         	mobileNum += digit; // Concatenate the digit to the mobile number
	         }

	         // Print the generated mobile number
	         System.out.println("Random mobile number: " + mobileNum);
	     
	     Screenshot screenshot = new Screenshot(driver);
	   
	     utils.clickVisibilityOfElementLocated(driver, clickUser, 10);
		 
	     utils.clickVisibilityOfElementLocated(driver, createUser, 10);
		 
	     utils.sendKeysWithExplicitWait(driver, imageUpload, "C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png", 10);
	     
		 utils.clickVisibilityOfElementLocated(driver, kitchenName, 10);
		 
		 String valueToClick = "SekarKitchen"; // The value to match and click
		 
		 utils.clickElementIfPresent(driver, valueToClick);
		 
		 utils.sendKeysWithExplicitWait(driver, firstname, firstName, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, lastname, lastName, 10);
		
		 utils.sendKeysWithExplicitWait(driver, usercode, userCode, 10);
		 
		 utils.clickVisibilityOfElementLocated(driver, role, 10);
		 
		 utils.clickVisibilityOfElementLocated(driver, roleValue, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, mobileno, mobileNum, 10);
		
		 utils.sendKeysWithExplicitWait(driver, dob, Dob, 10);
		
		 utils.clickVisibilityOfElementLocated(driver, clickGender, 10);
		 
	     String gender = "Male";
	     
	     utils.clickElementIfPresent(driver, gender);
		  
		 utils.clickVisibilityOfElementLocated(driver, clickBloodGroup, 10);
		 
		 utils.clickVisibilityOfElementLocated(driver, bloodGroupValue, 10);
		
		 utils.clickVisibilityOfElementLocated(driver, clickMaritalStatus, 10);
		
		 utils.clickVisibilityOfElementLocated(driver, maritalStatusValue, 10);
			
		 utils.sendKeysWithExplicitWait(driver, email, randomEmail, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, AadharNumber, aadhaarNum, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, PanNumber, panNum, 10);
		
		 utils.sendKeysWithExplicitWait(driver, Education, education, 10);
		
		 utils.sendKeysWithExplicitWait(driver, Address, address, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, Country, country, 10);
		
		 utils.sendKeysWithExplicitWait(driver, State, state, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, City, city, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, Postalcode, postalCode, 10);
	
	     screenshot.takeScreenshot();
	
	     utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
	     
		 screenshot.takeScreenshot();
		 
		 utils.setImplicitWait(10);
        
         return "Success";
	 }

	 public static String generateRandomEmail() {
	        
		 long timestamp = System.currentTimeMillis();
	     
		 int randomNumber = new Random().nextInt(10000);
	     
		 return "kitchenadmin" + randomNumber + "@gmail.com";
	    
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
	 
	 
	   public void clearField() {
		   
		  driver.findElement(By.xpath("//input[@id = 'user_FirstName']")).clear();
		   
		  driver.findElement(By.xpath("//input[@id = 'user_LastName']")).clear();
		  
		  driver.findElement(By.xpath("//input[@id = 'user_Code']")).clear();
		  
		  driver.findElement(By.xpath("user_Mobile")).clear();
		  
		  driver.findElement(By.xpath("user_Email")).clear();
		  
		  driver.findElement(By.xpath("//input[@id = 'user_Aadhar']")).clear();
		  
		  driver.findElement(By.xpath("//input[@id = 'user_Pan']")).clear();
		  
		  driver.findElement(By.xpath("//input[@id = 'user_Education']")).clear();
		  
		  driver.findElement(By.xpath("//input[@id = 'user_Address']")).clear();
		  
		  driver.findElement(By.xpath("div:nth-child(18) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).clear();
		  
		  driver.findElement(By.xpath("div:nth-child(17) div:nth-child(1) div:nth-child(2) input:nth-child(1)")).clear();
	   
	      driver.findElement(By.xpath("//input[@id = 'user_City']")).clear();
	      
	      driver.findElement(By.xpath("//input[@id = 'user_Postal']")).clear();
	   
	   }
	   
	   public void mandatoryInputs(String firstName, String lastName, String userCode, String mobileNum,
			  
			  String Dob, String randomEmail, String aadhaarNum, String panNum, 
			  
			  String address, String city, String state,
			  
			  String postalCode, String country) throws IOException {
		  
		  Utils utils = new Utils(driver);
		  
		  Screenshot screenshot = new Screenshot(driver);
		  
		  utils.clickVisibilityOfElementLocated(driver, kitchenName, 10);
			 
		String valueToClick = "SekarKitchen"; // The value to match and click
			 
		utils.clickElementIfPresent(driver, valueToClick);
		  
		  utils.sendKeysWithExplicitWait(driver, firstname, firstName, 10);
			
		  utils.sendKeysWithExplicitWait(driver, usercode, userCode, 10);
		  
		  utils.clickVisibilityOfElementLocated(driver, role, 10);
			 
		  utils.clickVisibilityOfElementLocated(driver, roleValue, 10);
		  
		  utils.sendKeysWithExplicitWait(driver, mobileno, mobileNum, 10);
			
		  utils.sendKeysWithExplicitWait(driver, dob, Dob, 10);
		  
		  utils.clickVisibilityOfElementLocated(driver, clickBloodGroup, 10);
			 
		  utils.clickVisibilityOfElementLocated(driver, bloodGroupValue, 10);
		  
		  utils.sendKeysWithExplicitWait(driver, email, randomEmail, 10);
			 
		  utils.sendKeysWithExplicitWait(driver, AadharNumber, aadhaarNum, 10);
			 
		  utils.sendKeysWithExplicitWait(driver, PanNumber, panNum, 10);
		  
		  utils.sendKeysWithExplicitWait(driver, Address, address, 10);
			 
		  utils.sendKeysWithExplicitWait(driver, Country, country, 10);
			
		  utils.sendKeysWithExplicitWait(driver, State, state, 10);
			 
		  utils.sendKeysWithExplicitWait(driver, City, city, 10);
			 
		  utils.sendKeysWithExplicitWait(driver, Postalcode, postalCode, 10);
		  
		  screenshot.takeScreenshot();
			
		  utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
		     
		  screenshot.takeScreenshot();
		  
	  }
	   
	   public void nonMandatory(String lastName, String education) {
		   
		   Utils utils = new Utils(driver);
		   
		   utils.sendKeysWithExplicitWait(driver, lastname, lastName, 10);
		   
		   utils.clickVisibilityOfElementLocated(driver, clickGender, 10);
			 
		     String gender = "Male";
		     
		   utils.clickElementIfPresent(driver, gender);
		   
		   utils.clickVisibilityOfElementLocated(driver, clickMaritalStatus, 10);
			
		   utils.clickVisibilityOfElementLocated(driver, maritalStatusValue, 10);
		   
		   utils.sendKeysWithExplicitWait(driver, Education, education, 10);
		   
	   }
	 
	 
	   public void emptyInputs() {
		   
		   Utils utils = new Utils(driver);
		   
		   utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
	   }
	 
	 
	 
	 
	
}