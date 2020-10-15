package oop.sprint2.inlämningsuppgift2;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class Member implements Serializable {

    private String name;
    private String personalNo;
    private LocalDate lastPayment;

    public Member(String personalNo, String name, LocalDate lastPayment) {
        this.personalNo = personalNo;
        this.name = name;
        this.lastPayment = lastPayment;
    }

    public String getName() {
        return this.name;
    }

    public String getPersonalNo() {
        return this.personalNo;
    }

    public LocalDate getLastPayment() {
        return this.lastPayment;
    }

    @Override
    public String toString() {
        return this.getPersonalNo() + " " + this.getName() + " " + this.getLastPayment();
    }
}
