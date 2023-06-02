package dependency.injection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthdayCalculatorV2 {

    private DateProvider dateProvider;

    public BirthdayCalculatorV2(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    public long getHowManyDaysFromMyNextBirthday(String myBirthdayStr) {
        LocalDate now = dateProvider.getCurrentDate();
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
