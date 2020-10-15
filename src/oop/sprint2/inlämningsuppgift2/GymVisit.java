package oop.sprint2.inlämningsuppgift2;

import java.time.LocalDate;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class GymVisit {

    private Member member;
    private LocalDate dateVisited;

    public GymVisit(Member member) {
        this.member = member;
        this.dateVisited = LocalDate.now();
    }

    public Member getMember() {
        return this.member;
    }

    public LocalDate getDateVisited() {
        return this.dateVisited;
    }
}
