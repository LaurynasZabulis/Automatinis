package pom.pages.demoqa;

import pom.pages.Common;
import pom.pages.Locators;

public class ButtonsPage {
    public static void openURL(String url) {
        Common.openUrl(url);

    }

    public static void doubleClickButton() {
        Common.doubleClickElementByAction(Locators.DemoQa.Buttons.buttonDoubleClick);
    }

    public static String readMessageOfDoubleClick() {
        return Common.getText(Locators.DemoQa.Buttons.paragraphDoubleClick);
    }
}
