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
	   
	   @FindBy(xpath = "//h6[text() = 'School']")
	   WebElement ClickSchool; // it selects School on dashboard
	   
	   @FindBy(xpath = "//a[normalize-space()='+ Add School']")
	   WebElement AddSchool; // it clicks add school btn
	   
	   @FindBy(id = "school_Name")
	   WebElement SchoolName; // enter school name
	
	   @FindBy(id = "school_Code")
	   WebElement SchoolCode; // enter school code
	
	   @FindBy(id = "principal_Name")
	   WebElement PrincipalName; // enter principal name
	   
	   @FindBy(id = "having_Vessel")
	   WebElement HavingSpareVessel; // it clicks Having spare vessel
	
	   @FindBy(xpath = "//li[text() = 'Yes']")
	   WebElement HavingSpareVesselValue; // it selects Having spare vessel value
	   
	   @FindBy(id = "distance_Start")
	   WebElement DistancefromStartLocation; // enter Distance from start location
	   
	   @FindBy(id = "mobile_Phone")
	   WebElement Mobileno; // enter mobile number
	   
	   @FindBy(id = "land_Line")
	   WebElement Landlineno; // enter landline number
	   
	   @FindBy(id = "school_Type")
	   WebElement Schooltype; // it clicks school type
	   
	   @FindBy(xpath = "//li[text() = 'Government School']")
	   WebElement Schooltypevalue; // it selects schooltype value
	   
	   @FindBy(id = "number_Students")
	   WebElement TotalNoOfStudents; // enter Total no of students
	   
	   @FindBy(id = "number_Meals")
	   WebElement TotalStudentHavingMeals; // enter total number of students having meal
	   
	   @FindBy(id = "email_Address")
	   WebElement Email; // enter email id
	   
	   @FindBy(xpath = "//input[@id = 'contact_Person']")
	   WebElement ContactPerson; // enter contact person
	   
	   @FindBy(id = "bene_Primary")
	   WebElement BeneficiaryPrimaryStudents; // enter Beneficiary Primary Students
	   
	   @FindBy(id = "bene_Upper")
	   WebElement BeneficiaryUpperPrimaryStudents; // enter Beneficiary Upper Primary Students
	   
	   @FindBy(id = "beni_Secondary")
	   WebElement BeneficiarySecondaryStudents; // enter Beneficiary Secondary Students
	   
	   @FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]")
	   WebElement Locationaddress;  // it clicks location icon
	   
	   @FindBy(xpath = "//input[@placeholder = 'Search Places ...']")
	   WebElement Searchplaces; // enter address in search bar
	   
	   @FindBy(xpath = "//button[@class = 'save-modal']")
	   WebElement Saveaddress;  // it saves address
	   
	   @FindBy(xpath = "//input[@id = 'scl_Country']")
	   WebElement Country; // enter country
	   
	   @FindBy(xpath = "//input[@id = 'scl_State']")
	   WebElement State; // enter state
	   
	   @FindBy(xpath = "//input[@id = 'scl_City']")
	   WebElement City; // enter city
	   
	   @FindBy(xpath = "//input[@id = ' postal_Code']")
	   WebElement PostalCode; // enter Postal code
	   
	   @FindBy(xpath = "//input[@id = 'scl_Latitude']")
	   WebElement Latitude; // enter latitude
	   
	   @FindBy(xpath = "//input[@id = 'scl_Longitude']")
	   WebElement Longitude; // enter longitude
	   
	   @FindBy(xpath = "//input[@id = 'joined_Tap']")
	   WebElement JoinedAkshayaPatraOn; // enter Date Joined AkshayaPatra On
	   
	   @FindBy(xpath = "//button[text() = 'Save']")
	   WebElement Savebtn;
	   
	   @FindBy(xpath = "//button[text() = 'OK']")
	   WebElement Okbtn;
	 
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
	
		     utils.clickElementWithWait(driver, ClickSchool);
		  
		     utils.clickElementWithWait(driver, AddSchool);
		 
		     utils.setImplicitWait(10);
		   
		   SchoolName.sendKeys(schoolName);
		   
		   utils.setImplicitWait(10);
		   
		   SchoolCode.sendKeys(schoolCode);
		   
		   utils.setImplicitWait(10);
		   
		   PrincipalName.sendKeys(principalName);
		   
		   utils.setImplicitWait(10);
		   
		   utils.clickElementWithWait(driver, HavingSpareVessel);
		   
		   utils.clickElementWithWait(driver, HavingSpareVesselValue);
		   
		   utils.setImplicitWait(10);
		   
		   DistancefromStartLocation.sendKeys(distanceFromStartLocation);
		   
		   utils.setImplicitWait(10);
		   
		   Mobileno.sendKeys(mobileNum); // auto generate
		   
		   utils.setImplicitWait(10);
		   
		   Landlineno.sendKeys(lanlineNum); // auto generate
		   
		   utils.setImplicitWait(10);
		   
		   utils.clickElementWithWait(driver, Schooltype);
		   
    List<WebElement> schoolTypeValue = driver.findElements(By.tagName("li"));
    
      if(schoolTypeValue.size() > 0) {
    	  
    	  schoolTypeValue.get(2).click();  // it selects schhol type value
      }
		
		   utils.setImplicitWait(10);
		   
		   TotalNoOfStudents.sendKeys(totalNoOfStudents);
		   
		   utils.setImplicitWait(10);
		   
		   TotalStudentHavingMeals.sendKeys(totalStudentHavingMeals);
		   
		   utils.setImplicitWait(10);
		   
		   Email.sendKeys(randomEmail); //auto generate
		   
		   utils.setImplicitWait(10);
		   
		   ContactPerson.sendKeys(contactPerson);
		   
		   utils.setImplicitWait(10);
		   
		   BeneficiaryPrimaryStudents.sendKeys(beneficiaryPrimaryStudets);
		   
		   utils.setImplicitWait(10);
		   
		   BeneficiaryUpperPrimaryStudents.sendKeys(beneficiaryUpperPrimaryStudents);
		   
		   utils.setImplicitWait(10);
		   
		   BeneficiarySecondaryStudents.sendKeys(beneficiarySecondaryStudnets);
		   
		   utils.setImplicitWait(10);
		   
		   utils.clickElementWithWait(driver, Locationaddress);
		   
		   utils.setImplicitWait(10);
		   
		   Searchplaces.sendKeys(searchPlace);
		   
		   utils.setImplicitWait(10);
		   
		   utils.clickElementWithWait(driver, Saveaddress);
		   
		   utils.setImplicitWait(10);
		   
		   Country.sendKeys(country);
		   
		   utils.setImplicitWait(10);
		   
		   State.sendKeys(state);
		   
		   utils.setImplicitWait(10);
		   
		   City.sendKeys(city);
		   
		   utils.setImplicitWait(10);
		   
		   PostalCode.sendKeys(postalCode);
		   
		   utils.setImplicitWait(10);

	       Latitude.sendKeys(latitude);
	       
	       utils.setImplicitWait(10);
	       
	       Longitude.sendKeys(longitude);
	       
	       utils.setImplicitWait(10);
	       
	       JoinedAkshayaPatraOn.sendKeys(akshayapatraJoinedOn);
	       
	       utils.setImplicitWait(10);
	       
	       screenshot.takeScreenshot();
	      
	       utils.setImplicitWait(10);
	       
	       utils.clickElementWithWait(driver, Savebtn);
	       
	       screenshot.takeScreenshot();
	       
	       utils.setImplicitWait(10);
	    
	       utils.clickElementWithWait(driver, Okbtn);
	       
	       utils.setImplicitWait(1000);
		
	       return "New School Added";
	       
	   }
	   
	   public static String generateRandomEmail() {
	        
	 		 long timestamp = System.currentTimeMillis();
	 	     
	 		 int randomNumber = new Random().nextInt(10000);
	 	     
	 		 return "school" + randomNumber + "@gmail.com";
	 	    
	 	 }
	   
	   
}  
	   
	
	


