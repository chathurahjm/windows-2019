package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Test
public class vpntest {

    protected WebDriver driver;



    @Test
    public void testActions2() throws InterruptedException {
  long startTime = System.currentTimeMillis();

         while (System.currentTimeMillis() - startTime < TimeUnit.HOURS.toMillis(5)) {

       
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
             chromeOptions.addArguments("--disable-extensions");
             chromeOptions.addArguments("--disable-gpu");
             chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");

        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);

           driver.get("https://www.youtube.com/@day2day/playlists");

            Thread.sleep(8000); // Sleep
            takeScreenHhot();

            try {
                WebElement ck = driver.findElement(By.xpath("//input[@type='checkbox']"));
                ck.click();
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }

             Thread.sleep(8000); // Sleep
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

    @Test
    public void testscreen() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < TimeUnit.SECONDS.toMillis(10)) {


            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("windows"))
            {
                WebDriverManager.chromedriver().setup();

                //ChromeOptions chromeOptions = new ChromeOptions();
            }
            else {


                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  OS");


            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");

            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

            driver.get("https://whatismyipaddress.com/");
            Thread.sleep(3000);
            takeScreenHhot();
            driver.quit();

        }
    }


    public void takeScreenHhot() {
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
            System.out.println(destination);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }

    @AfterTest
    public static void commitAndPushChanges() throws IOException, InterruptedException {
        // Setting up Git commands
        String[] commands = {
                "git", "config", "--global", "user.email", "actions@github.com",
                "git", "config", "--global", "user.name", "GitHub Actions",
                "git", "add", "/home/runner/work/gitActionWindows/gitActionWindows/screenshots/",
                "git", "commit", "-m", "Automatically updated GitHub Actions workflow",
                "git", "push"
        };

        // Running Git commands
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Reading output
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Waiting for the process to finish
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Git command failed with exit code: " + exitCode);
        }
    }

}
