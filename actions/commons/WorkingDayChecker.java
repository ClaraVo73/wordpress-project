package commons;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

public class WorkingDayChecker {

    private static final Set<LocalDate> HOLIDAYS_2025 = new HashSet<>();

    static {
        HOLIDAYS_2025.add(LocalDate.of(2025, 9, 1));
        HOLIDAYS_2025.add(LocalDate.of(2025, 9, 2));
    }

    public static boolean CheckDateIsWorkingDay2025(LocalDate date) {
        if (date == null) return false;

        if (date.getYear() != 2025) return false;

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) return false;

        return !HOLIDAYS_2025.contains(date);
    }


    public static boolean CheckDateIsWorkingDay2025(String input) {
        try {
            LocalDate parsedDate = LocalDate.parse(input);
            return CheckDateIsWorkingDay2025(parsedDate);
        } catch (DateTimeParseException | NullPointerException e) {
            return false;
        }
    }
}
