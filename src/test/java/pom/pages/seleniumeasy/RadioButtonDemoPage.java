package pom.pages.seleniumeasy;

import pom.pages.Common;
import pom.pages.Locators;

public class RadioButtonDemoPage {
    public static void setUp(String url) {
        Common.openUrl(url);
    }


    public static void clickRadioButtonGender(String gender) {
        Common.clickElement(
                Locators.SeleniumEasy.RadioButtonDemo.inputGender(gender)
        );
    }

    public static void clickRadioButtonAge(String age) {
        Common.clickElement(
                Locators.SeleniumEasy.RadioButtonDemo.inputAge(age)
        );
    }

    public static void clickButtonGetValues() {
        Common.clickElement(
                Locators.SeleniumEasy.RadioButtonDemo.buttonGetValues
        );
    }

    public static String readMessageOfGenderAndAge() {

        return Common.getText(Locators.SeleniumEasy.RadioButtonDemo.paragraphGenderAndAge);
    }
}
