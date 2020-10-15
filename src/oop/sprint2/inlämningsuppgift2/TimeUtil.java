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

    public LocalDate getToday() {
        return this.test ? LocalDate.of(2020, 10, 15)
                : LocalDate.now();
    }

    public int getMembershipDays(LocalDate dateJoined) {
        return (int) Duration.between(dateJoined.atStartOfDay()
                ,today.atStartOfDay()).toDays();
    }
}
