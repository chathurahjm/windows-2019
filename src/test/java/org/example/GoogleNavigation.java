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

    @Test
    public void testActions()throws InterruptedException {

        long startTime = System.currentTimeMillis();

         while (System.currentTimeMillis() - startTime < TimeUnit.HOURS.toMillis(17)) {

       
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);

           driver.get("https://www.youtube.com/@day2day/playlists");

            Thread.sleep(8000); // Sleep
             takeScreenHSot();
            WebElement element = driver.findElement(By.xpath("(//*[@class='yt-simple-endpoint style-scope ytd-playlist-thumbnail'])[4]"));

            // Simulate pressing the space button on the element
            element.click();
               takeScreenHSot();
            Thread.sleep(900000); // Sleep for 1 second
               takeScreenHSot();
            Thread.sleep(900000); // Sleep for 1 second

  takeScreenHSot();
            driver.quit();
        
    }
    }

    public void takeScreenHSot()
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        LocalDateTime currentTime = LocalDateTime.now();

        // Define a formatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");

        // Format the current time as a string
        String currentTimeAsString = currentTime.format(formatter);

        // Define the path to save the screenshot
        Path destination = Paths.get(System.getProperty("user.dir") + "\\screenshots\\" + currentTimeAsString + ".png");

        try {
            // Copy screenshot to the destination
            Files.copy(source.toPath(), destination);
            System.out.println("Screenshot taken");
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
