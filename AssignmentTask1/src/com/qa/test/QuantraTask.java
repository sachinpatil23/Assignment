package com.qa.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuantraTask {

	static Properties pro;
	static WebDriver driver;

	@Test

	public void loginTest() throws Exception {

		pro = new Properties();
		File f = new File("/home/academy/eclipse-workspace/DEmo1/src/prop/config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		System.setProperty("webdriver.chrome.driver", "/home/academy/Downloads/Jar/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);

		driver.findElement(
				By.xpath(".//*[@id='container']/div/div/header-page/header/div[2]/div/div/div/div[2]/ul/li[6]/a"))
				.click();
		System.out.println("Clicik on login link");

		driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div/div/div/div/ul/li[6]/form/ul/li[1]/input"))
				.sendKeys(pro.getProperty("username"));
		System.out.println("Enter Username");

		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(pro.getProperty("password"));
		System.out.println("Enter Password");

		driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div/div/div/div/ul/li[6]/form/ul/li[5]/input"))
				.click();

		System.out.println("Click on login button");
		Thread.sleep(3000);

		driver.findElement(
				By.xpath(".//*[@id='container']/div/div/header-page/header/div[2]/div/div/div/div[2]/ul/li[6]/span"))
				.click();
		
		System.out.println("Click on profile");

	
		System.out.println("Welcome Mr " + driver.findElement(By.xpath(
				".//*[@id='container']/div/div/header-page/header/div[2]/div/div/div/div[2]/ul/div/div/div[1]/h1"))
				.getText());
		System.out.println("Verified Username");

		Thread.sleep(2000);

			driver.findElement(By
				.xpath(".//*[@id='cg-busy-po']/section/div/div[3]/div[1]/div[1]/div/div[2]/ul[1]/li/div/div[1]/a[1]/i"))
				.click();
		System.out.println("click om voteup");

		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='cg-busy-po']/section/div/div[1]/div/div/div/div[2]/a")).click();
		System.out.println("click on new post");

		driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div/div/div/div[2]/form/div[1]/input"))
				.sendKeys("Automation Test");

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Frames available on page are " + size);

		driver.switchTo().frame(2);
		driver.findElement(By.xpath("html/body")).sendKeys("hi");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div/div/div/div[2]/form/div[3]/div/div[3]")).click();

		driver.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div/div/div/div[3]/div/div[2]/button[1]")).click();

		String actualText = driver
				.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div/div/div/div[2]/form/div[5]/div")).getText();
		String expectedText = "Recaptcha required";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Test Case Pass");
		
		driver.close();
		System.out.println("Browser close");

	}

}
