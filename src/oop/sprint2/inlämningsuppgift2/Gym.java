package oop.sprint2.inlämningsuppgift2;

import java.time.LocalDate;
import java.util.List;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class Gym {

    boolean test;
    private List<Member> gymMembers;

    public Gym(boolean isTest) {
        this.test = true;
        this.setGymMembers();
    }

    public Gym() {
        this.test = false;
        this.setGymMembers();
    }

    private void setGymMembers() {
        this.gymMembers = this.test ? new FileUtil(true).createListFromFile()
                : new FileUtil().createListFromFile();
    }

    public MembershipStatus getMembershipStatus(String input) {

        if (isMember(input)) {
            Member member = this.getMemberFromList(input);

            LocalDate today = LocalDate.now();
            int year = today.isLeapYear() ? 366 : 365;
            int membershipDays = new TimeUtil().getMembershipDays(member.getLastPayment());

            if (membershipDays - year <= 0)
                return MembershipStatus.ACTIVE;
            else
                return MembershipStatus.FORMER;
        }
        return MembershipStatus.NOT_MEMBER;
    }

    public boolean isMember(String input) {
        input = input.trim();
        boolean isMember = false;
        for (Member m : this.gymMembers) {
            if (input.equalsIgnoreCase(m.getName()) || input.equalsIgnoreCase(m.getPersonalNo())) {
                isMember = true;
                break;
            }
        }
        return isMember;
    }

    public Member getMemberFromList(String input) {
        for (Member m : gymMembers) {
            if (input.equalsIgnoreCase(m.getName()) || input.equalsIgnoreCase(m.getPersonalNo()))
                return m;
        }
        return null;
    }

    public List<Member> getGymMembers() {
        return this.gymMembers;
    }
}
