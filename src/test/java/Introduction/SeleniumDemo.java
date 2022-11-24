package Introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        options.addArguments("window-size=2000,3000");
        options.addArguments("--force-device-scale-factor=0.75");
//        options.addArguments("headless");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testDemo(){

        driver.get("https://www.shift4.com/");

        WebElement buttonAcceptAllCookies = driver.findElement(By.id("cookies-banner--btns-accept"));

        try {
            Thread.sleep(4000);

            buttonAcceptAllCookies.click();

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInputFullName(){
        driver.get("https://demoqa.com/text-box");

        String expectedResult = "Dailius";
        String actualResult;

        try {
            Thread.sleep(1500);

            WebElement inputFullName = driver.findElement(By.xpath("//input[@id='userName']"));
            inputFullName.sendKeys(expectedResult);
            Thread.sleep(1500);

            WebElement  buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
            buttonSubmit.click();
            Thread.sleep(1500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement readMessage = driver.findElement(By.xpath("//p[@id='name']"));
        actualResult = readMessage.getText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format(
                        "Actual: %s; Expected: %s",
                        actualResult,
                        expectedResult
                )
        );
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
