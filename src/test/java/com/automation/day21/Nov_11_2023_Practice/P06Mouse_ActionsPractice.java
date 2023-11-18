package com.automation.day21.Nov_11_2023_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class P06Mouse_ActionsPractice {

	public WebDriver driver;
	public Actions action;
	public ChromeOptions options;
	public WebDriverWait wait;

	@Test
	public void easeMyTripMouseAction() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		action = new Actions(driver);

		WebElement myAccount = driver.findElement(By.id("spnMyAcc"));
		action.moveToElement(myAccount).build().perform();

		WebElement loginButton = driver.findElement(By.xpath("//a[@id = 'shwlogn']"));
		action.moveToElement(loginButton).build().perform();
		// action.click(loginButton).perform(); //either way works

		// can you stack webdriverwait with actions class if it is acting funny, or does
		// implicitly wait take care of everything?
		// why is this xpath not working? //div[@class =
		// 'my_account']/following::span[@id='spnMyAcc']

	}
}
