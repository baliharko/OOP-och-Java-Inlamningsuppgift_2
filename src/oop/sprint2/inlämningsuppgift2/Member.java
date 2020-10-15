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

    public Member(String personalNo, String name, LocalDate dateJoined) {
        this.personalNo = personalNo;
        this.name = name;
        this.dateJoined = dateJoined;
    }

    public String getName() {
        return this.name;
    }

    public String getPersonalNo() {
        return this.personalNo;
    }

    public LocalDate getDateJoined() {
        return this.dateJoined;
    }

    @Override
    public String toString() {
        return this.getPersonalNo() + " " + this.getName() + " " + this.getDateJoined();
    }
}
