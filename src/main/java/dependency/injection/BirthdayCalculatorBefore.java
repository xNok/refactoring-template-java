package dependency.injection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthdayCalculatorBefore {

    public long getHowManyDaysFromMyNextBirthday(String myBirthdayStr) {
        LocalDate now = LocalDate.now();
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
