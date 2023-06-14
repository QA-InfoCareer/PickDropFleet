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

public class Addfuelsupervisor {

	private WebDriver driver;

	@FindBy(xpath = "//button[@id = 'menu_slider']")
	WebElement dashboardIcon; // it selects dashsboars icon

	@FindBy(xpath = "//h6[text() = 'User']")
	WebElement clickUser; // it selects user in dashboard

	@FindBy(xpath = "//a[text() = '+ Add User']")
	WebElement Adduser;

	@FindBy(xpath = "//input[@type='file']")
	WebElement imageUpload; // it uploads image

	@FindBy(id = "user_FirstName")
	WebElement Firstname; // enter firstname

	@FindBy(id = "user_LastName")
	WebElement Lastname; // enter lastname

	@FindBy(id = "user_Code")
	WebElement Usercode; // enter usercode

	@FindBy(css = "div.MuiBox-root.css-hboir5 main.MuiBox-root.css-vognfw:nth-child(3) div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation0.MuiCard-root.css-12nms3t:nth-child(3) div.MuiCardContent-root.css-3ofp2w div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3.css-1h77wgb:nth-child(2) div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-md-4.css-11xjpbv:nth-child(4) div.css-l5c1s3 div.MuiInputBase-root.MuiOutlinedInput-root.MuiInputBase-colorPrimary.css-59zgpl:nth-child(2) > div.MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-1tbimj1")
	WebElement Role; // it clicks role

	@FindBy(xpath = "//li[text()='School Admin']")
	WebElement Rolevalue; // it selects role value

	@FindBy(css = "div:nth-child(5) div:nth-child(1) div:nth-child(2) div:nth-child(1)")
	WebElement Schoolname;

	@FindBy(xpath = "//li[text() = 'HBOA School']")
	WebElement SchoolNamevalue;

	@FindBy(id = "user_Mobile")
	WebElement Mobileno; // enter mobile number

	@FindBy(id = "user_Dob")
	WebElement dob; // enter dob

	@FindBy(id = "user_Gender")
	WebElement Gender; // it clicks gender

	@FindBy(xpath = "//li[text() = 'Male']")
	WebElement Gendervalue; // it selects gender value

	@FindBy(xpath = "//em[normalize-space()='Select Blood Group']")
	WebElement Bloodgroup; // it clicks bloodgroup

	@FindBy(xpath = "//li[@data-value='5']")
	WebElement Bloodgroupvalue; // it selects blood group value

	@FindBy(id = "user_Maritalstatus")
	WebElement Maritalstatus; // it clicks marital status

	@FindBy(xpath = "//li[text() ='Unmarried']")
	WebElement Maritalstatusvalue;

	@FindBy(id = "user_Email")
	WebElement email; // enter email

	@FindBy(id = "user_Aadhar")
	WebElement Aadharnumber; // enter aadhar

	@FindBy(id = "user_Pan")
	WebElement Pannumber; // enter pan

	@FindBy(id = "user_Education")
	WebElement Education; // enter education

