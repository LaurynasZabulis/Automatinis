package pom.tests.seleniumeasy;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.pages.Locators;
import pom.pages.seleniumeasy.RadioButtonDemoPage;
import pom.tests.BaseTest;

import javax.swing.plaf.basic.BasicBorders;

public class RadiobuttonDemoTest   extends BaseTest  {
    @BeforeMethod
    @Override
    public void setUp() {

        RadioButtonDemoPage.setUp("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

    }

    @DataProvider(name = "radioButtonGroupDataProvider", parallel = true)
    public Object [][] dataProviderRadioButtonGroup(){
        return new Object[][]{
                {"Male", "0 - 5" },
                {"Male", "5 - 15"},
                {"Male", "15 - 50"},
                {"Female", "0 - 5" },
                {"Female", "5 - 15"},
                {"Female", "15 - 50"},
        };

    }

    @Test(dataProvider = "radioButtonGroupDataProvider", threadPoolSize = 6)
    public void testGroupRadonButtons(String expectedGender, String expectedAge) {
        String actualResult;


        RadioButtonDemoPage.clickRadioButtonGender(expectedGender);
        RadioButtonDemoPage.clickRadioButtonAge(expectedAge);

        RadioButtonDemoPage.clickButtonGetValues();
        actualResult = RadioButtonDemoPage.readMessageOfGenderAndAge();


        Assert.assertTrue(
                actualResult.contains(expectedGender),
                String.format("Actual: %s; Expected: %s",actualResult, expectedGender)
        );

        Assert.assertTrue(
                actualResult.contains(expectedAge),
                String.format("Actual: %s; Expected: %s", actualResult, expectedAge)
        );
    }

}
