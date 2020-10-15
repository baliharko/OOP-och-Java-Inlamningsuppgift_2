package oop.sprint2.inlämningsuppgift2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-14 <br>
 * 18:34
 */

public class FileUtil implements Serializable{

    public boolean test;
    private String membersPath;
    private String gymVisitsPath;


    public FileUtil(boolean isTest) {
        this.test = isTest;
        this.initMembersPath();
        this.initGymVisitsPath();
    }

    public FileUtil() {
        this.test = false;
        this.initMembersPath();
        this.initGymVisitsPath();
    }

    private void initMembersPath() {
        this.membersPath = this.test ? "test/oop/sprint2/inlämningsuppgift2Test/customersTest.txt" :
                "src/oop/sprint2/inlämningsuppgift2/customers.txt";
    }

    private void initGymVisitsPath() {
        this.gymVisitsPath = this.test ? "test/oop/sprint2/inlämningsuppgift2Test/gymVisitsTest.ser" :
                "src/oop/sprint2/inlämningsuppgift2/gymVisits.ser";
    }

    public List<Member> initMembersList() {

        List<Member> memberList = new ArrayList<>();

        LocalDate dateJoined = null;
        String line1;
        String line2;
        String[] line1Tokens;

        try(Scanner scan = new Scanner(this.getMembersPath())) {
            while(scan.hasNextLine() && !(line1 = scan.nextLine().trim()).isBlank()) {
                line1Tokens = line1.split(",");
                if (scan.hasNextLine() && !(line2 = scan.nextLine().trim()).isBlank())
                    dateJoined = LocalDate.parse(line2);

                memberList.add(new Member(line1Tokens[0].trim(), line1Tokens[1].trim(), dateJoined));
            }
        } catch(Exception e) {
            System.out.println("Kunde inte läsa in från fil.");
            e.printStackTrace();
        }
        return memberList;
    }

    public Path getMembersPath() {
        return Paths.get(this.membersPath);
    }

    public Path getGymVisitsPath() {
        return Paths.get(this.gymVisitsPath);
    }

    public void addToVisitsFile(Member member) {
        List<GymVisit> visits = getVisitsFromFile();
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                this.getGymVisitsPath().toString()))) {

            visits.add(new GymVisit(member));
            out.writeObject(visits);
        } catch(IOException e) {
            System.out.println("Kunde inte skriva till fil.");
            e.printStackTrace();
        }
    }

    public void initVisitsFile() {
        List<GymVisit> list = new ArrayList<>();

        if (!new File(this.gymVisitsPath).exists()) {
            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.gymVisitsPath))) {
                out.writeObject(list);
                out.close();
                System.out.println(" - en ny har skapats @ " + this.gymVisitsPath);

            } catch (IOException e) {
                System.out.println("Kunde inte skriva till filen.");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Ett fel har inträffat.");
                e.printStackTrace();
            }
        }
    }

    public void deleteVisitsFile() {
        try {
            Files.delete(this.getGymVisitsPath());
        } catch(IOException e) {
            System.out.println("Kunde inte radera filen.");
            e.printStackTrace();
        }
    }

    public List<GymVisit> getVisitsFromFile() {
        List<GymVisit> gymVisits = null;
        this.initVisitsFile();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.gymVisitsPath))) {
            gymVisits = (List<GymVisit>) in.readObject();

        } catch(FileNotFoundException e) {
            System.out.println("Kunde inte hitta filen.");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("Kunde inte läsa från fil.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gymVisits;
    }
}
