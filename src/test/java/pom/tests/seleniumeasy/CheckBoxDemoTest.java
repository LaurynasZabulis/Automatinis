package pom.tests.seleniumeasy;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.pages.seleniumeasy.CheckboxDemoPage;
import pom.tests.BaseTest;

public class CheckBoxDemoTest extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        CheckboxDemoPage.openUrl("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }

    @Test
    public void testCheckBox () {

        String  expectedResult = "Success - Check box is checked";
        String  actualResult="";

        CheckboxDemoPage.clickSingleCheckbox();
            actualResult = CheckboxDemoPage.readMessage();
        CheckboxDemoPage.sleep(4000);

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format(
                        "Actual: %s; Expected: %s",
                        actualResult,
                        expectedResult
                )
        );
    }
    @DataProvider(name = "multipleCheckBoxDataProvider")
    public Object[][] dataProviderRadioButtonGroup() {
        return new Object[][]{
                {"Uncheck All",true},
                {"Check All", false}

        };
    }

    @Test(dataProvider = "multipleCheckBoxDataProvider")
    public void testMultipleCheckBox(String expectedAttributeValue, boolean expectedCheckBoxStatus) {

        String actualAttributeValue;
        String attributeName = "Value";
        boolean isCheckBoxSelected;

        CheckboxDemoPage.clickButtonCheck();
        if (!expectedCheckBoxStatus)CheckboxDemoPage.clickButtonCheck();


        actualAttributeValue = CheckboxDemoPage.readButtonText(attributeName);

        isCheckBoxSelected = CheckboxDemoPage.checkIfAllCheckBoxesAreSelected(expectedCheckBoxStatus);



        Assert.assertTrue(
                actualAttributeValue.contains(expectedAttributeValue),
                String.format(
                        "Actual: %s; Expected: %s",
                        actualAttributeValue,
                        expectedAttributeValue )
        );

        Assert.assertTrue(isCheckBoxSelected);

    }

}


