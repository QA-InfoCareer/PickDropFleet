package com.pickdropfleet.kitchenadminpages;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pickdropfleet.utils.Utils;
import com.pickdropflett.ss.Screenshot;

public class Adddistributionmanager {

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
	
	public Adddistributionmanager(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	

	////////// Create Distribution Manager //////////

	public String addDistributionManager(String uploadImage, String firstName, String lastName,

			String userCode, String education, String Dob, String searchPlaces, String city,

			String state, String country, String postalCode) throws IOException {

		Screenshot screenshot = new Screenshot(driver);

		String randomEmail2 = generateRandomEmail2();

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

		Utils utils = new Utils(driver);

		utils.clickVisibilityOfElementLocated(driver, clickUser, 10);

		utils.clickVisibilityOfElementLocated(driver, Adduser, 10);

		utils.sendKeysWithExplicitWait(driver, imageUpload, uploadImage, 10);

		utils.sendKeysWithExplicitWait(driver, Firstname, firstName, 10);
		
		utils.sendKeysWithExplicitWait(driver, Lastname, lastName, 10);

		utils.sendKeysWithExplicitWait(driver, Usercode, userCode, 10);
		
		utils.clickVisibilityOfElementLocated(driver, Role, 10);

		List<WebElement> distribution = driver.findElements(By.tagName("li"));

		if (distribution.size() > 0) {

			distribution.get(4).click();
		}

		utils.sendKeysWithExplicitWait(driver, Mobileno, mobileNum, 10); // 10 digit auto generate

		utils.sendKeysWithExplicitWait(driver, dob, Dob, 10);

		utils.clickVisibilityOfElementLocated(driver, Gender, 10);

		utils.clickVisibilityOfElementLocated(driver, Gendervalue, 10);

		utils.clickVisibilityOfElementLocated(driver, Bloodgroup, 10);

		utils.clickVisibilityOfElementLocated(driver, Bloodgroupvalue, 10);

		utils.clickVisibilityOfElementLocated(driver, Maritalstatus, 10);

		utils.clickVisibilityOfElementLocated(driver, Maritalstatusvalue, 10);

		utils.sendKeysWithExplicitWait(driver, email, randomEmail2, 10);

		utils.sendKeysWithExplicitWait(driver, Aadharnumber, aadhaarNum, 10); // 12 digits

		utils.sendKeysWithExplicitWait(driver, Pannumber, panNum, 10); // 10 digits

		utils.sendKeysWithExplicitWait(driver, Education, education, 10);

		utils.clickVisibilityOfElementLocated(driver, Locationaddress, 10);

		utils.sendKeysWithExplicitWait(driver, Searchplaces, searchPlaces, 10);

		utils.clickVisibilityOfElementLocated(driver, Saveaddress, 10);

		String autoFillCity2 = (City).getAttribute("value");
		System.out.println("Auto Fill City : " + autoFillCity2);
		String autoFillState2 = (State).getAttribute("value");
		String autoFillCountry2 = (Country).getAttribute("value");
		String autoFillPostalCode2 = (Postalcode).getAttribute("value");

		if (autoFillCity2.equals("Chennai") && autoFillState2.equals("Tamilnadu") &&

				autoFillCountry2.equals("India") && autoFillPostalCode2.equals("600028")) {

			System.out.println("Auto-filled values are correct.");

		} else {

			System.out.println("Auto-filled values are incorrect. Making changes...");

			(City).clear();
			(City).sendKeys("Chennai");
			(State).clear();
			(State).sendKeys("Tamilnadu");
			(Country).clear();
			(Country).sendKeys("India");
			(Postalcode).clear();
			(Postalcode).sendKeys("600028");

		}

		utils.setImplicitWait(10);

		screenshot.takeScreenshot();

		utils.setImplicitWait(10);

		utils.clickVisibilityOfElementLocated(driver, Savebtn, 10);

		utils.setImplicitWait(10);

		screenshot.takeScreenshot();

		utils.setImplicitWait(10);

		utils.clickVisibilityOfElementLocated(driver, Okbtn, 10);

		return "New Distribution Manager added";
	}
	
	
	
	public static String generateRandomEmail2() {

		long timestamp = System.currentTimeMillis();
		
		System.out.println(timestamp);

		int randomNumber = new Random().nextInt(100000);

		return "distributionmanager" + randomNumber + "@gmail.com";

	}
	
	
	
	
	
	
	
	
	
	
	
}
