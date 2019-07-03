package com.fk.testcases;

import org.openqa.selenium.WebDriver;

import com.fk.utilities.Keywords;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Base {
	public static WebDriver driver=null;
	@Before
	public static void openBrowser() {
		Keywords k=new Keywords(driver);
		k.openBrowser("chrome");
		k.openURL("https://www.fb.com");
		
	}
	@After
	public static void closeBrowser() {
		driver.close();
	}

	
}
