package com.pickdropfleet.admin.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.pickdropfleet.adminpages.Loginpage;
import com.pickdropfleet.adminpages.Logoutpage;
import com.pickdropfleet.kitchenadminpages.Adddistributionmanager;
import com.pickdropfleet.kitchenadminpages.Addfuelsupervisor;
import com.pickdropfleet.kitchenadminpages.Addrider;
import com.pickdropfleet.kitchenadminpages.Addroute;
import com.pickdropfleet.kitchenadminpages.Addrouteadmin;
import com.pickdropfleet.kitchenadminpages.Addschool;
import com.pickdropfleet.kitchenadminpages.Addschooladmin;
import com.pickdropfleet.kitchenadminpages.Addschoolrelationshipmanager;
import com.pickdropfleet.kitchenadminpages.Addvehicle;
import com.pickdropfleet.kitchenadminpages.Addvehicleexpense;
import com.pickdropfleet.kitchenadminpages.Dailyrequest;
import com.pickdropfleet.kitchenadminpages.Foodmenu;
import com.pickdropfleet.kitchenadminpages.Importpage;
import com.pickdropfleet.utils.Utils;

public class Kitchenadmintest {

	private WebDriver driver;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeTest
	public void browserLaunch() {

		try {

			Properties properties = new Properties();

			InputStream input = new FileInputStream("config.properties");

			properties.load(input);

			String browser = properties.getProperty("browser");

			String url = properties.getProperty("url");

			if (browser.equalsIgnoreCase("chrome")) {

				ChromeOptions options = new ChromeOptions();

				options.addArguments("--remote-allow-origins=*");
				
				options.addArguments("--incognito");
				
				options.addArguments("force-device-scale-factor=1.2");

//			  options.addArguments("disable-infobars");

//			  options.addArguments("--disable-extensions");

				driver = new ChromeDriver(options);

				driver.manage().window().maximize();

				driver.get(url);

				Thread.sleep(1000);

				System.out.println(url);

			}

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println(e);
		}

	}

	@Test(priority = 0)
	public void kitchenAdminLogin() {

		try {

			if(driver.getCurrentUrl() != null) {
				
				Loginpage loginPage = new Loginpage(driver);

			    FileInputStream inputStream = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Kitchenadminlogin.xlsx");
			    			
			     Workbook workbook = new XSSFWorkbook(inputStream);
			    			 
			     Sheet sheet = workbook.getSheet("Sheet1");
			     
			  for(int i=1; i<sheet.getLastRowNum(); i++) {
				  
				 String userName = sheet.getRow(i).getCell(0).toString();
				 
				 System.out.println("Kitchen Admin username : "+ userName);
				 
				 String passKey = sheet.getRow(i).getCell(1).toString();
				 
				 System.out.println("Kitchen Admin password : "+ passKey);
				 
				 loginPage.loginAction(userName, passKey);
				 
				 if(loginPage.isErrorMessageDisplayed() != false) {
					 
					 String errorMessage = loginPage.getErrorMessage();
					 
					 System.out.println("Message is : "+errorMessage);
					 
					 driver.findElement(By.xpath("//button[text() = 'OK']")).click();
					 
					 loginPage.clearField();
				 
				 } else if(loginPage.successLogin() != null) {
					 
					 System.out.println("Login success");
				 }
				  
			  }
				
			}
			
			
		} catch (Exception e) {

			e.getStackTrace();

			System.out.println(e.getMessage());
		}

	}
	///////////// Create New School /////////////

