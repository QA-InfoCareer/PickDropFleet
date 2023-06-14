package com.pickdropfleet.kitchenadminpages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Importpage {
	
	WebDriver driver;
	
	String filePath = "C:\\Users\\DELL\\Downloads\\menu.xlsx";
	
	// it clicks dashboard
	By Dashboard = By.xpath("//span[@aria-label='menu-unfold']//*[name()='svg']");

	// it clicks Import on dashboard
	By Import = By.xpath("//h6[text() = 'Import']"); 
	
	// it clicks Select excel
	By Selectexcel = By.xpath("//em[normalize-space()='Select Excel']");
	
	// it selects value
	By SelectExcelvalue = By.xpath("//li[text() = 'FoodMenu']");
	
	// it clicks and download sample excel
	By Downloadsample = By.xpath("//div[@class = 'samplexcel'] //span[text() = 'Sample FoodMenu Excel']");
	
	// it selects Imported file from PC
	By Importsample = By.xpath("//div[@class = 'App'] //label[text() = '+ Import FoodMenu Excel']");
	
	// it clicks Savebtn
	By Savebtn = By.xpath("//button[text() = 'Save']");
	
	
	public Importpage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void addImportPage() throws InvalidFormatException, IOException {
		
		driver.findElement(Dashboard).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Import).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Selectexcel).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(SelectExcelvalue).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Downloadsample).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(Savebtn).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		
	}
	
}
