package com.automation.day21.Nov_11_2023_ScreenRecording;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Recording_LoginTestPractice {

	public WebDriver driver;

	@Test
	public void Recording_TN() throws Exception {

		ScreenRecorderUtil.startRecord("Recording_TN");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

		ScreenRecorderUtil.stopRecord();

	}
}
