package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

public class Addschool {

	private WebDriver driver;
	
	   @FindBy(xpath = "//button[@id = 'menu_slider']")
	   WebElement dashboardIcon; // it selects dashsboars icon
	   
	   By ClickSchool = By.xpath("//h6[text() = 'School']"); // it selects School on dashboard
	   
	   By AddSchool = By.xpath("//a[normalize-space()='+ Add School']"); // it clicks add school btn
	   
	   By SchoolName = By.id("school_Name"); // enter school name
	
	   By SchoolCode = By.id("school_Code"); // enter school code
	
	   By PrincipalName = By.id("principal_Name"); // enter principal name
	   
	   By HavingSpareVessel = By.id("having_Vessel"); // it clicks Having spare vessel
	
	   By HavingSpareVesselValue = By.xpath("//li[text() = 'Yes']"); // it selects Having spare vessel value
	   
	   By DistancefromStartLocation = By.id("distance_Start"); // enter Distance from start location
	   
	   By Mobileno = By.id("mobile_Phone"); // enter mobile number
	   
	   By Landlineno = By.id("land_Line"); // enter landline number
	   
	   By Schooltype = By.id("school_Type"); // it clicks school type
	  
	   By Schooltypevalue = By.xpath("//li[text() = 'Government School']"); // it selects schooltype value
	   
	   By TotalNoOfStudents = By.id("number_Students"); // enter Total no of students
	 
	   By TotalStudentHavingMeals = By.id("number_Meals"); // enter total number of students having meal
	  
	   By Email = By.id("email_Address"); // enter email id
	   
	   By ContactPerson = By.xpath("//input[@id = 'contact_Person']"); // enter contact person
	   
	   By BeneficiaryPrimaryStudents = By.id("bene_Primary"); // enter Beneficiary Primary Students
	 
	   By BeneficiaryUpperPrimaryStudents = By.id("bene_Upper"); // enter Beneficiary Upper Primary Students
	 
	   By BeneficiarySecondaryStudents = By.id("beni_Secondary"); // enter Beneficiary Secondary Students
	   
