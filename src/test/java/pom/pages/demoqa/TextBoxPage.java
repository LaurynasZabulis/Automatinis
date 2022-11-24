package pom.pages.demoqa;
import org.openqa.selenium.By;
import pom.pages.Common;
import pom.pages.Locators;

import static pom.pages.Locators.DemoQa.TextBox.buttonSubmit;
import static pom.pages.Locators.DemoQa.TextBox.inputFullName;


public class TextBoxPage {

    public static void openUrl(String url) {
        Common.openUrl(url);
    }

    public static void close() {
        Common.close();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFullName(String message) {
        Common.sendKeys( inputFullName, message);
    }

    public static void clickButtonSubmit() {
        Common.clickElement(buttonSubmit);
    }

    public static String readFullName() {
        return Common.getText(Locators.DemoQa.TextBox.paragraphFullName);
    }
}
