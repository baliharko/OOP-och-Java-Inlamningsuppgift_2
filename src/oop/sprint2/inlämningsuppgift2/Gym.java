package oop.sprint2.inlämningsuppgift2;

import java.util.List;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class Gym {

    private List<Member> gymMembers;
    FileUtil fileUtil = new FileUtil();

    public Gym() {
        this.gymMembers = fileUtil.createListFromFile();
    }

    public static MembershipStatus getMembershipStatus(Member member) {
        return null; // Kollar namn, personnr och datum joined och ger tillbaka passande membershipstatus
    }
}
