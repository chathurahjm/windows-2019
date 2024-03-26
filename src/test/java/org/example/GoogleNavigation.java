package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By; 
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Test
public class GoogleNavigation {

    protected WebDriver driver;



    //@Test
    public void whatisMyIP()throws InterruptedException {

        long startTime = System.currentTimeMillis();

         while (System.currentTimeMillis() - startTime < TimeUnit.SECONDS.toMillis(3000)) {

       
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");

        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);

           driver.get("https://whatismyipaddress.com/");
         Thread.sleep(3000);
        takeScreenHhot();
            driver.quit();
        
    }
    }


    @Test
    public void testActions()throws InterruptedException {

        long startTime = System.currentTimeMillis();

         while (System.currentTimeMillis() - startTime < TimeUnit.HOURS.toMillis(6)) {

       
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");

        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);

           driver.get("https://www.youtube.com/@day2day/playlists");

            Thread.sleep(8000); // Sleep
            takeScreenHhot();
            WebElement element = driver.findElement(By.xpath("(//*[@class='yt-simple-endpoint style-scope ytd-playlist-thumbnail'])[4]"));

            // Simulate pressing the space button on the element
            element.click();
            Thread.sleep(900000); // Sleep for 1 second
             //Thread.sleep(3000); // Sleep for 1 second
            Thread.sleep(900000); // Sleep for 1 second

            takeScreenHhot();
            driver.quit();
        
    }
    }

   public void takeScreenHhot()
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        LocalDateTime currentTime = LocalDateTime.now();

        // Define a formatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");

        // Format the current time as a string
        String currentTimeAsString = currentTime.format(formatter);

        // Define the path to save the screenshot
        Path destination = Paths.get(System.getProperty("user.dir") + "/screenshots/" + currentTimeAsString + ".png");

        try {
            // Copy screenshot to the destination
            Files.copy(source.toPath(), destination);
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  Screenshot taken");
            System.out.println(System.getProperty("user.dir"));
                        System.out.println(destination.toString());
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
