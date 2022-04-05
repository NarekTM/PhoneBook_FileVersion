package main;

import controller.ContactController;
import controller.impl.ContactControllerImpl;
import model.Contact;
import model.pair.IdAndContactNamePair;
import service.ContactService;

import java.util.TreeMap;

import static service.PhoneBookDBService.saveContactsToFile;
import static service.PhoneBookDBService.showAllContacts;
import static validator.GetValidInputs.*;

public class Loader {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    public static void start() {
        while (true) {
            showMenu();

            int menuChoice = validChoice(0, 5);

            ContactController contactController = new ContactControllerImpl();
            ContactService contactService = new ContactService();

            switch (menuChoice) {
                case 1:
                    String contactName = validContactName();
                    contactController.create(contactName);
                    break;
                case 2:
                    TreeMap<IdAndContactNamePair, Contact> searchResult = contactController.search();
                    contactService.printSearchResult(searchResult);
                    break;
                case 3:
                    contactController.update();
                    break;
                case 4:
                    contactController.delete();
                    break;
                case 5:
                    showAllContacts();
                    break;
                case 0:
                    saveContactsToFile();

                    System.out.println('\n' + ANSI_PURPLE_BACKGROUND + ANSI_BLACK +
                            "**********************" + ANSI_RESET);
                    System.out.println(ANSI_PURPLE_BACKGROUND + ANSI_BLACK +
                            "*** See you again! ***" + ANSI_RESET);
                    System.out.println(ANSI_PURPLE_BACKGROUND + ANSI_BLACK +
                            "**********************" + ANSI_RESET);

                    System.exit(0);
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nEnter 1 to add a new contact.\n" +
                "Enter 2 to search a contact.\n" +
                "Enter 3 to update a contact.\n" +
                "Enter 4 to delete a contact.\n" +
                "Enter 5 to view contacts list.\n" +
                "Enter 0 to exit from application.");
    }
}
