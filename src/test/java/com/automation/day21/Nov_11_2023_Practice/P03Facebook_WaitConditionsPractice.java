package com.automation.day21.Nov_11_2023_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class P03Facebook_WaitConditionsPractice {

	public WebDriver driver;
	public WebDriverWait wait;

	@Test
	public void facebook_WebDriverWait() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.linkText("Create new account")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname"))).sendKeys("Selenium");
	}
}