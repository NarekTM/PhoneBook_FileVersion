package main;

import contacts.PhoneBookDB;
import models.Contact;
import models.pairs.IdAndContactNamePair;
import service.ContactService;

import java.util.TreeMap;

import static validator.GetValidInputs.*;

public class Loader {
    public static void start() {
        showMenu();

        while (true) {
            int menuChoice = validChoice(0, 6);

            ContactService contactService = new ContactService();

            switch (menuChoice) {
                case 1:
                    String contactName = validContactName();
                    contactService.create(contactName);
                    break;
                case 2:
                    contactService.search();
                    break;
                case 3:
                    contactService.update();
                    break;
                case 4:
                    contactService.delete();
                    break;
                case 5:
                    TreeMap<IdAndContactNamePair, Contact> contacts = PhoneBookDB.getContacts();
                    showContacts(contacts);
                    break;
                case 6:
                    showMenu();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void showMenu() {
        System.out.println("Enter 1 to add a new contact.\n" +
                "Enter 2 to search a contact.\n" +
                "Enter 3 to update a contact.\n" +
                "Enter 4 to delete a contact.\n" +
                "Enter 5 to view contacts list.\n" +
                "Enter 6 to view the menu list.\n" +
                "Enter 0 to exit from application.");
    }


    //This method maybe needs to change return type to String
    private static void showContacts(TreeMap<IdAndContactNamePair, Contact> contacts) {

    }
}
