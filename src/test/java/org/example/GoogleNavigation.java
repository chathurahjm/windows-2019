package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class GoogleNavigation {
    @Test
    public void testActions() {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a WebDriver instance (ChromeDriver)
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com");

        // Close the browser
        driver.quit();
    }
}
