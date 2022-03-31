package validator;

import java.util.Scanner;

import static validator.Validator.*;

public class GetValidInputs {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String validMenuChoice() {
        String choice = "-1";
        boolean isValidInput = true;
        while (!isValidChoice(choice)) {
            if (!isValidInput) {
                System.out.println("You can input only one digit number between 0 and 5 or 9.");
            }
            System.out.print("Enter your choice: ");
            choice = SCANNER.nextLine();
            isValidInput = false;
        }
        SCANNER.close();
        return choice;
    }

    public static String validContactName() {
        String contactName = "";
        boolean isValidInput = true;
        while (!isValidContactName(contactName)) {
            if (!isValidInput) {
                System.out.println("You can input anything with a length between 1 and 50.");
            }
            System.out.print("Enter contact name: ");
            contactName = SCANNER.nextLine();
            isValidInput = false;
        }
        SCANNER.close();
        return contactName;
    }

    public static int validCreateChoice() {
        int createChoice = -1;
        boolean isValidInput = true;
        while (!isValidCreateChoice(createChoice)) {
            if (!isValidInput) {
                System.out.println("You can input only one digit number between 1 and 3.");
            }
            System.out.print("Enter your choice: ");
            createChoice = SCANNER.nextInt();
            isValidInput = false;
        }
        SCANNER.close();
        return createChoice;
    }
}
