package oop.sprint2.inlämningsuppgift2Test;

import oop.sprint2.inlämningsuppgift2.Gym;
import oop.sprint2.inlämningsuppgift2.Member;
import oop.sprint2.inlämningsuppgift2.MembershipStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:17
 */

public class GymTest {

    Gym g = new Gym(true);

    Member notMember = new Member("1231231312", "Bali", LocalDate.of(2019,1,12));
    Member member1 = new Member("7603021234", "Alhambra Aromes", LocalDate.parse("2019-11-01"));
    Member member2 = new Member("8512021234", "Chamade Coriola", LocalDate.parse("2017-03-12"));

    @Test
    public final void getMembershipStatusTest() {

        assertEquals(g.getMembershipStatus(notMember), MembershipStatus.NOT_MEMBER);
        assertEquals(g.getMembershipStatus(member1), MembershipStatus.ACTIVE);
        assertEquals(g.getMembershipStatus(member2), MembershipStatus.FORMER);
        assertNotEquals(g.getMembershipStatus(notMember), MembershipStatus.ACTIVE);
    }

    @Test
    public final void isMemberTest() {

        assertTrue(g.isMember("Bear Belle"));
        assertFalse(g.isMember("Bear "));
        assertFalse(g.isMember("123318327"));
        assertTrue(g.isMember("8512021234"));
    }
}
