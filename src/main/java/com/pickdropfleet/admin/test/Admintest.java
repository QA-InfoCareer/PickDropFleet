package com.pickdropfleet.admin.test;

import org.testng.annotations.Test;
import org.testng.internal.TestResult;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.PythonParser.return_stmt_return;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.config.prop.Configurationprop;
import com.pickdropfleet.admin.view.FoodMenuview;
import com.pickdropfleet.admin.view.Routeview;
import com.pickdropfleet.admin.view.Schoolview;
import com.pickdropfleet.admin.view.Userview;
import com.pickdropfleet.admin.view.Vehicleview;
import com.pickdropfleet.adminpages.Importpage;
import com.pickdropfleet.adminpages.Kitchenpage;
import com.pickdropfleet.adminpages.Loginpage;
import com.pickdropfleet.adminpages.Logoutpage;
import com.pickdropfleet.adminpages.Userpage;
import com.pickdropfleet.kitchenadminpages.Foodmenu;
import com.pickdropfleet.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admintest {

	WebDriver driver;
	
	@BeforeTest
	public void browserLaunch() {
		
	try {
	
		Properties properties = new Properties();
		
		InputStream input = new FileInputStream("config.properties");
		
		properties.load(input);
		
        String browser = properties.getProperty("browser1");
        
        System.out.println(browser);
        
        String url = properties.getProperty("url");
        
        if(browser.equalsIgnoreCase("firefox")) {
        	
        	ChromeOptions options = new ChromeOptions();

    		options.addArguments("--remote-allow-origins=*");
    		
    		options.addArguments("--incognito");
    		
    	    options.addArguments("force-device-scale-factor=1.2");
        	
//        FirefoxOptions options = new FirefoxOptions();
//        
//        options.addArguments("-private");
//        
//		options.addPreference("layout.css.devPixelsPerPx", "1.2"); 
//           
			 driver = new ChromeDriver(options);

			 driver.manage().window().maximize();
			 
			   driver.get(url);
			   
			   Thread.sleep(1000);
			   
			   System.out.println(url);
        }
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
			System.out.println(e);
		}
		
	   }
	
	@Test(priority = 1) 
	public void adminLogin() throws InterruptedException, IOException {
		   
		    //try {
		    	
		    if(driver.getCurrentUrl() != null) {
		    	
		   Loginpage loginPage = new Loginpage(driver);
		   
		   FileInputStream inputStream = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Superadminlogin.xlsx");
		  
			Workbook workbook = new XSSFWorkbook(inputStream);
			 
			Sheet sheet = workbook.getSheet("Sheet1");
			
		for (int i=1; i<sheet.getLastRowNum(); i++) {
			
			String userName = sheet.getRow(i).getCell(0).toString();
			
			  System.out.println("Super Admin username : "+ userName);
			
			String passKey = sheet.getRow(i).getCell(1).toString();
			
			  System.out.println("Super Admin password : "+ passKey);
			  
		  loginPage.loginAction(userName, passKey);
			
		    if (loginPage.isErrorMessageDisplayed() != false) {
		    	
		    	String errorMessage = loginPage.getErrorMessage();
		    	
		    	System.out.println("The Error Message is : " +errorMessage);
		    	
		    	driver.findElement(By.xpath("//button[text() = 'OK']")).click();
		   
		    	loginPage.clearField();
		   
		    } else if(loginPage.successLogin() != null) {
	            
		    	 System.out.println("Login Success");
	        }
		}
		
		    }
    }
		    	    	
		/*
		 * } catch (Exception e) {
		 * 
		 * e.getStackTrace();
		 * 
		 * System.out.println(e.getMessage());
		 * 
		 * }		 */

		    
	    @Test(priority = 2)
	    public void createKitchenByAdmin() {
	    	
	        try {
	        	
	        	if(driver.getCurrentUrl() != null) {
	        	
	        		Kitchenpage kitchenPage = new Kitchenpage(driver);
	    			
	    			FileInputStream inputStream = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\AddKitchen.xlsx");
	    			
	    			 Workbook workbook = new XSSFWorkbook(inputStream);
	    			 
	    			 Sheet sheet = workbook.getSheet("Sheet1");
	    			 
	    for(int i=1; i<sheet.getLastRowNum(); i++) {
	    	
	    	 String kitchenCode = sheet.getRow(i).getCell(0).toString();
	    	 
	    	 System.out.println("Kitchen Code : "+kitchenCode);
	    	 
	    	 String kitchenName = sheet.getRow(i).getCell(1).toString();
	    	 
	    	 System.out.println("Kitchen Name : "+kitchenName);
	    	 
	    	 String noOfCell = sheet.getRow(i).getCell(2).toString();
	    	 
	    	 String address = sheet.getRow(i).getCell(3).toString();
	    	 
	    	 String landmark = sheet.getRow(i).getCell(4).toString(); 
	    	 
	    	 String city = sheet.getRow(i).getCell(5).toString();
	    	 
	    	 String state = sheet.getRow(i).getCell(6).toString();
	    	 
	    	 String country = sheet.getRow(i).getCell(7).toString();
	    	 
	    	 System.out.println("Kitchen Admin country : " +country);
	    	 
	    	 String postalCode = sheet.getRow(i).getCell(8).toString();
	    	 
	    kitchenPage.addKitchenByAdmin(kitchenCode, kitchenName, noOfCell, address, landmark, city, state, country, postalCode, "3", "3");  
	    
	    }
	    
	    /////// Url verify ///////
	    String url = driver.getCurrentUrl();
	    
	    if(url.equalsIgnoreCase("https://groupnpay.com/PickdropFleet/kitchen")) {
	    	
	    	System.out.println(url);
	    }
	    
	      workbook.close();
		 
		  inputStream.close();
	        			
	        	}
	        	
	        } catch (Exception e) {
	        	
	        	System.out.println(e.getMessage());
	        	
	        } 
	   
	    }
	    
	    @Test(priority = 3)
	    public void createUserByAdmin() {
	    	 
	    	try {
	    		
	    		if(driver.getCurrentUrl() != null) {
	    			
        Userpage userPage = new Userpage(driver);
        
        Utils utils = new Utils(driver);
	    			
	    FileInputStream inputStream = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\AddUser.xlsx");
	    			
	    	Workbook workbook = new XSSFWorkbook(inputStream);
	    			 
	    	 Sheet sheet = workbook.getSheet("Sheet1");
	    			 
	   for(int i=1; i<sheet.getLastRowNum(); i++) {
		   
		 String firstName = sheet.getRow(i).getCell(0).toString();
		 
		 System.out.println("First Name : "+firstName);
		 
		 String lastName = sheet.getRow(i).getCell(1).toString();
		 
		 String userCode = sheet.getRow(i).getCell(2).toString();
		   
		 String mobileNumber = sheet.getRow(i).getCell(3).toString();
		 
		 String education = sheet.getRow(i).getCell(4).toString();
		 
		 String address = sheet.getRow(i).getCell(5).toString();
		 
		 String country = sheet.getRow(i).getCell(6).toString();
		 
		 String state = sheet.getRow(i).getCell(7).toString();
		 
		 String city = sheet.getRow(i).getCell(8).toString();
		 
		 String postalCode = sheet.getRow(i).getCell(9).toString();
		 
		 userPage.addUserByAdmin( 
				 
				 firstName, lastName, userCode, mobileNumber, "25091999", "imran100@gmail.com", "123456789012", "1234567890", education, address, country, state, city, postalCode);
		   
		   if(userPage.isErrorMessageDisplayed() == true) {
			   
			   String errorMessage = userPage.getErrorMessage();
			   
			   System.out.println("The Message is : " +errorMessage);
			   
			   driver.findElement(By.xpath("//button[text() = 'OK']")).click();
			   
			   userPage.refreshPage();
			   
			    utils.delay(700);
			   
		   } else {
			   
			   System.out.println();
		   }
	   }
	    			   		
	   /////// Url verify ///////
	   String url = driver.getCurrentUrl();
	   
	   if(url.equalsIgnoreCase("https://groupnpay.com/PickdropFleet/super-admin")) {
		   
		   System.out.println(url);
	   }
	   
	      workbook.close();
		 
		  inputStream.close();
	 }
	    		
	    	} catch (Exception e) {
	    		
	    		e.getStackTrace();
	    		
	    		System.out.println(e.getMessage());
	    	} 
	    	 	 
	     }
	    
	    @Test(priority = 10)
	    public void testImport() {
	    	
	    	try {
	    		
	    		Importpage importPage = new Importpage(driver);
		    	
		    	importPage.importPage();
		    	
		    	System.out.println("Successfully imported Kitchen");
	    		
	    	} catch (Exception e) {
	    		
	    		e.getMessage();
	    		
	    		System.out.println(e);
	    	}
	    }
	    
	    @Test(priority = 4)
	    public void testViewUser() throws InterruptedException {
	    	
	    	try {
	    		
	    		Userview userView = new Userview(driver);
		    	
		    	userView.viewUser();
	    		
	    	} catch(Exception e) {
	    		
	    		System.out.println(e.getMessage());
	    	}
	    }
	    
	    @Test(priority = 5)
	    public void testSchoolView() throws InterruptedException {
	    
	    	try {
	    		
		    	Schoolview schoolView = new Schoolview(driver);
		    	
		    	schoolView.schoolView();
	    		
	    	} catch(Exception e) {
	    		
	    		System.out.println(e.getMessage());
	    	}
	    }
	    
	    @Test(priority = 6)
	    public void testVehicleView() throws InterruptedException {
	    	
	    	try {
	    		
		    	Vehicleview vehicleView = new Vehicleview(driver);	    	
		    	
		    	vehicleView.vehicleView();
	    		
	    	} catch(Exception e) {
	    		
	    		System.out.println(e.getMessage());
	    	}
	    }
	    
	    @Test(priority = 7)
	    public void testMenuView() throws InterruptedException {
	    	
	    	try {
	    		
	    		FoodMenuview menuView = new FoodMenuview(driver);
		    	
		    	menuView.viewMenu();
	    		
	    	} catch (Exception e) {
	    		
	    		System.out.println(e.getMessage());
	    	}
	    }
	    
	    @Test(priority = 8)
	    public void testRouteView() throws InterruptedException {
	    	
	       try {
	    	   
	    		Routeview routeView = new Routeview(driver);
		    	
		    	routeView.viewRoute();
	    	   
	       } catch (Exception e) {
	    	   
	    	   System.out.println(e.getMessage());
	       }
	    }

	    @Test(priority = 9)
	    public void adminLogout() {
		  
		  Logoutpage logoutPage = new Logoutpage(driver);
		  
		  logoutPage.clickUserInfo();
		  
	   }
	
	public String successValidation(WebDriver driver) {
   	  
   	 try {
   		 
   	  WebElement successMsg = driver.findElement(By.xpath("//div[text() = 'Created Successfully']"));
		 
		  return successMsg.getText();
	
   	 } catch(Exception e) {
   		 
   		 System.out.println(e.getMessage());
   	 }

   	 return null;
   	 
     }
      
     public String unsuccessValidation(WebDriver driver) {
  
    	 try {
    		 	  
    	  WebElement errorMsg = driver.findElement(By.xpath("//div[text() = 'Not Created']"));
    	    	 
    	     return errorMsg.getText();
    		 
    	 } catch (Exception e) {
    		 
    		 System.out.println(e.getMessage());
    	 }
		
    	 return null;
     }
	
	
	
	
	
	
	
}
