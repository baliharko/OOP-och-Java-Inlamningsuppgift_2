package oop.sprint2.inlämningsuppgift2;

import java.util.List;
import java.util.Scanner;

/**
 * Inlämningsuppgift_2 <br>
 * baliharko <br>
 * 2020-10-15 <br>
 * 22:25
 */

public class Gym_Main {

    Scanner scan = new Scanner(System.in);

    public void clearTerminal() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void exitPrompt() {
        System.out.println("Vill du avsluta? (j/n)");
        String input = scan.nextLine();
        if (input == null || input.equalsIgnoreCase("j") || input.isBlank())
            System.exit(0);
    }

    // Starts program
    public void init() {
        Gym gym = new Gym();
        FileUtil fileUtil = new FileUtil();

        clearTerminal();

        while (true) {

            // Main menu
            System.out.println("* * * * * * * * * MENY * * * * * * * * *\n");
            System.out.println("Ange 1, 2 eller 3 för att:\n");
            System.out.println("1. Söka efter medlem\n2. Se lista över alla gymbesök\n3. Avsluta");

            String input = scan.nextLine();

            if (input == null || input.isBlank())
                exitPrompt();

            if (input.equalsIgnoreCase("1")) { // Search for visitor in database
                while (true) {
                    clearTerminal();
                    System.out.println("Ange besökarens namn eller personnummer: ");
                    input = scan.nextLine();

                    if (input != null && !input.isBlank()) {

                        switch (gym.getMembershipStatus(input)) {
                            case ACTIVE -> {
                                Member activeMember = gym.getMemberFromList(input);
                                System.out.println(activeMember.getName() +
                                        " är en aktiv medlem. Senaste betalningsdatum: " + activeMember.getLastPayment()
                                        + "\n");

                                System.out.println(activeMember.getName() + "s besöksdatum:");

                                List<GymVisit> visits = fileUtil.getVisitsFromFile();
                                for (GymVisit v : visits) {
                                    if (v.getMember().getPersonalNo().equalsIgnoreCase(activeMember.getPersonalNo()))
                                        System.out.println(v.getDateVisited());
                                }

                                fileUtil.addToVisitsFile(activeMember);
                            }
                            case FORMER -> System.out.println(gym.getMemberFromList(input).getName() +
                                    " är ej längre aktiv medlem. Senaste betalningsdatum: "
                                    + gym.getMemberFromList(input).getLastPayment());

                            case NOT_MEMBER -> System.out.println(
                                    "Besökaren är obehörig och behöver först bli medlem för att få träna.");
                        }
                    }
                    else {
                        System.out.println("Ogiltig inmatning - (tom)");
                    }

                    System.out.println("\n\nVill du söka på ett annat namn eller personnummer? (j/n)");
                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("n") || input.isBlank()) {
                        clearTerminal();
                        break;
                    }
                }
            } else if (input.equalsIgnoreCase("2")) { // See list of gymvisits

                List<GymVisit> visits = fileUtil.getVisitsFromFile();

                clearTerminal();

                System.out.println(String.format("%-20s %-18s %-10s", "Namn", "Personnummer", "Datum"));
                System.out.println("==================================================");

                for (GymVisit v : visits) { // Print all gymvisits
                    System.out.println(v.toString());
                }
                System.out.println("\nTryck [Enter] för att gå till huvudmenyn");
                scan.nextLine();

                clearTerminal();
            } else if (input.equalsIgnoreCase("3")) { // Exit
                clearTerminal();
                exitPrompt();
            } else {
                clearTerminal();
                System.out.println("Ogiltig inmatning - Ange 1,2 eller 3");
            }
        }
    }


    public static void main(String[] args) {
        Gym_Main main = new Gym_Main();
        main.init();
    }
}
