package com.pickdropflett.ss;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Randomemail {

	WebDriver driver;
	
	 public static String generateRandomEmail() {
	        
		 String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
	     
		 StringBuilder stringBuilder = new StringBuilder();

	        Random random = new Random();
	        
	        int length = 8; // Set the desired length of the random email prefix

	        while (stringBuilder.length() < length) {
	            int index = random.nextInt(characters.length());
	            char randomChar = characters.charAt(index);
	            stringBuilder.append(randomChar);
	        }

	        String domain = "example.com"; // Set the desired domain for the email ID

	        return stringBuilder.toString() + "@" + domain;
	    }	
	
	 public static void main(String[] args) {
	        
		 String randomEmail = generateRandomEmail();
	     
		 System.out.println("Random Email: " + randomEmail);
	   
	 }
	 
	 public Randomemail(WebDriver driver) {
		 
		 this.driver = driver;
		 
		 PageFactory.initElements(driver, this);
	 }
	
	 
	
}
