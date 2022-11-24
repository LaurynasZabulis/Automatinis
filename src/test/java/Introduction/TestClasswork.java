package Introduction;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestClasswork {

//    Testas “žalias” jeigu 995 dalijasi iš 3 (be liekanos)

    @Test
    public void testIfNumber995DividesWith3WithoutReminder() {
        // 1. Duomenys
        int inputA = 995;
        int inputB = 3;
        int expectedResult = 0;
        int actualResult;

        // 2. Testo veiksmas
        actualResult = inputA % inputB;

        // 3. Trikrinam rezultatus
        Assert.assertEquals(actualResult, expectedResult);

    }

    //    Testas “žalias” jeigu šiandien trečiadienis
    @Test
    public void testIfTodayIsWednesday() {
        DayOfWeek expectedResult = DayOfWeek.WEDNESDAY;
        DayOfWeek actualResult;

        actualResult = LocalDate.now().getDayOfWeek();

        Assert.assertTrue(
                actualResult.equals(expectedResult),
                String.format(
                        "Actual: %s; Expected: %s",
                        actualResult,
                        expectedResult
                )
        );
    }

    @Test
    public void testIfSentenceContainsSomeText() {
        String expectedResult = "adipiscing do eiusmod";
        String actualResult = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format(
                        "Actual: %s;%n Expected: %s",
                        actualResult,
                        expectedResult
                )
        );
    }

//    Testas “žalias” po to, kai “palaukia” 5 sekundes

    @Test
    public void testWaitFor5Seconds(){

        try {
            for (int i : new int[5]){
                Thread.sleep(1000);
                System.out.println("sleeping ... ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
//
//    Bonus: Testas “žalias” jei nuo 1 iki 10 yra 4 lyginiai skaičiai

}
