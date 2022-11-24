package pom.pages.seleniumeasy;

import com.sun.jna.WString;
import pom.pages.Common;
import pom.pages.Locators;

import java.util.List;

public class CheckboxDemoPage {



    public static void openUrl(String url) {
        Common.openUrl(url);
    }

    public static void close(){
        Common.close();
    }
    public static void sleep (int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickSingleCheckbox() {
        Common.clickElement(
               Locators.SeleniumEasy.CheckboxDemo.checkBox
        );
    }

    public static String readMessage() {
        return Common.getText(
                Locators.SeleniumEasy.CheckboxDemo.textAge
        );
    }

    public static void clickButtonCheck() {
        Common.clickElement(Locators.SeleniumEasy.CheckboxDemo.buttonCheck);
    }

    public static String readButtonText(String attributeName) {
        return Common.getElementAttributeValue(
                Locators.SeleniumEasy.CheckboxDemo.buttonCheck,attributeName

        );
    }

    public static boolean checkIfAllCheckBoxesAreSelected(boolean expectedStatus) {

        List<Boolean> isSelectedCheckBoxes =
                Common.getSelectedStatusOfCheckBoxes(Locators.SeleniumEasy.CheckboxDemo.multiplyCheckBox);

        for (boolean isSelected: isSelectedCheckBoxes){
            if(isSelected != expectedStatus) return false;

        }


        return true;

    }
}
