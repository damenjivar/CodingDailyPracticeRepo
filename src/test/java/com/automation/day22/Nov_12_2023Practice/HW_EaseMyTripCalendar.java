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

public class HW_EaseMyTripCalendar {

	//HAVING A HARD TIME MAKING THIS DYNAMIC
	
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void easeMyTrip() {
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@id = 'frmcity']")).click();
		driver.findElement(By.xpath("//input[contains(@id, 'a_FromSector_show')]")).sendKeys("New");
		driver.findElement(By.xpath("//span[contains(text(), 'New York(NYC)')]")).click();
		driver.findElement(By.xpath("//input[contains(@id, 'a_Editbox13_show')]")).sendKeys("Las");
		driver.findElement(By.xpath("//span[contains(text(), 'Las Vegas(LAS)')]")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dvcalendar")));
		driver.findElement(By.xpath("//li[@id = 'snd_3_06/12/2023']")).click();
		

//		if (Integer.parseInt(selectDay) > 31) {
//			System.out.println("invalid date");
//			return;
//		}
//
//		if (Integer.parseInt(selectDay) > 29 && selectMonth.equals("Feb")) {
//			System.out.println("invalid Feb date");
//			return;
//		}

//		String monthYear = driver.findElement(By.className("month")).getText();
//		String month = monthYear.split(" ")[0];
//		String year = monthYear.split(" ")[1];
//
//		while ((!selectMonth.equals(month) && selectYear.equals(year))) {
//			driver.findElement(By.xpath("//img[@id = 'img2Nex']")).click();
//			monthYear = driver.findElement(By.className("month")).getText();
//			month = monthYear.split(" ")[0];
//			year = monthYear.split(" ")[1];
		// }

		

		
//		String dateToSelect = "12/12/2023";
//		By dateLocator = By.xpath("//ul[@class='bor-d31']/li[contains(text(), '" + dateToSelect + "')]");
//		WebElement dateElement = driver.findElement(dateLocator);
//		dateElement.click();
//
////		String xpathText = driver
//				.findElement(By.xpath("//ul[@class = 'bor-d31']/li[contains(@id, 'snd_1_04/12/2023')]")).getText();
//
//		if (driver.findElement(By.xpath(xpathText)).isDisplayed()) {
//			driver.findElement(By.xpath(xpathText)).click();
//		} else {
//			System.out.println("invalid date");
//		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}