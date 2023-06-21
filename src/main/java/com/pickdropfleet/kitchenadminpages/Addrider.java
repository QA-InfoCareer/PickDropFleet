package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class Addrider {

	private WebDriver driver;

	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement dashboardIcon; // it selects dashsboars icon

	By clickUser = By.xpath("//h6[text() = 'User']");
	
	By Adduser = By.xpath("//a[text() = '+ Add User']");

	By imageUpload = By.xpath("//input[@type='file']"); // it uploads image

	By Firstname = By.id("user_FirstName"); // enter firstname

	By Lastname = By.id("user_LastName"); // enter lastname

	By Usercode = By.id("user_Code"); // enter usercode

	By Role = By.cssSelector("div.MuiBox-root.css-hboir5 main.MuiBox-root.css-vognfw:nth-child(3) div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation0.MuiCard-root.css-12nms3t:nth-child(3) div.MuiCardContent-root.css-3ofp2w div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3.css-1h77wgb:nth-child(2) div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-md-4.css-11xjpbv:nth-child(4) div.css-l5c1s3 div.MuiInputBase-root.MuiOutlinedInput-root.MuiInputBase-colorPrimary.css-59zgpl:nth-child(2) > div.MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-1tbimj1"); // it clicks role

	By Rolevalue = By.xpath("//li[text()='Driver']"); // it selects role value

	By Schoolname = By.cssSelector("div:nth-child(5) div:nth-child(1) div:nth-child(2) div:nth-child(1)");
	
	By SchoolNamevalue = By.xpath("//li[text() = 'HBOA School']");

	By Mobileno = By.id("user_Mobile"); // enter mobile number

	By dob = By.id("user_Dob"); // enter dob

	By Gender = By.id("user_Gender"); // it clicks gender

	By Gendervalue = By.xpath("//li[text() = 'Male']"); // it selects gender value

	By Bloodgroup = By.xpath("//em[normalize-space()='Select Blood Group']"); // it clicks bloodgroup

	By Bloodgroupvalue = By.xpath("//li[@data-value='5']"); // it selects blood group value

	By Maritalstatus = By.id("user_Maritalstatus"); // it clicks marital status

	By Maritalstatusvalue = By.xpath("//li[text() ='Unmarried']");

	By email = By.id("user_Email"); // enter email

	By Aadharnumber = By.id("user_Aadhar"); // enter aadhar

	By Pannumber = By.id("user_Pan"); // enter pan

	By Education = By.id("user_Education"); // enter education

	By Locationaddress = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]"); // it clicks location icon

	By Searchplaces = By.xpath("//input[@placeholder = 'Search Places ...']"); // enter address

	By Saveaddress = By.xpath("(//button[text() = 'Save'])[2]"); // it saves address

	@FindBy(xpath = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/form[1]/div[2]/div[17]/div[1]/div[2]/input[1]")
	WebElement Country; // enter country

	@FindBy(xpath = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/form[1]/div[2]/div[16]/div[1]/div[2]/input[1]")
	WebElement State;

	@FindBy(id = "user_City")
	WebElement City;

	@FindBy(id = "user_Postal")
	WebElement Postalcode;

	By Savebtn = By.xpath("//button[text() = 'Save']");

	By Okbtn = By.xpath("//button[text() = 'OK']");

	@FindBy(xpath = "//div[text() = 'EmailId already exist']")
	WebElement emailValidation;

	///////////////// Daily Request /////////////

	@FindBy(xpath = "//h6[text()='Daily-Requests']")
	WebElement Dailyrequest; // it clicks daily request on dashboard

	@FindBy(xpath = "//input[@type = 'date']")
	WebElement Deliverydate; // it clicks delivery date

	@FindBy(xpath = "//button[text() = 'Search']")
	WebElement Search; // it clicks search button

	@FindBy(css = "div[id='cell-8-6465c52e7b02b55b01a84bcf'] button[type='button']")
	WebElement View; // it clicks view button

	@FindBy(xpath = "//input[@id = 'startTime']")
	WebElement Starttime; // enter start time

	@FindBy(xpath = "//input[@id = 'endTime']")
	WebElement Endtime; // enter end time

	@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
	WebElement Vehiclename; // it clicks vehicle name

	@FindBy(xpath = "//li[text() = 'SUV23456']")
	WebElement Vehiclenamevalue; // it selects Vehicle name value

	@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > main:nth-child(3) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(8) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
	WebElement Deliveredby; // it clicks Delivered By

	@FindBy(xpath = "//li[text() = 'Imran']")
	WebElement Deliveredbyvalue; // it clicks Delivered by value

	@FindBy(xpath = "//button[text() = 'Save']")
	WebElement Savebtn2;

	@FindBy(xpath = "//button[text() = 'OK']")
	WebElement Okbtn2;

	@FindBy(xpath = "//button[text() = 'Back']")
	WebElement Backbtn;

	//////// Validation Locators /////////
	public WebElement getEmailErrorMessage() {

		return driver.findElement(By.xpath("//div[text() = 'Please Enter a Valid Email Id']"));
	}

	public Addrider(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public String addRider(String uploadImage, String firstName, String lastName, String userCode, String mobileNo,
			String Dob,

			String emailId, String aadharNumber, String panNumber, String education, String searchPlaces,
			String country, String state,

			String city, String postalCode) throws InterruptedException, IOException {

		Screenshot screenshot = new Screenshot(driver);

		/////// Generate random Email id ///////
		String randomEmail = generateRandomEmail();

		////////// aadhar number auto generate 12 digits //////////
		Random random = new Random();

		// Generate a random 12-digit Aadhaar number
		String aadhaarNum = "";

		for (int i = 0; i < 12; i++) {

			int digit = random.nextInt(10); // Generate a random digit between 0 and 9

			aadhaarNum = aadhaarNum.concat(String.valueOf(digit)); // Concatenate the digit to the Aadhaar number

		}

		System.out.println("Aadhaar Number : " + aadhaarNum);

		/////// pan number auto generate 10 digits ///////////
		Random random2 = new Random();

		String panNum = "";

		for (int i = 0; i < 10; i++) {

			int digit = random2.nextInt(10); // // Generate a random digit between 0 and 9

			panNum = panNum.concat(String.valueOf(digit));

		}

		System.out.println("Pan Number : " + panNum);

		/////// mobile number auto generate 10 digits ///////////
		Random random3 = new Random();

		// Generate a random 10-digit mobile number
		String mobileNum = "9"; // Start with 9 to ensure it's a mobile number

		for (int i = 0; i < 9; i++) {

			int digit = random3.nextInt(10); // Generate a random digit between 0 and 9

			mobileNum += digit; // Concatenate the digit to the mobile number
		}

		// Print the generated mobile number
		System.out.println("Random mobile number: " + mobileNum);

		///////////// Create Driver /////////////

		Utils utils = new Utils(driver);

		utils.clickVisibilityOfElementLocated(driver, clickUser, 10);

		utils.clickVisibilityOfElementLocated(driver, Adduser, 10);

		utils.sendKeysWithExplicitWait(driver, imageUpload, uploadImage, 10);

		utils.sendKeysWithExplicitWait(driver, Firstname, firstName, 10);

		utils.sendKeysWithExplicitWait(driver, Lastname, lastName, 10);

		utils.sendKeysWithExplicitWait(driver, Usercode, userCode, 10);

		utils.clickVisibilityOfElementLocated(driver, Role, 10);

		List<WebElement> driverBike = driver.findElements(By.tagName("li"));

		if (driverBike.size() > 0) {

			driverBike.get(2).click(); // it selects Driver
		}

		utils.setImplicitWait(10);

		utils.sendKeysWithExplicitWait(driver, Mobileno, mobileNum, 10); // 10 digit auto generate

		utils.setImplicitWait(10);

		utils.sendKeysWithExplicitWait(driver, dob, Dob, 10);

		utils.clickVisibilityOfElementLocated(driver, Gender, 10);

		utils.clickVisibilityOfElementLocated(driver, Gendervalue, 10);

		utils.clickVisibilityOfElementLocated(driver, Bloodgroup, 10);

		utils.clickVisibilityOfElementLocated(driver, Bloodgroupvalue, 10);

		utils.clickVisibilityOfElementLocated(driver, Maritalstatus, 10);

		utils.clickVisibilityOfElementLocated(driver, Maritalstatusvalue, 10);

		utils.sendKeysWithExplicitWait(driver, email, randomEmail, 10);

		utils.sendKeysWithExplicitWait(driver, Aadharnumber, aadhaarNum, 10); // 12 digits

		utils.sendKeysWithExplicitWait(driver, Pannumber, panNum, 10); // 10 digits

		utils.sendKeysWithExplicitWait(driver, Education, education, 10);

		utils.setImplicitWait(10);

		utils.clickVisibilityOfElementLocated(driver, Locationaddress, 10);

		utils.setImplicitWait(10);

		utils.sendKeysWithExplicitWait(driver, Searchplaces, searchPlaces, 10);

		utils.clickVisibilityOfElementLocated(driver, Saveaddress, 10);

		String autoFillCity = (City).getAttribute("value");
		System.out.println("Auto Fill City : " + autoFillCity);
		String autoFillState = (State).getAttribute("value");
		String autoFillCountry = (Country).getAttribute("value");
		String autoFillPostalCode = (Postalcode).getAttribute("value");

		if (autoFillCity.equals("Chennai") && autoFillState.equals("Tamilnadu") &&

				autoFillCountry.equals("India") && autoFillPostalCode.equals("600028")) {

			System.out.println("Auto-filled values are correct.");

		} else {

			System.out.println("Auto-filled values are incorrect. Making changes...");

			(City).clear();
			utils.setImplicitWait(600);
			(City).sendKeys(city);
			utils.setImplicitWait(600);
			(State).clear();
			utils.setImplicitWait(600);
			(State).sendKeys(state);
			utils.setImplicitWait(600);
			(Country).clear();
			utils.setImplicitWait(600);
			(Country).sendKeys(country);
			utils.setImplicitWait(600);
			(Postalcode).clear();
			utils.setImplicitWait(600);
			(Postalcode).sendKeys(postalCode);

		}
		
		screenshot.takeScreenshot();

		utils.setImplicitWait(10);

		utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);

		utils.setImplicitWait(10);

		screenshot.takeScreenshot();

		utils.setImplicitWait(10);

		utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);

		System.out.println("Rider is created");

		utils.setImplicitWait(1000);

		return "New rider Added";

	}

         /////////// email validation ////////////
	public void emailIdValidation() {

		if (emailValidation.isDisplayed() == true) {

			System.out.println("Please enter a valid email");

			driver.quit();

		} else {

			System.out.println("Valid email id");
		}
	}

	public void dailyRequest(String startTime, String endTime, String deliveryDate) throws InterruptedException {

		LocalDate currentDate = LocalDate.now();

		// Format the date as "dd-MM-yyyy"
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String formattedDate = currentDate.format(formatter);

		System.out.println(formattedDate);

		Dailyrequest.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		Deliverydate.sendKeys(formattedDate);

		Search.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		View.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		Starttime.sendKeys(startTime);

		Endtime.sendKeys(endTime);

		Vehiclename.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		Vehiclenamevalue.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		Deliveredby.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		Deliveredbyvalue.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(Savebtn2)).click();

		Thread.sleep(3000);

		Okbtn2.click();

		Thread.sleep(1000);

	}

	public static String generateRandomEmail() {

		long timestamp = System.currentTimeMillis();
		
		System.out.println(timestamp);

		int randomNumber = new Random().nextInt(10000);

		return "driver" + randomNumber + "@gmail.com";

	}

}
