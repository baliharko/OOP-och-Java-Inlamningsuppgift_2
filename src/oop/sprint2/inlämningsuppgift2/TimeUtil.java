package oop.sprint2.inlämningsuppgift2;

import java.time.*;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class TimeUtil {

    public boolean test = false;
    LocalDate today;

    public TimeUtil(boolean isTest) {
        this.test = isTest;
        this.today = test ? LocalDate.of(2020, 10, 15)
                : LocalDate.now();
    }

    public Duration getMembershipDays(LocalDate dateJoined) {
        return Duration.between(dateJoined.atStartOfDay()
                ,today.atStartOfDay());
    }
}
