package com.automation.day21.Nov_11_2023_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.java.Sep_30_Day9_SpecialClasses.Util;

public class P07KeyBoard_ActionPractice {

	public WebDriver driver;
	public Actions action;

	@Test(priority = 1)
	public void loginKeyBoard() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();

		WebElement loginEmail = driver.findElement(By.id("input-email"));
		WebElement loginPassword = driver.findElement(By.id("input-password"));
		WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));

		action = new Actions(driver); // DOES PLACEMENT OF THIS MATTER? DOES IT HAVE TO BE BEFORE OR AFTER
										// WEBELEMENTS?

		action.click(loginEmail).sendKeys("seleniumpanda@gmail.com").sendKeys(Keys.TAB).perform();
		loginPassword.sendKeys("Selenium@123");
		loginButton.sendKeys(Keys.ENTER);

	}

	@Test(priority = 2)
	public void rediffLoginCopyPasteKeyboard() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		driver.findElement(By.linkText("Sign in")).click();

		action = new Actions(driver);

		WebElement loginEmail = driver.findElement(By.id("login1"));
		WebElement loginPassword = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.cssSelector("input.signinbtn"));

		action.click(loginEmail).sendKeys("seleniumpanda@rediffmail.com").perform();

		action.keyDown(loginEmail, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.keyDown(loginEmail, Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.click(loginPassword).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		loginButton.sendKeys(Keys.ENTER);
	}

	@Test(priority = 3)

	public void tnRegisterKeyboardActions() throws Exception {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

		action = new Actions(driver);

		WebElement firstName = driver.findElement(By.id("input-firstname"));
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement telephone = driver.findElement(By.id("input-telephone"));
		WebElement password = driver.findElement(By.id("input-password"));
		WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
		WebElement privacyPolicy = driver.findElement(By.name("agree"));
		WebElement continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));

		action.click(firstName).sendKeys("selenium").sendKeys(Keys.TAB).perform();
		lastName.sendKeys("panda");
		action.click(email).sendKeys(Util.emailWithDateTimeStamp()).sendKeys(Keys.TAB).perform();
		telephone.sendKeys("1234567890");
		action.click(password).sendKeys("Selenium@123").perform();

		//CHAT GPT COPY PASTE - CODE PASSES BUT PASSWORD NOT MATCHING
		action.sendKeys(password, Keys.CONTROL + "a").sendKeys(Keys.CONTROL + "c").perform();
		Thread.sleep(3000);
		action.sendKeys(passwordConfirm, Keys.CONTROL + "v").perform();

		// action.keyDown(password,
		// Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		// action.keyDown(password,
		// Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		// action.click(passwordConfirm).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		action.click(privacyPolicy).sendKeys(Keys.TAB).perform();
		continueButton.sendKeys(Keys.ENTER);

		// WHY DOES PASSWORD CONFIRMATION NOT MATCH???
	}
}
