package dependency.injection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BirthdayCalculatorAfterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testGetHowManyDaysFromMyNextBirthday() {
        LocalDate date = LocalDate.of(2023, 5,29);

        BirthdayCalculatorAfter birthdayCalculator = new BirthdayCalculatorAfter(date);
        long diff = birthdayCalculator.getHowManyDaysFromMyNextBirthday("01-26");
        Assertions.assertEquals(diff, 242);
    }

    @AfterEach
    void tearDown() {
    }
}