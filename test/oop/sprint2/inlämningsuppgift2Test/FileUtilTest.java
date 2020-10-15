package oop.sprint2.inlämningsuppgift2Test;

import oop.sprint2.inlämningsuppgift2.FileUtil;
import oop.sprint2.inlämningsuppgift2.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:16
 */

public class FileUtilTest {

    @Test
    public final void createListFromFileTest() {
        FileUtil fu = new FileUtil(true);

        List<Member> actual = fu.createListFromFile();
        List<Member> expected = Arrays.asList(
                new Member("7603021234", "Alhambra Aromes" , LocalDate.parse("2019-11-01")),
                new Member("8104021234", "Bear Belle", LocalDate.parse("2018-12-02")),
                new Member("8512021234", "Chamade Coriola", LocalDate.parse("2017-03-12")));

        assertEquals(expected.get(2).getName(), actual.get(2).getName());
        assertEquals(expected.toString(), actual.toString());
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
        assertNotEquals(expected.get(2), actual.get(1));
        assertNotEquals(expected, actual);
    }

    @Test
    public final void writeToFileTest() {
        // TODO Skriv till fil
    }
}
