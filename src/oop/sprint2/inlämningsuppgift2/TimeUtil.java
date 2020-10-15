package oop.sprint2.inlämningsuppgift2;

import java.time.*;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class TimeUtil {

    public boolean test;
    LocalDate today;

    public TimeUtil(boolean isTest) {
        this.test = isTest;
        this.today = getToday();
    }

    public TimeUtil() {
        this.test = false;
        this.today = getToday();
    }

    // Sets today to fixed date if test
    public LocalDate getToday() {
        return this.test ? LocalDate.of(2020, 10, 15)
                : LocalDate.now();
    }

    // Check if last payment is within one year
    public boolean isWithinOneYear(LocalDate lastPayment) {
        return lastPayment.plusYears(1).isAfter(today);
    }
}
