package com.automation.day21.Nov_11_2023_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class P10Looping_DropDownPractice {

	public WebDriver driver;
	public ChromeOptions options;

	@Test(priority = 1)
	public void loopingDropDown() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://easemytrip.com/");

		String preSelection = driver.findElement(By.id("spnDrpNo")).getText();
		System.out.println("number of passengers before selection: " + preSelection);

		driver.findElement(By.id("ptravlrNo")).click();

		// DOES IT MATTER IF THE CLASS IS A COMPOUND CLASS FOR XPATH???

		int adults = 1;
		while (adults < 5) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id = 'add'and @class = 'add plus_box1']")).click();
			adults++;
		}

		int children = 0;
		while (children < 2) {
			driver.findElement(By.xpath("//button[@id = 'add'and @class = 'add plus_boxChd']")).click();
			children++;
		}

		int infants = 0;
		while (infants < 4) {
			driver.findElement(By.xpath("//button[@id = 'add'and @class = 'add plus_box1Inf']")).click();
			infants++;
		}

		driver.findElement(By.id("traveLer")).click();
		Thread.sleep(1000);
		String postSelection = driver.findElement(By.id("spnDrpNo")).getText();
		System.out.println("number of passengers after selection: " + postSelection);
	}

	@Test(priority = 2)
	public void spiceJetLoopingDropDown() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
}
