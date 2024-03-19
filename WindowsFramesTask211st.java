package com.guvi.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsFramesTask211st {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/iframe");
		WebElement Frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(Frame);
		driver.findElement(By.tagName("p")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.tagName("p")).sendKeys(Keys.DELETE);
		driver.findElement(By.tagName("p")).sendKeys("Hello People");
		driver.quit();

	}

}
