package pom.pages.demoqa;

import pom.pages.Common;
import pom.pages.Locators;

public class ElementPage {
    public static void clickTextBoxFromMenu() {
        Common.clickElementByAction(Locators.DemoQa.Elements.menuTextBox);
    }
}
