package com.config.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Configurationprop {
	
	public static Properties property;
	
	public void initializeProperties() throws FileNotFoundException {
		
		property = new Properties();
		
		try {
			
			FileInputStream stream = new FileInputStream("config.properties");
			
			property.load(stream);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println(e);
		}
	}
	
	public String getProperty(String key) {
        
		return property.getProperty(key);
    }
	
	
	
}
