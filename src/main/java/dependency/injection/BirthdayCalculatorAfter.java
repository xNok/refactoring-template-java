package dependency.injection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthdayCalculatorAfter {

    private LocalDate now;

    public BirthdayCalculatorAfter(LocalDate now) {
        this.now = now;
    }

    public long getHowManyDaysFromMyNextBirthday(String myBirthdayStr) {
        int year = now.getYear();
        String myBirthDayOfCurrentYearStr = year + "-" + myBirthdayStr;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate myBirthday = LocalDate.parse(myBirthDayOfCurrentYearStr, dateTimeFormatter);
        if(myBirthday.isBefore(now)) {
            myBirthday = myBirthday.plusYears(1);
        }
        return ChronoUnit.DAYS.between(now, myBirthday);
    }
}
