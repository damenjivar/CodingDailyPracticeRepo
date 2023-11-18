package com.automation.day21.Nov_11_2023_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P09Tool_TipPractice {

	public WebDriver driver;

	@Test
	public void toolTip() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");

		WebElement createAccountLink = driver.findElement(By.linkText("Create Account"));
		String tooltip = createAccountLink.getAttribute("title");
		System.out.println("the tool tip of create account link is: " + tooltip);

		WebElement signInLink = driver.findElement(By.className("signin"));
		String tooltip1 = signInLink.getAttribute("title");
		System.out.println("the tool tip of sign in link is: " + tooltip1);
		
		WebElement rediffmail_Icon = driver.findElement(By.className("mailicon"));
		String tooltip2 = rediffmail_Icon.getAttribute("title");
		System.out.println("the tool tip for Rediffmail icon link is: " + tooltip2);

		WebElement moneyIcon = driver.findElement(By.cssSelector("a.moneyicon.relative"));
		String tooltip3 = moneyIcon.getAttribute("title");
		System.out.println("the tool tip of money icon link is: " + tooltip3);
	}
}
















































