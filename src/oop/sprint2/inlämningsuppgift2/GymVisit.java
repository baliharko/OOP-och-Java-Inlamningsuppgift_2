package oop.sprint2.inlämningsuppgift2;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class GymVisit implements Serializable {

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

    @Override
    public String toString() {
        return String.format("%-20s %-18s %-10s", this.getMember().getName(), this.member.getPersonalNo(),
                this.dateVisited);
    }
}
