package dependency.injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BirthdayCalculatorAfterTest {

    @Test
    public void testGetHowManyDaysFromMyNextBirthday() {
        LocalDate today = LocalDate.of(2023, 5,29);
        String birthdayStr = "01-26";
        BirthdayCalculatorAfter birthdayCalculator = new BirthdayCalculatorAfter(today);
        long diff = birthdayCalculator.getHowManyDaysFromMyNextBirthday(birthdayStr);
        Assertions.assertEquals(diff, 242);
    }
}