	   By Locationaddress = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]");  // it clicks location icon
	 
	   By Searchplaces = By.xpath("//input[@placeholder = 'Search Places ...']"); // enter address in search bar
	   
	   By Saveaddress = By.xpath("//button[@class = 'save-modal']"); // it saves address
	   
	   By Country = By.xpath("//input[@id = 'scl_Country']"); // enter country
	   
	   By State = By.xpath("//input[@id = 'scl_State']"); // enter state
	   
	   By City = By.xpath("//input[@id = 'scl_City']"); // enter city
	  
	   By PostalCode = By.xpath("//input[@id = ' postal_Code']"); // enter Postal code
	  
	   By Latitude = By.xpath("//input[@id = 'scl_Latitude']"); // enter latitude
	   
	   By Longitude = By.xpath("//input[@id = 'scl_Longitude']"); // enter longitude
	   
	   By JoinedAkshayaPatraOn = By.xpath("//input[@id = 'joined_Tap']"); // enter Date Joined AkshayaPatra On
	   
	   By Savebtn = By.xpath("//button[text() = 'Save']");
	   
	   By Okbtn = By.xpath("//button[text() = 'OK']");
	 
	   public Addschool(WebDriver driver) {
	        
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
	    }
	   
	   
	   public String addSchool(String schoolName, String schoolCode, String principalName, String distanceFromStartLocation,
			   
			   String mobileNumber, String landlineNumber, String totalNoOfStudents, String totalStudentHavingMeals,
			   
			   String email, String contactPerson, String beneficiaryPrimaryStudets,
			   
			   String beneficiaryUpperPrimaryStudents, String beneficiarySecondaryStudnets, String searchPlace,
			   
			   String country, String state, String city, String postalCode, String latitude, String longitude, 
			   
			   String akshayapatraJoinedOn) throws InterruptedException, IOException {
		   
		  Screenshot screenshot = new Screenshot(driver);
		  
		  /////// Generate random Email id ///////
			 String randomEmail = generateRandomEmail();
		 
		   
		   /////// mobile number auto generate 10 digits ///////////
		   Random random3 = new Random();
		   
		   String mobileNum = "9"; // Start with 9 to ensure it's a mobile number
	        
	        for (int i = 0; i < 9; i++) {
	        
	        	int digit = random3.nextInt(10); // Generate a random digit between 0 and 9
	            
	        	mobileNum += digit; // Concatenate the digit to the mobile number
	        }

	        // Print the generated mobile number
	        System.out.println("Random mobile number: " + mobileNum);
		   
		     
		/////// landline number auto generate 10 digits ///////////
		     Random random2 = new Random();
		        
		        String lanlineNum = "";
		        
		        for(int i = 0; i < 10; i++) {
		        	
		        	int digit = random2.nextInt(10); // // Generate a random digit between 0 and 9
		        	
		        	lanlineNum = lanlineNum.concat(String.valueOf(digit));
		        	
		        }
		        
		        System.out.println("Lanline Number : "+lanlineNum);
		  
		     Utils utils = new Utils(driver);
	
		     utils.clickVisibilityOfElementLocated(driver, ClickSchool, 10);
		  
		     utils.clickVisibilityOfElementLocated(driver, AddSchool, 10);
		   
		  utils.sendKeysWithExplicitWait(driver, SchoolName, schoolName, 10);
		  
		  utils.sendKeysWithExplicitWait(driver, SchoolCode, schoolCode, 10);
		 
		  utils.sendKeysWithExplicitWait(driver, PrincipalName, principalName, 10);
		 
		  utils.clickVisibilityOfElementLocated(driver, HavingSpareVessel, 10);
		  
		  utils.clickVisibilityOfElementLocated(driver, HavingSpareVesselValue, 10);
		  
		  utils.sendKeysWithExplicitWait(driver, DistancefromStartLocation, distanceFromStartLocation, 10);
		  
		  utils.sendKeysWithExplicitWait(driver, Mobileno, mobileNum, 10); // auto generate
		 
		  utils.sendKeysWithExplicitWait(driver, Landlineno, lanlineNum, 10); // auto generate
		 
		  utils.clickVisibilityOfElementLocated(driver, Schooltype, 10);
		   
    List<WebElement> schoolTypeValue = driver.findElements(By.tagName("li"));
    
      if(schoolTypeValue.size() > 0) {
    	  
    	  schoolTypeValue.get(2).click();  // it selects school type value
      }
		
		 utils.sendKeysWithExplicitWait(driver, TotalNoOfStudents, totalNoOfStudents, 10);
		   
		 utils.sendKeysWithExplicitWait(driver, TotalStudentHavingMeals, totalStudentHavingMeals, 10);
		   
		 utils.sendKeysWithExplicitWait(driver, Email, randomEmail, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, ContactPerson, contactPerson, 10);
		   
		 utils.sendKeysWithExplicitWait(driver, BeneficiaryPrimaryStudents, beneficiaryPrimaryStudets, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, BeneficiaryUpperPrimaryStudents, beneficiaryUpperPrimaryStudents, 10);
		  
		 utils.sendKeysWithExplicitWait(driver, BeneficiarySecondaryStudents, beneficiarySecondaryStudnets, 10);
		 
		 utils.clickVisibilityOfElementLocated(driver, Locationaddress, 10);
		  
		 utils.sendKeysWithExplicitWait(driver, Searchplaces, searchPlace, 10);
		 
		 utils.clickVisibilityOfElementLocated(driver, Saveaddress, 10);
		 
		 utils.sendKeysWithExplicitWait(driver, Country, country, 10);  
		 
		 utils.sendKeysWithExplicitWait(driver, State, state, 10);
		
		 utils.sendKeysWithExplicitWait(driver, City, city, 10);
		   
		   utils.setImplicitWait(10);
		   
		 utils.sendKeysWithExplicitWait(driver, PostalCode, postalCode, 10);
		
	     utils.sendKeysWithExplicitWait(driver, Latitude, latitude, 10);
	    
	     utils.sendKeysWithExplicitWait(driver, Longitude, longitude, 10);
	     
	     utils.sendKeysWithExplicitWait(driver, JoinedAkshayaPatraOn, akshayapatraJoinedOn, 10);
	       
	       utils.setImplicitWait(10);
	       
	       screenshot.takeScreenshot();
	      
	       utils.setImplicitWait(10);
	       
	       utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);
	       
	       screenshot.takeScreenshot();
	       
	       utils.setImplicitWait(10);
	    
	       utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);
	       
	       utils.setImplicitWait(1000);
		
	       return "New School Added";
	       
	   }
	   
	   public static String generateRandomEmail() {
	        
	 		 long timestamp = System.currentTimeMillis();
	 	     
	 		 int randomNumber = new Random().nextInt(10000);
	 	     
	 		 return "school" + randomNumber + "@gmail.com";
	 	    
	 	 }
	   
	   
}  
	   
	
	


