package com.guvi.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsFrames213rd {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		WebElement Top = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(Top);

		WebElement Left = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(Left);
		String LeftText = driver.findElement(By.tagName("body")).getText();
		System.out.println(LeftText);

		driver.switchTo().parentFrame();
		WebElement Middle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(Middle);
		String MiddleText = driver.findElement(By.tagName("div")).getText();
		System.out.println(MiddleText);

		driver.switchTo().parentFrame();
		WebElement Right = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(Right);
		String RightText = driver.findElement(By.tagName("body")).getText();
		System.out.println(RightText);

		driver.switchTo().defaultContent();
		WebElement Bottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(Bottom);
		String BottomText = driver.findElement(By.tagName("body")).getText();
		System.out.println(BottomText);

		String page = driver.getCurrentUrl();
		System.out.println("Current page:" + page);

	}

}
