package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class GoogleNavigation {

    protected WebDriver driver;
    
    @Test
    public void testActions() {
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriverManager.chromedriver().setup();


        // Create a WebDriver instance (ChromeDriver)
         driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com");

        // Close the browser
        driver.quit();
    }
}
