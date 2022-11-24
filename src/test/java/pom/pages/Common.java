package pom.pages;

import com.sun.jna.WString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pom.utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static void openUrl(String url) {
        Driver.setUp();
        Driver.getDriver().get(url);
    }

    public static void close() {
        Driver.close();
    }

    public static WebElement getElement(By locator){
        return Driver.getDriver().findElement(locator);
    }

    public static List<WebElement> getElements(By locator){
        return Driver.getDriver().findElements(locator);
    }
    public static void sendKeys(By locator, String keys) {
        getElement(locator).sendKeys(keys);
    }

    public static void clickElement(By locator) {
        getElement(locator).click();
    }

    public static String getText(By locator) {
        return getElement(locator).getText();
    }

    public static String getElementAttributeValue(By locator, String attributeName) {
    return getElement (locator).getAttribute(attributeName);
    }

    public static List<Boolean> getSelectedStatusOfCheckBoxes(By locator) {
       List<WebElement> elements = getElements(locator);
       List<Boolean> elementsStatus = new ArrayList<>();

       for (WebElement element: elements){
           elementsStatus.add( element.isSelected());

       }

        return elementsStatus;
    }

    public static Actions getElementForActions(By locator){
        WebElement element = getElement(locator);
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element);

        return action;

    }

    public static void clickElementByAction(By locator) {
        getElementForActions(locator).click().perform();
    }

    public static void doubleClickElementByAction(By locator) {
        getElementForActions(locator).doubleClick().perform();

    }
}
