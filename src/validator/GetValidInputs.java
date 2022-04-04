package validator;

import java.util.Scanner;

import static main.Loader.*;
import static validator.Validator.*;

public final class GetValidInputs {
    private static final Scanner SCANNER = new Scanner(System.in);

    private GetValidInputs() {
    }

    public static int validChoice(int min, int max) {
        String choice = "-1";
        boolean isValidInput = true;
        while (!isValidChoice(min, max, choice)) {
            if (!isValidInput) {
                System.out.printf(ANSI_RED +
                        "You can input only one digit number between %d and %d.\n" + ANSI_RESET, min, max);
            }
            System.out.print(ANSI_GREEN + "Enter your choice: " + ANSI_RESET);
            choice = SCANNER.nextLine();
            isValidInput = false;
        }
        return Integer.parseInt(choice);
    }

    public static String validContactName() {
        String contactName = "";
        boolean isValidInput = true;
        while (!isValidContactName(contactName)) {
            if (!isValidInput) {
                System.out.println(ANSI_RED +
                        "You can input anything with a length between 1 and 50." + ANSI_RESET);
            }
            System.out.print("Enter contact name: ");
            contactName = SCANNER.nextLine();
            isValidInput = false;
        }
        return contactName;
    }

    public static String validPhoneNumber() {
        String phoneNumber = "";
        boolean isValidInput = true;
        while (!isValidPhoneNumber(phoneNumber)) {
            if (!isValidInput) {
                System.out.println(ANSI_RED +
                        "You can input only numbers, symbol + (it can be only the first one) and space." + ANSI_RESET);
            }
            System.out.print("Enter phone number: ");
            phoneNumber = SCANNER.nextLine();
            isValidInput = false;
        }
        return phoneNumber;
    }

    public static String validEmail() {
        String email = "";
        boolean isValidInput = true;
        while (!isValidEmail(email)) {
            if (!isValidInput) {
                System.out.println(ANSI_RED +
                        "You can input only latin letters, numbers and this symbols . _ - before @ " +
                        "with length between 6 and 30,\nafter @ you can input latin letters, numbers and symbol - " +
                        "for domain name with length between 2 and 30 and\n only latin letters for " +
                        "domain name extension with length between 2 and 8." + ANSI_RESET);
            }
            System.out.print("Enter email: ");
            email = SCANNER.nextLine();
            isValidInput = false;
        }
        return email;
    }

    public static String validCompanyName() {
        String companyName = "";
        boolean isValidInput = true;
        while (!isValidCompanyName(companyName)) {
            if (!isValidInput) {
                System.out.println(ANSI_RED +
                        "You can input anything with a length between 1 and 50." + ANSI_RESET);
            }
            System.out.print("Enter company name: ");
            companyName = SCANNER.nextLine();
            isValidInput = false;
        }
        return companyName;
    }

    public static String validSearchValue() {
        String searchValue = "";
        boolean isValidInput = true;
        while (searchValue.length() < 1) {
            if (!isValidInput) {
                System.out.println(ANSI_RED +
                        "You can input anything at least with a length of 1." + ANSI_RESET);
            }
            System.out.print("Enter searching value: ");
            searchValue = SCANNER.nextLine();
            isValidInput = false;
        }
        return searchValue;
    }
}
