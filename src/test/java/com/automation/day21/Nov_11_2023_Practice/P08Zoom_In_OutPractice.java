package com.automation.day21.Nov_11_2023_Practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P08Zoom_In_OutPractice {

	public WebDriver driver;

	@Test
	public void loginTest() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '300%' ;");

		Thread.sleep(1000);
		js.executeScript("document.body.style.zoom = '30%' ;");

		Thread.sleep(1000);
		js.executeScript("document.body.style.zoom = '100%' ;");

	}
}
