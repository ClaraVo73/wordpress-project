import commons.WorkingDayChecker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkingDayCheckerTest {

    @DataProvider(name = "validWorkingDays")
    public Object[][] validWorkingDays() {
        return new Object[][]{
                {"2025-12-01"}, // Monday
                {"2025-09-03"}, // Wednesday
                {"2025-08-08"}  // Friday
        };
    }

    @DataProvider(name = "nonWorkingDays")
    public Object[][] nonWorkingDays() {
        return new Object[][]{
                {"2025-09-01"}, // Monday - holiday
                {"2025-09-02"}, // Tuesday - holiday
                {"2025-08-31"}, // Sunday
                {"2025-09-06"} // Saturday
        };
    }

    @DataProvider(name = "invalidDates")
    public Object[][] invalidDates() {
        return new Object[][]{
                {"2025-02-30"}, // invalid day
                {"2025/09/01"}, // wrong format
                {"abc"},        // random text
                {""},           // empty string
                {null},         // null value
                {"2024-12-01"}, // wrong year
                {"2026-01-01"}  // wrong year
        };
    }

    @Test(dataProvider = "validWorkingDays")
    public void testValidWorkingDays(String input) {
        boolean result = WorkingDayChecker.CheckDateIsWorkingDay2025(input);
        Assert.assertTrue(result, "Expected TRUE for working day: " + input);
    }

    @Test(dataProvider = "nonWorkingDays")
    public void testNonWorkingDays(String input) {
        boolean result = WorkingDayChecker.CheckDateIsWorkingDay2025(input);
        Assert.assertFalse(result, "Expected FALSE for non-working day: " + input);
    }

    @Test(dataProvider = "invalidDates")
    public void testInvalidInputs(String input) {
        boolean result = WorkingDayChecker.CheckDateIsWorkingDay2025(input);
        Assert.assertFalse(result, "Expected FALSE for invalid input: " + input);
    }
}