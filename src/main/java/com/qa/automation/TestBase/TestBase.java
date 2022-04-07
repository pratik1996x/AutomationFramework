package com.qa.automation.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		FileInputStream file;
		try {
		file=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/automation/Config/config.properties");
		prop=new Properties();
		prop.load(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public void intialization() {
		String browser=prop.getProperty("browser");
		
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	}
}