	@Test(priority = 1)
	public void addSchoolTest() {

		try {

			Addschool addSchool = new Addschool(driver);

			FileInputStream inputStream = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Addschool.xlsx");

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheet("Sheet1");

			for (int i = 1; i < sheet.getLastRowNum(); i++) {

				String schoolName = sheet.getRow(i).getCell(0).toString();

				System.out.println("School Name : " + schoolName);

				String schoolCode = sheet.getRow(i).getCell(1).toString();

				System.out.println(("School Code : " + schoolCode));

				String principalName = sheet.getRow(i).getCell(2).toString();

				String mobileNumber = sheet.getRow(i).getCell(3).toString();

				String landLine = sheet.getRow(i).getCell(4).toString();

				String address = sheet.getRow(i).getCell(5).toString();

				addSchool.addSchool(schoolName, schoolCode, principalName, "25 kms", mobileNumber, landLine, "400",

						"200", "imr123@gmail.com", "9087136123", "0", "0", "0", address, "India", "Tamilnadu",

						"Madurai", "625001", "12.9516718", "77.7067857", "19-05-2023");

				System.out.println("New School added");
			}

			/////// Verify url ///////
			String url = driver.getCurrentUrl();

			if (url.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/schoolManagement")) {

				System.out.println("School page url is verified :" + url);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	 @Test(priority = 2)
	 public void addRiderAtUser() throws InterruptedException {
    	
    	try {
    		
    		if(driver.getCurrentUrl() != null) {
    			
    			Addrider user = new Addrider(driver);
    			
    	FileInputStream inputStream = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Adddriver.xlsx");
    			
    	  Workbook workbook = new XSSFWorkbook(inputStream);
    			 
    		 Sheet sheet = workbook.getSheet("Sheet1");
    		 
    		 for(int i=1; i<sheet.getLastRowNum(); i++) {
    			 
     String firstName = sheet.getRow(i).getCell(0).toString();
     
      System.out.println("Rider First Name : "+firstName);
     
     String lastName = sheet.getRow(i).getCell(1).toString();
     
      System.out.println("Last Name : "+lastName);
     
     String userCode = sheet.getRow(i).getCell(2).toString();
     
     System.out.println("User Code : "+userCode);
    			 
     String mobileNumber = sheet.getRow(i).getCell(3).toString();	
     
     String education = sheet.getRow(i).getCell(4).toString();
     
     String country = sheet.getRow(i).getCell(5).toString();
     
     String state = sheet.getRow(i).getCell(6).toString();
     
     String city = sheet.getRow(i).getCell(7).toString();
    			 
     String postalCode = sheet.getRow(i).getCell(8).toString();

      // add rider
     
     user.addRider("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png", firstName, lastName, 
    		 
    		 userCode, mobileNumber, "25091999", "imranmik10@gamil.com", "1234", "123", education, 
    		 
    		 "3, Edepally Street, Mandaveli, Mandaveli, Trustpakkam, Mandaveli, Chennai, Tamil Nadu 600028, India", country, state, city, postalCode);
  
    		 }	    
    		
    	      /////// Verify url ///////
    		String url = driver.getCurrentUrl();
    		
    		if(url.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/user")) {
    			
    			System.out.println("User page url is verified : "+url);
    			
    		}
    	}
   	    	    		
    		} catch(Exception e){

		      e.getStackTrace();

		      System.out.println(e);
	}

	}

	 @Test(priority = 3)
	public void addSchoolAdminAtUser() {

		try {

			Addschooladmin schoolAdmin = new Addschooladmin(driver);

			FileInputStream inputStream1 = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Addschooladmin.xlsx");

			System.out.println(inputStream1);
			
			Workbook workbook1 = new XSSFWorkbook(inputStream1);
			
			System.out.println(workbook1);

			Sheet sheet1 = workbook1.getSheet("Sheet1");
			
			System.out.println(sheet1);

			for (int i = 1; i < sheet1.getLastRowNum(); i++) {

				String firstName = sheet1.getRow(i).getCell(0).toString();

				System.out.println("School Admin First Name : " + firstName);

				String lastName = sheet1.getRow(i).getCell(1).toString();

				String userCode = sheet1.getRow(i).getCell(2).toString();

				String dob = sheet1.getRow(i).getCell(3).toString();

				String searchPlace = sheet1.getRow(i).getCell(4).toString();

				String city = sheet1.getRow(i).getCell(5).toString();

				String state = sheet1.getRow(i).getCell(6).toString();

				String country = sheet1.getRow(i).getCell(7).toString();
				
				System.out.println("School Admin country : " +country);

				String postalCode = sheet1.getRow(i).getCell(8).toString();

				schoolAdmin.addSchoolAdmin("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png", 
						
						firstName, lastName, userCode, "Bsc", dob, 
						
						searchPlace, city, state, country, postalCode);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	 @Test(priority = 4)
	public void addDistributionManagerAtUser() {

		try {

			Adddistributionmanager distributionManager = new Adddistributionmanager(driver);

			FileInputStream inputStream2 = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Adddistributionmanager.xlsx");

			Workbook workbook2 = new XSSFWorkbook(inputStream2);

			Sheet sheet2 = workbook2.getSheet("Sheet1");

			for (int i1 = 1; i1 < sheet2.getLastRowNum(); i1++) {

				String firstName1 = sheet2.getRow(i1).getCell(0).toString();

				System.out.println("Distribution Manager First Name : " + firstName1);

				String lastName1 = sheet2.getRow(i1).getCell(1).toString();

				String userCode1 = sheet2.getRow(i1).getCell(2).toString();

				String education = sheet2.getRow(i1).getCell(3).toString();

				String searchAddress = sheet2.getRow(i1).getCell(4).toString();

				String city1 = sheet2.getRow(i1).getCell(5).toString();

				String state1 = sheet2.getRow(i1).getCell(6).toString();

				String country1 = sheet2.getRow(i1).getCell(7).toString();

				String postalCode1 = sheet2.getRow(i1).getCell(8).toString();

				String dob1 = sheet2.getRow(i1).getCell(9).toString();

				distributionManager.addDistributionManager("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png",

						firstName1, lastName1, userCode1, education,

						dob1, searchAddress, city1, state1, country1, postalCode1);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	 @Test(priority = 5)
	public void addRouteAdminAtUser() {

		try {

			Addrouteadmin routeAdmin = new Addrouteadmin(driver);

			FileInputStream inputStream3 = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Addrouteadmin.xlsx");

			Workbook workbook3 = new XSSFWorkbook(inputStream3);

			Sheet sheet3 = workbook3.getSheet("Sheet1");

			for (int i1 = 1; i1 < sheet3.getLastRowNum(); i1++) {

				String firstName2 = sheet3.getRow(i1).getCell(0).toString();

				System.out.println("Route Admin First Name : " + firstName2);

				String lastName2 = sheet3.getRow(i1).getCell(1).toString();

				String userCode2 = sheet3.getRow(i1).getCell(2).toString();

				String education1 = sheet3.getRow(i1).getCell(3).toString();

				String searchAddress = sheet3.getRow(i1).getCell(4).toString();

				String city1 = sheet3.getRow(i1).getCell(5).toString();

				String state1 = sheet3.getRow(i1).getCell(6).toString();

				String country1 = sheet3.getRow(i1).getCell(7).toString();

				String postalCode1 = sheet3.getRow(i1).getCell(8).toString();

				String dob1 = sheet3.getRow(i1).getCell(9).toString();

				routeAdmin.addRouteAdmin("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png",

						firstName2, lastName2, userCode2, education1, dob1,

						searchAddress, city1, state1, country1, postalCode1);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	 @Test(priority = 6)
	public void addSchoolRelationshipManagerAtUser() {

		try {

			Addschoolrelationshipmanager relationshipManager = new Addschoolrelationshipmanager(driver);

			FileInputStream inputStream = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Addschoolrelationshipmanager.xlsx");

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheet("Sheet1");

			for (int i = 1; i < sheet.getLastRowNum(); i++) {

				String firstName2 = sheet.getRow(i).getCell(0).toString();

				System.out.println("Route Admin First Name : " + firstName2);

				String lastName2 = sheet.getRow(i).getCell(1).toString();

				String userCode2 = sheet.getRow(i).getCell(2).toString();

				String education1 = sheet.getRow(i).getCell(3).toString();

				String searchAddress = sheet.getRow(i).getCell(4).toString();

				String city1 = sheet.getRow(i).getCell(5).toString();

				String state1 = sheet.getRow(i).getCell(6).toString();

				String country1 = sheet.getRow(i).getCell(7).toString();

				String postalCode1 = sheet.getRow(i).getCell(8).toString();

				String dob1 = sheet.getRow(i).getCell(9).toString();

				relationshipManager.addSchoolRelationshipManager("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png",

						firstName2, lastName2, userCode2, education1, dob1,

						searchAddress, city1, state1, country1, postalCode1);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	 @Test(priority = 7)
	public void addFuelSupervisorAtUser() {

		try {

			Addfuelsupervisor fuelSupervisor = new Addfuelsupervisor(driver);
			
			FileInputStream inputStream5 = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Addfuelsupervisor.xlsx");

			Workbook workbook5 = new XSSFWorkbook(inputStream5);

			Sheet sheet5 = workbook5.getSheet("Sheet1");

			for (int i1 = 1; i1 < sheet5.getLastRowNum(); i1++) {

				String firstName2 = sheet5.getRow(i1).getCell(0).toString();

				System.out.println("Fuel Supervisor First Name : " + firstName2);

				String lastName2 = sheet5.getRow(i1).getCell(1).toString();

				String userCode2 = sheet5.getRow(i1).getCell(2).toString();

				String education1 = sheet5.getRow(i1).getCell(3).toString();

				String searchAddress = sheet5.getRow(i1).getCell(4).toString();

				String city1 = sheet5.getRow(i1).getCell(5).toString();

				String state1 = sheet5.getRow(i1).getCell(6).toString();

				String country1 = sheet5.getRow(i1).getCell(7).toString();

				String postalCode1 = sheet5.getRow(i1).getCell(8).toString();

				String dob1 = sheet5.getRow(i1).getCell(9).toString();

		fuelSupervisor.addFuelSupervisor("C:\\Users\\DELL\\OneDrive\\Pictures\\restapi.png",

			firstName2, lastName2, userCode2, education1, dob1,

				searchAddress, city1, state1, country1, postalCode1);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	/////////// Create new Vehicle ///////////

	@Test(priority = 8)
	public void addVehicleTest() {

		try {

			if (driver.getCurrentUrl() != null) {

				Addvehicle addVehicle = new Addvehicle(driver);

				FileInputStream inputStream = new FileInputStream(
						"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Addvehicle.xlsx");

				Workbook workbook = new XSSFWorkbook(inputStream);

				Sheet sheet = workbook.getSheetAt(0);

				for (int i = 1; i < sheet.getLastRowNum(); i++) {

					String vehicleMakeYear = sheet.getRow(i).getCell(0).toString();

					System.out.println("Vehicle Make Year : " + vehicleMakeYear);

					String vehicleType = sheet.getRow(i).getCell(8).toString();

					System.out.println("Vehicle Type : " + vehicleType);

					String engineSize = sheet.getRow(i).getCell(1).toString();

					System.out.println(engineSize);

					String driveTrain = sheet.getRow(i).getCell(2).toString();

					String fuelCapacity = sheet.getRow(i).getCell(3).toString();

					String vehicleNumberPlate = sheet.getRow(i).getCell(4).toString();

					String registrationYear = sheet.getRow(i).getCell(5).toString();

					String vehicleCode = sheet.getRow(i).getCell(6).toString();

					String vehicleColor = sheet.getRow(i).getCell(7).toString();

					addVehicle.addVehicle(vehicleType, vehicleMakeYear, engineSize, driveTrain, fuelCapacity,
							vehicleNumberPlate,

							registrationYear, "19-05-2023", vehicleCode, vehicleColor);

					System.out.println("New Vehicle added");

				}
				/////// Verify url ///////
				String url = driver.getCurrentUrl();

				if (url.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/vehiclemanagement")) {

					System.out.println("Vehicle page url is verified : " + url);
				}

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	////////// Create Food Menu ////////////

	@Test(priority = 9)
	public void testFoodMenu() {

		try {

			if (driver.getCurrentUrl() != null) {

				Foodmenu foodMenu = new Foodmenu(driver);

				FileInputStream inputStream = new FileInputStream(
						"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Foodmenu.xlsx");

				Workbook workbook = new XSSFWorkbook(inputStream);

				Sheet sheet = workbook.getSheet("Sheet1");

				for (int i = 1; i < sheet.getLastRowNum(); i++) {

					String dateCell = sheet.getRow(i).getCell(0).toString();

					System.out.println("Menu Date : " + dateCell);

					String breakfastCell = sheet.getRow(i).getCell(1).toString();

					System.out.println("Menu Breakfast : " + breakfastCell);

					String lunchCell = sheet.getRow(i).getCell(2).toString();

					System.out.println("Menu Lunch : " + lunchCell);

					foodMenu.addFoodMenu(dateCell, breakfastCell, lunchCell);

					System.out.println("Food Menu added");
				}

				workbook.close();

				inputStream.close();

				/////// Verify url ///////
				String foodMenuUrl = driver.getCurrentUrl();

				if (foodMenuUrl.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/Menumanagement")) {

					System.out.println("Food page url is verified : " + foodMenuUrl);
				}

			}

		} catch (Exception e) {

			e.getStackTrace();

			System.out.println(e);
		}

	}

	////////// Create Route //////////

	@Test(priority = 10)
	public void testAddRoute() throws IOException, InterruptedException {

		if (!(driver.getCurrentUrl() == null)) {

			Addroute addRoute = new Addroute(driver);

			FileInputStream inputStream = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Addroute.xlsx");

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheet("Sheet1");

			for (int i = 1; i < sheet.getLastRowNum(); i++) {

				String routeName = sheet.getRow(i).getCell(0).toString();

				System.out.println("Route Name : " + routeName);

				String routeCode = sheet.getRow(i).getCell(1).toString();

				System.out.println("Route Code : " + routeCode);

				addRoute.addRoute(routeName, routeCode);

				System.out.println("New Route added");

			}

			//////// Verify url ///////
			String routeUrl = driver.getCurrentUrl();

			if (routeUrl.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/route")) {

				System.out.println("Route page url is verified : " + routeUrl);
			}
		}

	}

	//////// Create Daily Request ////////

	@Test(priority = 11)
	public void testDailyRequest() {

		try {

			if (!(driver.getCurrentUrl() == null)) {

				Dailyrequest dailyRequest = new Dailyrequest(driver);

				FileInputStream inputStream = new FileInputStream(
						"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\Dailyrequest.xlsx");

				Workbook workbook = new XSSFWorkbook(inputStream);

				Sheet sheet = workbook.getSheet("Sheet1");

				for (int i = 1; i < sheet.getLastRowNum(); i++) {

					String startTime = sheet.getRow(i).getCell(0).toString();

					System.out.println("Start Time : " + startTime);

					String endTime = sheet.getRow(i).getCell(1).toString();

					System.out.println("End Time : " + endTime);

					dailyRequest.addDailyRequest("1", startTime, endTime);

					System.out.println("Daily request added");

				}

				/////// Verify url ///////
				String url = driver.getCurrentUrl();

				if (url.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/deliveryRequest")) {

					System.out.println("Daily request page url is verified : " + url);
				}

			}

		} catch (Exception e) {

			e.getStackTrace();
			
			System.out.println(e);
		}

	}

	////////// Create Vehicle Expense //////////

	@Test(priority = 12)
	public void testAddVehicleExpense() {

		try {

			if (driver.getCurrentUrl() != null) {

				Addvehicleexpense addVehicleExpense = new Addvehicleexpense(driver);

				FileInputStream inputStream = new FileInputStream(
						"C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\src\\main\\resources\\AddVehiclexpense.xlsx");

				Workbook workbook = new XSSFWorkbook(inputStream);

				Sheet sheet = workbook.getSheet("Sheet1");

				for (int i = 1; i < sheet.getLastRowNum(); i++) {

					String noOfUnits = sheet.getRow(i).getCell(0).toString();

					System.out.println("No of Units : " + noOfUnits);

					String perUnitCost = sheet.getRow(i).getCell(1).toString();

					System.out.println("Per unit Cost : " + perUnitCost);

					String totalServiceCost = sheet.getRow(i).getCell(2).toString();

					String expenseDetails = sheet.getRow(i).getCell(3).toString();

					String dateOfExpense = sheet.getRow(i).getCell(4).toString();

					addVehicleExpense.addVehicleExpense(noOfUnits, perUnitCost, totalServiceCost,

							expenseDetails, dateOfExpense);

					System.out.println("Vehicle Expense added");
				}

				/////// Verify url ///////
				String vehicleExpenseUrl = driver.getCurrentUrl();

				if (vehicleExpenseUrl.equalsIgnoreCase("http://20.235.104.54:8080/PickdropFleet/Vehicleexpensetable")) {

					System.out.println("Vehicle Expense page url is verified : " + vehicleExpenseUrl);
				}

			}

		} catch (Exception e) {

			e.getStackTrace();

			System.out.println(e);
		}

	}

	@Test(priority = 13)
	public void kitchenAdminLogout() {

		Logoutpage logoutPage = new Logoutpage(driver);

		logoutPage.clickUserInfo();

	}

	@Test(priority = 14)
	public void testImportPage() {

		try {

			Importpage importPage = new Importpage(driver);

			importPage.addImportPage();

			System.out.println("Successfully imported");

		} catch (Exception e) {

			e.getStackTrace();

			System.out.println(e);
		}

	}

	private static void setZoomLevel(WebDriver driver, CharSequence... keys) {

		WebElement bodyElement = driver.findElement(By.tagName("body"));

		Actions actions = new Actions(driver);

		actions.moveToElement(bodyElement).sendKeys(keys).perform();

	}

}
