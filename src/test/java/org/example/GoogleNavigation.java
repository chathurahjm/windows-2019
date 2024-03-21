package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

@Test
public class GoogleNavigation {

    protected WebDriver driver;
    
    // @Test
    // public void testActions() {
    //     System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    //     //WebDriverManager.chromedriver().setup();

    //      ChromeOptions chromeOptions = new ChromeOptions();
    //     chromeOptions.addArguments("--headless");

    //     // Set headless mode
    //    // chromeOptions.addArguments("--disable-web-security");

    //     // Create a WebDriver instance (ChromeDriver)
    //      driver = new ChromeDriver(chromeOptions);

    //     // Navigate to Google
    //     driver.get("https://www.google.com");

    //     // Close the browser
    //     driver.quit();
        
    // }
    @Test
    public void testActions()throws InterruptedException {

        long startTime = System.currentTimeMillis();

         while (System.currentTimeMillis() - startTime < TimeUnit.HOURS.toMillis(17)) {

       
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //WebDriverManager.chromedriver().setup();

         ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");

        // Set headless mode
        //chromeOptions.addArguments("--disable-web-security");

        // Create a WebDriver instance (ChromeDriver)
         driver = new ChromeDriver(chromeOptions);

        // Navigate to Google
           driver.get("https://www.youtube.com/@day2day/playlists");

            Thread.sleep(8000); // Sleep
            WebElement element = driver.findElement(By.xpath("(//*[@class='yt-simple-endpoint style-scope ytd-playlist-thumbnail'])[4]"));

            // Simulate pressing the space button on the element
            element.click();
            Thread.sleep(900000); // Sleep for 1 second
            Thread.sleep(900000); // Sleep for 1 second


            driver.quit();
        
    }
    }
}
