package oop.sprint2.inlämningsuppgift2;

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

public class FileUtil {

    public boolean test;
    private String fileInPath;
    private String fileOutPath;


    public FileUtil(boolean isTest) {
        this.test = isTest;
        this.setFileInPath();
        this.setFileOutPath();
    }

    public FileUtil() {
        this.test = false;
        this.setFileInPath();
        this.setFileOutPath();
    }

    private void setFileInPath() {
        this.fileInPath = this.test ? "test/oop/sprint2/inlämningsuppgift2Test/customersTest.txt" :
                "src/oop/sprint2/inlämningsuppgift2/customers.txt";
    }

    private void setFileOutPath() {
        this.fileOutPath = this.test ? "test/oop/sprint2/inlämningsuppgift2Test/gymVisitsTest.txt" :
                "src/oop/sprint2/inlämningsuppgift2/gymVisits.txt";
    }

    public List<Member> createListFromFile() {

        List<Member> memberList = new ArrayList<>();

        LocalDate dateJoined = null;
        String line1;
        String line2;
        String[] line1Tokens;

        try(Scanner scan = new Scanner(this.getFileInPath())) {
            while(scan.hasNextLine() && !(line1 = scan.nextLine().trim()).isBlank()) {
                line1Tokens = line1.split(",");
                if (scan.hasNextLine() && !(line2 = scan.nextLine().trim()).isBlank()) {
                    dateJoined = LocalDate.parse(line2);
                }

                memberList.add(new Member(line1Tokens[0].trim(), line1Tokens[1].trim(), dateJoined));
            }

        } catch(Exception e) {
            System.out.println("Kunde inte läsa in från fil.");
            e.printStackTrace();
        }

        return memberList;
    }

    public Path getFileInPath() {
        return Paths.get(this.fileInPath);
    }

    public Path getFileOutPath() {
        return Paths.get(this.fileOutPath);
    }
}
