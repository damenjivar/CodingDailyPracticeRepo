package com.automation.day22.Nov_12_2023Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_MakeMyTripDatePickerCalendarPractice {
//FIX THE FAILURE
	
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void bookFlight() throws Exception {
		customizeTrip("10", "January", "2023");
	}

	public void customizeTrip(String selectDay, String selectMonth, String selectYear) throws Exception {
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys("New");
		actions = new Actions(driver);

		int i = 0;
		while (i < 2) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.DOWN);
			i++;
		}
		driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'To']")).sendKeys("Las");

		int j = 0;
		while (j < 3) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder = 'To']")).sendKeys(Keys.DOWN);
			j++;
		}
		driver.findElement(By.xpath("//input[@placeholder = 'To']")).sendKeys(Keys.ENTER);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'datePickerContainer']")));

		String monthYear = driver.findElement(By.xpath("//div[@class = 'DayPicker-Caption']")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		while (!(month.equals(selectMonth) && year.equals(selectYear))) {
			driver.findElement(By.xpath("//span[contains(@class, 'DayPicker-NavButton--next')]"))
					.click();
			monthYear = driver.findElement(By.xpath("//div[@class = 'DayPicker-Caption']")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		Thread.sleep(1000);

		String xpathPathText = "//div[@class = 'dateInnerCell']/p[text() = ' " + selectDay + "']";

		if (driver.findElement(By.xpath(xpathPathText)).isDisplayed()) {
			driver.findElement(By.xpath(xpathPathText)).click();
		} else {
			System.out.println("invalid date");
		}

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
