package oop.sprint2.inlämningsuppgift2Test;

import oop.sprint2.inlämningsuppgift2.TimeUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:15
 */

public class TimeUtilTest {

    TimeUtil tu = new TimeUtil(true);

    @Test
    public final void getMembershipTimeTest() {
        LocalDate joined = LocalDate.of(2020, 9, 1);
        LocalDate joined2 = LocalDate.of(2012, 5, 11);
        int actual = tu.getMembershipDays(joined);
        int actual2 = tu.getMembershipDays(joined2);

        assertEquals(44 ,actual);
        assertNotEquals(43, actual);
        assertEquals(3079, actual2);
    }
}
