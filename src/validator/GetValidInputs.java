package validator;

import java.util.Scanner;

import static validator.Validator.*;

public final class GetValidInputs {
    private static final Scanner SCANNER = new Scanner(System.in);

    private GetValidInputs() {}

    public static int validMenuChoice() {
        int menuChoice = -1;
        boolean isValidInput = true;
        while (!isValidChoice(0, 6, menuChoice)) {
            if (!isValidInput) {
                System.out.println("You can input only one digit number between 0 and 6.");
            }
            System.out.print("Enter your choice: ");
            menuChoice = SCANNER.nextInt();
            isValidInput = false;
        }
        SCANNER.close();
        return menuChoice;
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
        while (!isValidChoice(0, 3, createChoice)) {
            if (!isValidInput) {
                System.out.println("You can input only one digit number between 0 and 3.");
            }
            System.out.print("Enter your choice: ");
            createChoice = SCANNER.nextInt();
            isValidInput = false;
        }
        SCANNER.close();
        return createChoice;
    }

    public static int validPhoneNumberTypeChoice() {
        int phoneNumberTypeChoice = -1;
        boolean isValidInput = true;
        while (!isValidChoice(1, 5, phoneNumberTypeChoice)) {
            if (!isValidInput) {
                System.out.println("You can input only one digit number between 1 and 5.");
            }
            System.out.print("Enter your choice: ");
            phoneNumberTypeChoice = SCANNER.nextInt();
            isValidInput = false;
        }
        SCANNER.close();
        return phoneNumberTypeChoice;
    }

    public static String validPhoneNumber() {
        String phoneNumber = "";
        boolean isValidInput = true;
        while (!isValidPhoneNumber(phoneNumber)) {
            if (!isValidInput) {
                System.out.println("You can input only numbers and this 4 symbols +, (), - and space.");
            }
            System.out.print("Enter phone number: ");
            phoneNumber = SCANNER.nextLine();
            isValidInput = false;
        }
        SCANNER.close();
        return phoneNumber;
    }

    public static int validEmailTypeChoice() {
        int emailTypeChoice = -1;
        boolean isValidInput = true;
        while (!isValidChoice(1, 6, emailTypeChoice)) {
            if (!isValidInput) {
                System.out.println("You can input only one digit number between 1 and 6.");
            }
            System.out.print("Enter your choice: ");
            emailTypeChoice = SCANNER.nextInt();
            isValidInput = false;
        }
        SCANNER.close();
        return emailTypeChoice;
    }

    public static String validEmail() {
        String email = "";
        boolean isValidInput = true;
        while (!isValidEmail(email)) {
            if (!isValidInput) {
                System.out.println("You can input only latin letters, numbers and this symbols . _ % + - before @ " +
                        "with length between 6 and 30, after it you can input latin letters, numbers and symbols . - " +
                        "for domain name with length between 2 and 30 and only latin letters for " +
                        "domain name extension with length between 2 and 6.");
            }
            System.out.print("Enter email: ");
            email = SCANNER.nextLine();
            isValidInput = false;
        }
        SCANNER.close();
        return email;
    }

    public static String validCompanyName() {
        String companyName = "";
        boolean isValidInput = true;
        while (!isValidCompanyName(companyName)) {
            if (!isValidInput) {
                System.out.println("You can input anything with a length between 1 and 50.");
            }
            System.out.print("Enter company name: ");
            companyName = SCANNER.nextLine();
            isValidInput = false;
        }
        SCANNER.close();
        return companyName;
    }
}
