package com.pickdropfleet.admin.test;
//package com.superadmin.pickdropfleet;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.pickdropfleet.pages.Loginpage;
//
//@Test(priority = 1)
//public class Superadmin extends Loginpage {
//
//	 public Superadmin(WebDriver driver) {
//		
//		 super(driver);
//	}
//
//	WebDriver driver;
//	
//	@BeforeTest
//	@Parameters({"url","browser"})
//	public void launchBrowser(String url,String browser) throws InterruptedException {
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			
//			 ChromeOptions options = new ChromeOptions();
//
//			 options.addArguments("--remote-allow-origins=*");    //--remote-allow-origins=*
//				
//			 //options.addArguments("--headless");  // without opening browser = --headless or setHeadless()
//				
//			 driver = new ChromeDriver(options);
//
//			 driver.manage().window().maximize();
//			 
//			 if(driver != null) {
//				 
//				 if(url.equalsIgnoreCase("https://groupnpay.com/PickdropFleet/")) {
//					 
//					 driver.get(url);
//					 
//					Thread.sleep(5000);
//				 }
//			 }		 
//		}
//	}
//	
//	////////////////// login ////////////////
//	
//	  
//	  @Parameters({"password"})
//	  public void testLogin(String password) throws InterruptedException {
////		  
////         if(driver.getCurrentUrl() != null) {
////        	 
////        	 long startTime = System.currentTimeMillis();
////        	 
////    		WebElement userName = driver.findElement(By.xpath("//input[@type = 'email']"));
////    		 
////    		 userName.sendKeys("admin@gmail.com");
////    		 
////    		WebElement passKey = driver.findElement(By.xpath("//input[@name= 'password']"));
////    		 
////    		 passKey.sendKeys(password);
////    		
////    		WebElement submit = driver.findElement(By.xpath("//button[@type= 'submit']"));
////    		 
////    		 submit.click();
////    		 
////    		 long endTime = System.currentTimeMillis();
////    		 
////    		 long time = endTime - startTime;
////    		 
////    		 System.out.println("Total time taken for login : "+time+" ms");
////    		 
////    		 Thread.sleep(1000);
//    		 
////                     ////////////// logout /////////////
////    		 
////    		 // user icon
////    		WebElement userIcon = driver.findElement(By.xpath("//span[@class='anticon anticon-user']//*[name()='svg']"));
////    		 
////    		Thread.sleep(1000);
////    		
////    		 Actions actions = new Actions(driver);
////    		 
////    		 actions.click(userIcon).build().perform();
////    		 
////    		 // click logout button
////    		 driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();
//         //}  
//	  }
//	  
//	  ////////////// Create Kitchen /////////////
//   
//	  
//	  public void createKitchenByAdmin() {
//		  
//		  try {
//			  
//			// click for dashboard
//			  driver.findElement(By.xpath("//span[@aria-label='menu-unfold']//*[name()='svg']")).click();
//			  
//			  Thread.sleep(1000);
//			 
//			  // click kitchen on dashboard
//			  driver.findElement(By.xpath("//a[@href ='/PickdropFleet/kitchen']")).click();
//			  
//			  Thread.sleep(1000);
//			  
//			  // create kitchen
//			  driver.findElement(By.xpath("//a[normalize-space()='+ Add kitchen']")).click();
//			  
//			  Thread.sleep(1000);
//			  
//			  // enter kitchen code
//			  driver.findElement(By.xpath("//input[@id = 'code']")).sendKeys("10");
//			  
//			  Thread.sleep(1000);
//			  
//			  // enter kitchen name
//			  driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//			  
//			  .sendKeys("Jannath Hotel");
//			  
//			  Thread.sleep(1000);
//			  
//			  //select kitchen type
//			WebElement kitchenType = driver.findElement(By.xpath("//em[normalize-space()='Select Kitchen Type']"));
//			
//	       kitchenType.click();
//	       
//	       // it selects kitchen value
//	    WebElement kitchenValue = driver.findElement(By.xpath("//li[@data-value = '1']"));
//	     
//	    kitchenValue.click();
//	    
//	     Thread.sleep(1000);
//			 
//			   // select vessel type
//			WebElement vesselType = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"));
//			
//			 vesselType.click();
//			 
//			 // it selects vessel value
//			WebElement vesselValue = driver.findElement(By.xpath("//li[@data-value = '1']"));
//			 
//			vesselValue.click();
//			
//			 Thread.sleep(1000);
//			
//			   // enter no of vessels
//			driver.findElement(By.xpath("//input[@type = 'number']")).sendKeys("2");  
//			
//			   Thread.sleep(1000);
//			
//			  // select meal type
//		WebElement mealType = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"));
//			  
//			mealType.click();
//			
//			// it selects meal value
//		WebElement mealValue = driver.findElement(By.xpath("//li[@data-value = '3']"));
//			
//		    mealValue.click();
//		
//			Thread.sleep(1000);
//			
//			// enter address
//	    driver.findElement(By.xpath("//input[@id = 'address']")).sendKeys("SPL Sriram Niwas Building Third Floor Info Career Pvt Ltd , Mandaiveli");		
//			  
//	      Thread.sleep(1000);
//	    
//	     // enter city
//	    driver.findElement(By.xpath("//input[@id = 'city']")).sendKeys("Chennai");
//			  
//	        Thread.sleep(1000);  
//	    
//	     // enter state
//		  driver.findElement(By.xpath("//input[@id = 'state']")).sendKeys("Tamilnadu");
//			 
//		     Thread.sleep(1000);
//		  
//		   // enter country
//		  driver.findElement(By.xpath("//input[@id = 'country']")).sendKeys("India");	
//		  
//		     Thread.sleep(1000);
//		  
//		   // enter pin code
//		  driver.findElement(By.xpath("//input[@id = 'postal']")).sendKeys("625028");
//		  
//		    Thread.sleep(1000);
//		
//		   ////////////// available vessel sizes //////////////
//		  WebElement medium = driver.findElement(By.xpath("//span[normalize-space()='Medium']"));
//		  
//		  if(medium.isSelected() == false) {
//			  
//			  Thread.sleep(1000);
//			  
//			  medium.click();
//		  
//		  } else {
//			  
//			  System.out.println("Medium vessel is not selected");
//		  }
//		  
//		  Thread.sleep(1000);
//		  
//		  WebElement small = driver.findElement(By.xpath("//span[normalize-space()='Small']"));
//		  
//		     if(small.isSelected() == false) {
//		    	 
//		    	 Thread.sleep(1000);
//		    	 
//		    	 small.click();
//		     
//		     } else {
//		    	 
//		    	 System.out.println("Small vessel is not selected");
//		     }
//		     
//		       Thread.sleep(1000);
//		       
//		   WebElement upArrowSmall = driver.findElement(By.xpath("//input[@id = 'small']"));
//		  
//		    upArrowSmall.sendKeys("2");
//		    
//		    Thread.sleep(1000);
//		   
//		   WebElement upArrowMedium = driver.findElement(By.xpath("//input[@id = 'medium']"));
//		  
//		    upArrowMedium.sendKeys("2");
//		    
//		    Thread.sleep(1000);
//		   
//		      // click submit btn
//		  //  driver.findElement(By.xpath("//button[@type='submit']")).click();
//		    
//		   // Thread.sleep(2000);
//		    
//		    // click ok for popup
//	    // driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
//		    
//		    System.out.println("Kitchen Created Succesfully");
//		    
//		    // click back btn
//		    driver.findElement(By.xpath("//button[normalize-space() = 'Back']")).click();
//			  
//		  } catch (Exception e) {
//			  
//			  System.out.println(e.getMessage());
//		  }
//	  }
//	  
//	  /////////// Create User //////////////
//	  
//	  public void createUserByAdmin() {
//		  
//		  try {
//			  
//			// click for dashboard
//			  driver.findElement(By.xpath("//span[@aria-label='menu-unfold']//*[name()='svg']")).click();
//			  
//			  Thread.sleep(1000);
//			  
//			   // click user on dashboard
//			  driver.findElement(By.xpath("//h6[text() = 'User']")).click();
//			  
//			  Thread.sleep(1000);
//			  
//			  // create user
//			  driver.findElement(By.xpath("//a[normalize-space() = '+ Create User']")).click();
//			  
//			  Thread.sleep(1000);
//			  
//			  // upload image
//			WebElement imageUpload = driver.findElement(By.xpath("//input[@type='file']"));
//			
//			imageUpload.sendKeys("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png");
//			
//			Thread.sleep(1000);
//			
//			 // enter kitchen name
//			WebElement kitchenName = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"));
//			  
//			kitchenName.click();
//			
//			Thread.sleep(1000);
//			
//			// selects Thiruvanmayur
//		WebElement kitchenNameValue = driver.findElement(By.xpath("//li[@data-value = '644b59f3d831ba597957dcec']"));
//			  
//		kitchenNameValue.click();
//		
//			Thread.sleep(1000);
//			
//			// enter firstname
//			driver.findElement(By.id("firstName")).sendKeys("Mano");
//			
//			Thread.sleep(1000);
//			
//			// enter lastname
//			driver.findElement(By.id("lastName")).sendKeys("Haran");
//			
//			Thread.sleep(1000);
//			
//			// enter user code
//			driver.findElement(By.id("userCode")).sendKeys("10");
//			
//			Thread.sleep(1000);
//			
//			// click on role
//		WebElement role = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"));
//			
//		  role.click();
//		
//			Thread.sleep(1000);
//			
//			// select role
//		WebElement roleValue = driver.findElement(By.xpath("//li[@data-value = '2']"));
//			
//		   roleValue.click();
//		
//			Thread.sleep(1000);
//			
//			// enter mobile number
//			driver.findElement(By.id("mobile")).sendKeys("1234567890");
//			
//			Thread.sleep(1000);
//			
//			// click dob
//			driver.findElement(By.id("dob")).sendKeys("25091999");
//			
//			Thread.sleep(1000);
//			
//			// click on gender
//			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(8) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
//			
//			// select gender
//			driver.findElement(By.xpath("//li[@data-value = '2']")).click();
//			
//			Thread.sleep(1000);
//			
//			// click blood group
//			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
//			
//			// select blood group
//			driver.findElement(By.xpath("//li[@data-value = '5']")).click();
//			
//			Thread.sleep(1000);
//			
//			// click marital status
//			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(10) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
//			
//			Thread.sleep(1000);
//			
//			// select marital status
//			driver.findElement(By.xpath("//li[@data-value = '2']")).click();
//			
//			Thread.sleep(1000);
//			
//			// enter email
//			driver.findElement(By.id("email")).sendKeys("imr@gmail.com");
//			
//			Thread.sleep(1000);
//			
//			// enter aadhar number
//			driver.findElement(By.id("aadhar")).sendKeys("12345");
//			
//			Thread.sleep(1000);
//			
//			// enter pan
//			driver.findElement(By.id("pan")).sendKeys("124");
//			
//			Thread.sleep(1000);
//			
//			// enter education
//			driver.findElement(By.id("education")).sendKeys("BE Architecture");
//			
//			Thread.sleep(1000);
//			
//			// enter address
//			driver.findElement(By.id("address")).sendKeys("SPL Sriram Nivas Building Mandailveli , Chennai");
//			
//			Thread.sleep(1000);
//			
//			// enter country
//			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(16) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys("India");
//			
//			Thread.sleep(1000);
//			
//			// enter state
//			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(17) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys("Tamilnadu");
//			
//			Thread.sleep(1000);
//			
//			// enter city
//			driver.findElement(By.id("city")).sendKeys("Chennai");
//			
//			Thread.sleep(1000);
//			
//			// enter postal code
//			driver.findElement(By.id("postal")).sendKeys("600028");
//			
//			Thread.sleep(1000);
//			
//			// submit
//			driver.findElement(By.xpath("//button[@type = 'submit']")).click();
//			
//			System.out.println("User created successfully");
//			  
//		  } catch (Exception e) {
//			  
//			  System.out.println(e.getMessage());
//		  }
//	   }
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	
//	
//}
