package com.automation.day22.Nov_12_2023Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class P4RediffWebTable_AssignmentPractice2 {

	public WebDriver driver;

	@Test(priority = 1)
	public void webTableAssignment() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("a.moneyicon.relative")).click();
		driver.findElement(By.xpath("//a[text() = 'Gainers / Losers']")).click();

		// WHY DOES 'CONTAINS TEXT' WORK BUT JUST 'TEXT' DOES NOT WHEN FINDING ON DOM???
		// a[contains(text(), 'Modern Steels')]

		String companyName = "Modern Steels";

		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));

		for (int i = 0; i < companyNames.size(); i++) {
			if (companyName.equals(companyNames.get(i).getText())) {
				System.out.println(companyNames.get(i).getText() + "----->" + currentPrices.get(i).getText());
				break;
			}
		}
	}

	@Test(priority = 2)
	public void assignment2() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("a.moneyicon.relative")).click();
		driver.findElement(By.xpath("//a[text() = 'Gainers / Losers']")).click();

		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));

		// WebElement companyName = driver.findElement(By.xpath("//table[@class =
		// 'dataTable']/tbody/tr[1000]/td[1]"));

		// CAN WE STORE THE WEBELEMENT AS A STRING DIRECTLY AND CALL THE GET TEXT
		// METHOD, OR DO WE NEED THE WEBELEMENT TO BE HERE PRESENT ABOVE?
		String oneThousandthCompanyName = driver
				.findElement(By.xpath("//table[@class = 'dataTable']/tbody/tr[1000]/td[1]")).getText();
		System.out.println(oneThousandthCompanyName);

		for (int i = 0; i < companyNames.size(); i++) {
			if (oneThousandthCompanyName.equals(companyNames.get(i).getText())) {
				System.out.println(companyNames.get(i).getText() + "----->" + currentPrices.get(i).getText());
				break;
			}
		}
	}

	@Test
	public void assignment3() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("a.moneyicon.relative")).click();
		driver.findElement(By.xpath("//a[text() = 'Gainers / Losers']")).click();

		List<WebElement> first5Rows = driver
				.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr[position() >0 and position()  <=5]"));
		for (int i = 0; i < first5Rows.size(); i++) {
			System.out.println(first5Rows.get(i).getText());
			System.out.println("-----");
		}
	}

	@Test
	public void assignment4() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("a.moneyicon.relative")).click();
		driver.findElement(By.xpath("//a[text() = 'Gainers / Losers']")).click();

		String companyName1 = "Shelter Pharma";
		String companyName2 = "Palco Metals";
		String companyName3 = "Starteck Finance";
		String companyName4 = "Jayant Infratech";
		String companyName5 = "PMC Fincorp";

		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[1]"));
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[4]"));

		for (int i = 0; i < companyNames.size(); i++) {
			String currentCompanyNames = companyNames.get(i).getText();
			if (currentCompanyNames.equals(companyName1) || currentCompanyNames.equals(companyName2)
					|| currentCompanyNames.equals(companyName3) || currentCompanyNames.equals(companyName4)
					|| currentCompanyNames.equals(companyName5)) {
				System.out.println(currentCompanyNames + "--->" + currentPrices.get(i).getText());
			}
		}
	}

	@Test
	public void webTableAssignment2() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String[] companyNamesToCheck = { "Palco Metals", "Tinna Trade", "Jayant Infratech", "Shelter Pharma",
				"The Hi-Tech Gears" };

		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[1]"));
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[4]"));

		for (int i = 0; i < companyNames.size(); i++) {
			for (String companyName : companyNamesToCheck) {
				if (companyName.equals(companyNames.get(i).getText())) {
					System.out.println(companyNames.get(i).getText() + "--->" + currentPrices.get(i).getText());
					break;
				}
			}
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
