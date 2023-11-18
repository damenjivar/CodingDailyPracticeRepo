package com.automation.day22.Nov_12_2023Practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class P2ScreenshotsPractice {

	public WebDriver driver;

	@Test
	public void tnScreenShot() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("iPhone")).click();
		WebElement logo = driver
				.findElement(By.xpath("//div[@class = 'col-sm-8']/child::ul[1]/child::li[1]/child::a[1]"));
		File source = logo.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				System.getProperty("user.dir") + "\\test-output\\Screenshots\\iPhoneScreenShot.png");
		FileHandler.copy(source, destination);
	}
}
