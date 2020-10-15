package oop.sprint2.inlämningsuppgift2Test;

import oop.sprint2.inlämningsuppgift2.FileUtil;
import oop.sprint2.inlämningsuppgift2.GymVisit;
import oop.sprint2.inlämningsuppgift2.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

    FileUtil fu = new FileUtil(true);

    Member m1 = new Member("7603021234", "Alhambra Aromes", LocalDate.parse("2019-11-01"));
    Member m2 = new Member("8104021234", "Bear Belle", LocalDate.parse("2018-12-02"));
    Member m3 = new Member("8512021234", "Chamade Coriola", LocalDate.parse("2017-03-12"));

    @Test
    public final void createListFromFileTest() {
        List<Member> actual = fu.initMembersList();
        List<Member> expected = Arrays.asList(m1, m2, m3);

        assertEquals(expected.get(2).getName(), actual.get(2).getName());
        assertEquals(expected.toString(), actual.toString());
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
        assertNotEquals(expected.get(2), actual.get(1));
        assertNotEquals(expected, actual);
    }

    @Test
    public final void addToVisitsFileTest() {
        fu.deleteVisitsFile();
        fu.addToVisitsFile(m1);

        assertEquals(fu.getVisitsFromFile().size(), 1);
        assertNotEquals(fu.getVisitsFromFile().size(), 3);

    }

    @Test
    public final void getVisitsFromFileTest() {
        fu.deleteVisitsFile();

        fu.addToVisitsFile(m1);
        fu.addToVisitsFile(m2);
        fu.addToVisitsFile(m3);

        List<GymVisit> list = fu.getVisitsFromFile();

        assertEquals(3, list.size());

        fu.addToVisitsFile(m1);
        list = fu.getVisitsFromFile();

        assertNotEquals(2, list.size());
        assertEquals(4, list.size());
    }
}
