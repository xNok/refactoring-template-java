package dependency.injection;

import java.time.LocalDate;

public class DateProvider {

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
