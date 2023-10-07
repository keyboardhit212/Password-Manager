package passwordmanager.cli;

import passwordmanager.utils.Screen;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Home {

    private Home() {}

    public static void main(String[] args) {
        while (true) {
            Screen.clear();
            System.out.println(".....HOME\n");
            displayChoices();
            int choice = inputChoice();
            redirect(choice);
        }
    }

    private static void displayChoices() {
        System.out.println("1. CREATE NEW ENTRY");
        System.out.println("2. VIEW ALL ENTRIES");
        System.out.println("3. EXIT");
        System.out.println("\n");
    }

    private static int inputChoice() {
        int choice = 3;
        Scanner console = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Choice: ");
                choice = console.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice!");
            }
        }
        return choice;
    }

    private static void redirect(int choice) {
        switch (choice) {
            case 1:
                CreateEntry.main();
                break;
            case 2:
                ViewEntry.main();
                break;
            default:
                System.exit(0);
        }
    }
}
