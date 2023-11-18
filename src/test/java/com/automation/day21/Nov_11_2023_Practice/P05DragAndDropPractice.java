package com.automation.day21.Nov_11_2023_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class P05DragAndDropPractice {

	public WebDriver driver;
	public ChromeOptions options;
	public Actions action;

	@Test
	public void dragAndDrop() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/droppable/");

		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("the total number of frames are: " + totalFrames.size());

		driver.switchTo().frame(0);

		action = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));

		action.dragAndDrop(source, destination).build().perform();

	}
}
