package com.guvi.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsFrameTask212nd {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		// driver.switchTo().newWindow(null);
		String mainwin = driver.getWindowHandle(); // Print particular window Id
		System.out.println("Main window ID: " + mainwin);
		Set<String> Allwin = driver.getWindowHandles();
		Iterator<String> iterator = Allwin.iterator();
		while (iterator.hasNext()) {
			String Childwin = iterator.next();

			if (!mainwin.equalsIgnoreCase(Childwin)) {
				driver.switchTo().window(Childwin);
				String Text = driver.findElement(By.tagName("h3")).getText(); // Reading text from Window 2
				System.out.println("The Text present in the new window is: " + Text);
				System.out.println("All Window ID's are " + Allwin);
			}
		}
		driver.close();
		Set<String> ActiveWindows = driver.getWindowHandles();
		System.out.println("Original Window is active and its ID : " + ActiveWindows);
		driver.quit();
	}

}