	@FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]")
	WebElement Locationaddress; // it clicks location icon

	@FindBy(xpath = "//input[@placeholder = 'Search Places ...']")
	WebElement Searchplaces; // enter address

	@FindBy(xpath = "(//button[text() = 'Save'])[2]")
	WebElement Saveaddress; // it saves address

	@FindBy(xpath = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/form[1]/div[2]/div[17]/div[1]/div[2]/input[1]")
	WebElement Country; // enter country

	@FindBy(xpath = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/form[1]/div[2]/div[16]/div[1]/div[2]/input[1]")
	WebElement State;

	@FindBy(id = "user_City")
	WebElement City;

	@FindBy(id = "user_Postal")
	WebElement Postalcode;

	@FindBy(xpath = "//button[text() = 'Save']")
	WebElement Savebtn;

	@FindBy(xpath = "//button[text() = 'OK']")
	WebElement Okbtn;

	@FindBy(xpath = "//div[text() = 'EmailId already exist']")
	WebElement emailValidation;

	public Addfuelsupervisor(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

///////// Create Fuel Supervisor //////////

	public String addFuelSupervisor(String uploadImage, String firstName, String lastName,

			String userCode, String education, String Dob, String searchPlaces, String city,

			String state, String country, String postalCode) throws IOException {

		Screenshot screenshot = new Screenshot(driver);

		String randomEmail5 = generateRandomEmail5();

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

		utils.clickElementWithWait(driver, clickUser);

		utils.clickElementWithWait(driver, Adduser);

		utils.setImplicitWait(10);

		imageUpload.sendKeys(uploadImage);

		utils.setImplicitWait(10);

		String fuelFName = "Mahendra";

		Firstname.sendKeys(fuelFName);

		utils.setImplicitWait(10);

		String fuelCode = "Fuel Super - 02";

		Usercode.sendKeys(fuelCode);

		utils.setImplicitWait(10);

		utils.clickElementWithWait(driver, Role);

		List<WebElement> fuelSupervisor = driver.findElements(By.tagName("li"));

		if (fuelSupervisor.size() > 0) {

			fuelSupervisor.get(7).click();
		}

		Mobileno.sendKeys(mobileNum); // 10 digit auto generate

		utils.setImplicitWait(10);

		dob.sendKeys(Dob);

		utils.setImplicitWait(10);

		utils.clickElementWithWait(driver, Gender);

		utils.clickElementWithWait(driver, Gendervalue);

		utils.clickElementWithWait(driver, Bloodgroup);

		utils.clickElementWithWait(driver, Bloodgroupvalue);

		utils.clickElementWithWait(driver, Maritalstatus);

		utils.clickElementWithWait(driver, Maritalstatusvalue);

		email.sendKeys(randomEmail5);

		utils.setImplicitWait(10);

		Aadharnumber.sendKeys(aadhaarNum); // 12 digits

		utils.setImplicitWait(10);

		Pannumber.sendKeys(panNum); // 10 digits

		utils.setImplicitWait(10);

		Education.sendKeys(education);

		utils.setImplicitWait(10);

		utils.clickElementWithWait(driver, Locationaddress);

		utils.setImplicitWait(10);

		Searchplaces.sendKeys(searchPlaces);

		utils.clickElementWithWait(driver, Saveaddress);

		String autoFillCity5 = City.getAttribute("value");
		System.out.println("Auto Fill City : " + autoFillCity5);
		String autoFillState5 = State.getAttribute("value");
		String autoFillCountry5 = Country.getAttribute("value");
		String autoFillPostalCode5 = Postalcode.getAttribute("value");

		if (autoFillCity5.equals("Chennai") && autoFillState5.equals("Tamilnadu") &&

				autoFillCountry5.equals("India") && autoFillPostalCode5.equals("600028")) {

			System.out.println("Auto-filled values are correct.");

		} else {

			System.out.println("Auto-filled values are incorrect. Making changes...");

			City.clear();
			City.sendKeys("Chennai");
			State.clear();
			utils.setImplicitWait(1000);
			State.sendKeys("Tamilnadu");
			utils.setImplicitWait(1000);
			Country.clear();
			Country.sendKeys("India");
			Postalcode.clear();
			Postalcode.sendKeys("600028");

		}

		utils.setImplicitWait(10);

		screenshot.takeScreenshot();

		utils.setImplicitWait(10);

		utils.clickElementWithWait(driver, Savebtn);

		utils.setImplicitWait(10);

		screenshot.takeScreenshot();

		utils.setImplicitWait(10);

		utils.clickElementWithWait(driver, Okbtn);

		return "Fuel Supervisor added";
	}

	public static String generateRandomEmail5() {

		long timestamp = System.currentTimeMillis();

		int randomNumber = new Random().nextInt(100000);

		return "fuelsupervisor" + randomNumber + "@gmail.com";

	}

}
