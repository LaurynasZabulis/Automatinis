package pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        threadLocal.set(new ChromeDriver(getOptions()));
        //driver.manage().window().setSize(new Dimension(2000, 3000));

    }

    private static ChromeOptions getOptions() {

        ChromeOptions options = new ChromeOptions();

        // ptions.addArguments("start-maximized");
        options.addArguments("window-size=2000,3000");
        options.addArguments("--force-device-scale-factor=0.75");
        options.addArguments("headless");

        return options;
    }

    public static WebDriver getDriver() {

        return threadLocal.get();
    }

    public static void close(){

        threadLocal.get().quit();
        threadLocal.remove();

    }
}
