package com.automation.day21.Nov_11_2023_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class P04DraggablePractice {

	public WebDriver driver;
	public Actions action;
	public ChromeOptions options;

	@Test
	public void draggable() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("the total number of frames are: " + totalFrames.size());

		driver.switchTo().frame(0);

		action = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		action.dragAndDropBy(source, 100, 200).build().perform();
	}
}
