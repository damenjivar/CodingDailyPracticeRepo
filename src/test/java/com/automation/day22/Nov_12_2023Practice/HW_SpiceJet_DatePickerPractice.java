package com.automation.day22.Nov_12_2023Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_SpiceJet_DatePickerPractice {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void BookFlight() {
		customizeTrip("25", "December ", "2023");
	}

	public void customizeTrip(String selectDay, String selectMonth, String selectYear) {
		driver.findElement(By.xpath("//div[@data-testid = 'round-trip-radio-button']")).click();
		driver.findElement(By.xpath("//div[text() = 'From']")).click();
		driver.findElement(By.xpath("//div[text() = 'International']")).click();
		driver.findElement(By.xpath("//div[text() = 'Colombo']")).click();
		driver.findElement(By.xpath("//div[text() = 'International']")).click();
		driver.findElement(By.xpath("//div[text() = 'Kabul']")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@data-testid = 'undefined-calendar-picker']")));

		String monthXpath = "//div[text() = '" + selectMonth + "']";
		String yearXpath = "//div[text() = '" + selectYear + "']";

		while (!(monthXpath.equals(selectMonth) && yearXpath.equals(selectYear))) {
			driver.findElement(By.xpath(monthXpath)).click();
			driver.findElement(By.xpath(yearXpath)).click();
		}

		String dayXpath = "//div[text() = '" + selectDay + "']";
		if (driver.findElement(By.xpath(dayXpath)).isDisplayed()) {
			driver.findElement(By.xpath(dayXpath)).click();
		} else {
			System.out.println("invalid date");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}