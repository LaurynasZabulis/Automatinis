package pom.tests.demoqa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.demoqa.ButtonsPage;
import pom.tests.BaseTest;

public class ButtonTest extends BaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        ButtonsPage.openURL("https://demoqa.com/buttons");
    }

    @Test
    public void testButtonDoubleClick(){

        String expectedResult = "double click";
        String actualResult;

        ButtonsPage.doubleClickButton();
        actualResult = ButtonsPage.readMessageOfDoubleClick();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format(
                        "Actual: %s; Expected: %s",
                        actualResult,
                        expectedResult
                )
        );

    }
}
