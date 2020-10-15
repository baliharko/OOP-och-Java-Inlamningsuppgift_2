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

    LocalDate joined = LocalDate.of(2020, 9, 1);
    LocalDate joined2 = LocalDate.of(2012, 5, 11);
    LocalDate joined3 = LocalDate.of(2020, 1, 1);

    @Test
    public final void isWithinOneYearTest() {

        assertTrue(tu.isWithinOneYear(joined));
        assertFalse(tu.isWithinOneYear(joined2));
        assertTrue(tu.isWithinOneYear(joined3));
    }
}
