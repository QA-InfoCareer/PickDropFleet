package com.pickdropflett.ss;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Screenshots {
	
	WebDriver driver;
	
	public Screenshots(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

   //////////Taking Screenshots before submitting data //////////
    
     public void takeScreenshot() throws IOException {
    	 
    	 Date currentDate = new Date();
 		
   	  String screenshotWithDate = currentDate.toString().replace(":", "-");
   	  
   	  System.out.println(screenshotWithDate);
   	  
   	  String currentUrl = driver.getCurrentUrl();
   	  
   	  System.out.println(currentUrl);
   	  
   	  JavascriptExecutor js = (JavascriptExecutor) driver;
   	  
   	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
   	  
   	  Screenshot screenshot = new AShot().takeScreenshot(driver);
   	  
   	boolean saveImage = ImageIO.write(screenshot.getImage(), "PNG", new File("C:\\Users\\DELL\\eclipse-workspace\\PickdropFleet\\test-output " +screenshotWithDate.trim()+".png"));
    	 
      System.out.println("Successful : "+saveImage);
    	 
     }
	  
	
	
}
