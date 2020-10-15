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
    private List<GymVisit> gymVisits;

    public Gym(boolean isTest) {
        this.test = true;
        this.initGymMembersList();
        this.initGymVisitsList();
    }

    public Gym() {
        this.test = false;
        this.initGymMembersList();
        this.initGymVisitsList();
    }

    // read list of members from file using FileUtil-class
    // checks if instance is test
    private void initGymMembersList() {
        this.gymMembers = this.test ? new FileUtil(true).initMembersList()
                : new FileUtil().initMembersList();
    }

    // read list of gymvisits from file using FileUtil-class
    // checks if instance is test
    private void initGymVisitsList() {
        this.gymVisits = this.test ? new FileUtil(true).getVisitsFromFile()
                : new FileUtil().getVisitsFromFile();
    }

    public MembershipStatus getMembershipStatus(String input) {
        if (isMember(input)) {
            Member member = this.getMemberFromList(input);

            if (new TimeUtil().isWithinOneYear(member.getLastPayment()))
                return MembershipStatus.ACTIVE;
            else
                return MembershipStatus.FORMER;
        }
        return MembershipStatus.NOT_MEMBER;
    }

    // Check if input is in list of members
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

    // Get member from list if found, otherwise returns null
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

    public List<GymVisit> getGymVisits() {
        return this.gymVisits;
    }
}
