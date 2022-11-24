package Introduction;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {

    @Test
    public void test01() {
        String expectedResult = "Dailius";
        String actualResult = "Dailius";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test02() {
        String expectedResult = "Dailius";
        String actualResult = "Antanas";


        Assert.assertTrue(
                actualResult.equals(expectedResult)  ,
                String.format(
                        "Actual: %s; Expected: %s",
                        actualResult,
                        expectedResult
                )
        );
    }
}
