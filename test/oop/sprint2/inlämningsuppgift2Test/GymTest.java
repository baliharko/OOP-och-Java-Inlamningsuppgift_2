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

    @Test
    public final void getMembershipStatusTest() {

        assertEquals(g.getMembershipStatus("Bali"), MembershipStatus.NOT_MEMBER);
        assertEquals(g.getMembershipStatus("Alhambra Aromes"), MembershipStatus.ACTIVE);
        assertEquals(g.getMembershipStatus("8512021234"), MembershipStatus.FORMER);
        assertNotEquals(g.getMembershipStatus("Chamade Coriola"), MembershipStatus.ACTIVE);
    }

    @Test
    public final void isMemberTest() {

        assertTrue(g.isMember("Bear Belle"));
        assertFalse(g.isMember("Bear "));
        assertFalse(g.isMember("123318327"));
        assertTrue(g.isMember("8512021234"));
    }

    @Test
    public final void getMemberFromListTest() {

        Member member1 = new Member("7603021234", "Alhambra Aromes", LocalDate.parse("2019-11-01"));

        assertNull(g.getMemberFromList("Bali"));
        assertEquals(g.getGymMembers().get(0), g.getMemberFromList("7603021234"));
        assertEquals(g.getGymMembers().get(2), g.getMemberFromList("Chamade Coriola"));
        assertNotEquals(g.getGymMembers().get(1), g.getMemberFromList("Bali"));
        assertEquals(member1.toString(), g.getMemberFromList("Alhambra Aromes").toString());
    }
}
