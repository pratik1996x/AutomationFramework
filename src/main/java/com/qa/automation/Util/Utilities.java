package com.qa.automation.Util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.TestBase.TestBase;

public class Utilities extends TestBase{

	public String takeScreenshot(String name) {
		String path=System.getProperty("user.dir")+"/screenshots/"+name+System.currentTimeMillis()+".png";
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public WebElement explicitWait(WebElement element,int durationInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement we = wait.until(ExpectedConditions.visibilityOf(element));
		return we;
	}
	
	public WebElement fluentWait(WebElement element) {
		final WebElement el = element;
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(0))
				.pollingEvery(Duration.ofSeconds(0))
				.ignoring(NoSuchElementException.class);
		WebElement ele=wait.until(new Function<WebDriver,WebElement>()
		{
			public WebElement apply(WebDriver driver) {
				return el;
			}
		}
				);
		return ele;		
	}
	
	public static void hoverElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public static void dragAndDrop(WebElement dragable,WebElement dropable) {
		Actions action=new Actions(driver);
		action.clickAndHold(dragable).moveToElement(dropable).release().build().perform();
	}
	
	public static void scrollTo(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public static void highlightElement(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'",element);
	}
}
