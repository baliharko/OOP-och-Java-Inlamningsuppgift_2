package oop.sprint2.inlämningsuppgift2;

import java.time.LocalDate;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class Member {

    private String name;
    private String personalNo;
    private LocalDate dateJoined;
    MembershipStatus status;

    public Member(String name, String personalNo, LocalDate dateJoined) {
        this.name = name;
        this.personalNo = personalNo;
        this.dateJoined = dateJoined;
        this.status = Gym.getMembershipStatus(this);
    }

    public String getName() {
        return this.name;
    }

    public String getPersonalNo() {
        return this.personalNo;
    }
}
