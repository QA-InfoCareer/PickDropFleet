package com.pickdropfleet.adminpages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.StaticInitializerCoercer;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy(xpath = "//h6[text() = 'User']")
   WebElement clickUser;
   
   // It selects user
   @FindBy(xpath = "//a[text()='+ Create User']")
   WebElement createUser;
   
   // it upload image
   By imageUpload = By.xpath("//input[@type='file']");
   
    // It selects kitchen name
   @FindBy(xpath = "//em[normalize-space()='Select Kitchen Name']")
   WebElement kitchenName;
   
    // It selects kitchen value
   @FindBy(xpath = "//li[text() = 'Dominos Kitchens']")
   WebElement kitchenNameValue;
   
    // enter firstname
   @FindBy(xpath = "//input[@id = 'user_FirstName']")
   WebElement firstname;
   
   // enter lastname
   @FindBy(xpath = "//input[@id = 'user_LastName']") 
   WebElement lastname;
   
   // enter usercode
   @FindBy(xpath = "//input[@id = 'user_Code']")
   WebElement usercode;
   
    // It selects role
   @FindBy(xpath = "//div/em[text() = 'Select Role']")
   WebElement role;
   
    // It selects role value
   @FindBy(xpath = "//li[normalize-space()='Kitchen Admin']")
   WebElement roleValue;
   
    // enter mobile number
   @FindBy(xpath = "//input[@id = 'user_Mobile']")
   WebElement mobileno;
   
   // enter dob
   @FindBy(xpath = "(//div[@class = 'css-l5c1s3'] //input[@id='user_Dob'])[1]")
   WebElement dob;
   
   // It clicks gender
   @FindBy(xpath = "//div[@class = 'css-l5c1s3'] //div[@id = 'user_Gender']")
   WebElement clickGender;
   
   // It selects gender value
   @FindBy(xpath = "//li[text() = 'Male']")
   WebElement selectGender;
   
   // It clicks blood group
   @FindBy(xpath = "//em[text() = 'Select Blood Group']")
   WebElement clickBloodGroup;
		   
   // It selects blood group value
   @FindBy(xpath = "//li[text() = 'O+VE']")
   WebElement bloodGroupValue;
   
   // It clicks marital status
   @FindBy(xpath = "//div[@id = 'user_Maritalstatus']")
   WebElement clickMaritalStatus;
   
   // It selects marital status value
   @FindBy(xpath = "//li[text()='Unmarried']")
   WebElement maritalStatusValue;
   
   // enter email
   @FindBy(xpath = "//input[@id = 'user_Email']")
   WebElement email;
   
   // enter aadhar number
   @FindBy(xpath = "//input[@id = 'user_Aadhar']")
   WebElement AadharNumber;
   
   // enter pan number
   @FindBy(xpath = "//input[@id = 'user_Pan']")
   WebElement PanNumber;
   
   // enter education
   @FindBy(xpath = "//input[@id = 'user_Education']")
   WebElement Education;
   
   // enter address
   @FindBy(xpath = "//input[@id = 'user_Address']")
   WebElement Address;
   
   // enter country
   @FindBy(css = "div:nth-child(18) div:nth-child(1) div:nth-child(2) input:nth-child(1)")
   WebElement Country;
   
   // enter state
   @FindBy(css = "div:nth-child(17) div:nth-child(1) div:nth-child(2) input:nth-child(1)")
   WebElement State;
   
   // enter city
   @FindBy(xpath = "//input[@id = 'user_City']")
   WebElement City;
   
   // enter postal code
   @FindBy(xpath = "//input[@id = 'user_Postal']")
   WebElement Postalcode;
   
    // It clicks Save btn
   @FindBy(xpath = "//button[text() = 'Save']")
   WebElement Savebtn;
   
    // It clicks Ok btn
   @FindBy(xpath = "//button[text() = 'OK']")
   WebElement Okbtn;
   
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
	   
	     utils.clickElementWithWait(driver, clickUser);
		 
	     utils.clickElementWithWait(driver, createUser);
	     
	     utils.setImplicitWait(10);
		 
	     driver.findElement(imageUpload).sendKeys("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png");
	     
	     utils.setImplicitWait(10);
	     
		 utils.clickElementWithWait(driver, kitchenName);
		 
		 String valueToClick = "FriedKitchen"; // The value to match and click
		 
		 utils.clickElementIfPresent(driver, valueToClick);
		 
		 utils.setImplicitWait(20);
		 
		 firstname.sendKeys(firstName);
		 
		 utils.setImplicitWait(10);
		 
		 lastname.sendKeys(lastName);
		 
		 utils.setImplicitWait(10);
		 
		 usercode.sendKeys(userCode);
		 
		 utils.setImplicitWait(10);
		 
		 utils.clickElementWithWait(driver, role);
		 
		 utils.clickElementWithWait(driver, roleValue);
		 
		 utils.setImplicitWait(10);
		 
		 mobileno.sendKeys(mobileNum);
		 
		 utils.setImplicitWait(10);
		
		 dob.sendKeys(Dob);
		 
		 utils.setImplicitWait(10);
		
		 utils.clickElementWithWait1(driver, clickGender);
		 
	     String gender = "Male";
	     
	     utils.clickElementIfPresent(driver, gender);
		  
		 utils.clickElementWithWait(driver, clickBloodGroup);
		 
		 utils.clickElementWithWait(driver, bloodGroupValue);
		
		 utils.clickElementWithWait(driver, clickMaritalStatus);
		
		 utils.clickElementWithWait(driver, maritalStatusValue);
			
		 email.sendKeys(randomEmail);
		 
		 utils.setImplicitWait(10);
		 
		 AadharNumber.sendKeys(aadhaarNum);
		 
		 utils.setImplicitWait(10);
		 
		 PanNumber.sendKeys(panNum);
		 
		 utils.setImplicitWait(10);
		
		 Education.sendKeys(education);
		 
		 utils.setImplicitWait(10);
		 
		 Address.sendKeys(address);
		 
		 utils.setImplicitWait(10);
		 
		 Country.sendKeys(country);
		 
		 utils.setImplicitWait(10);
		
		 State.sendKeys(state);
		 
		 utils.setImplicitWait(10);
		 
		 City.sendKeys(city);
		 
		 utils.setImplicitWait(10);
		
		 Postalcode.sendKeys(postalCode);
		 
		 utils.setImplicitWait(10);
		
	     screenshot.takeScreenshot();
		
	     utils.clickElementWithWait(driver, Savebtn);
		 
		 screenshot.takeScreenshot();
		 
		 utils.setImplicitWait(10);
		 
		 utils.okClickElementWithWait(driver, Okbtn);
        
         return "Success";
	 }

	 public static String generateRandomEmail() {
	        
		 long timestamp = System.currentTimeMillis();
	     
		 int randomNumber = new Random().nextInt(10000);
	     
		 return "kitchenadmin" + randomNumber + "@gmail.com";
	    
	 }
	   
	    
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}