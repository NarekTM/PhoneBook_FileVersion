package service;

import model.*;
import model.pair.*;

import java.util.*;

import static main.Loader.*;
import static validator.GetValidInputs.*;
import static service.PhoneBookDBService.*;

public class ContactService {

    public void addPhoneNumberToContact(Contact contact) {
        int phoneNumberTypeChoice = choosePhoneNumberType();
        String phoneNumber = validPhoneNumber();
        contact.addElementToPhoneNumbers(phoneNumberTypeChoice, phoneNumber);
    }

    private int choosePhoneNumberType() {
        showPhoneNumberTypes();
        return validChoice(1, 5);
    }

    public void addEmailToContact(Contact contact) {
        int emailTypeChoice = chooseEmailType();
        String email = validEmail();
        contact.addElementToEmails(emailTypeChoice, email);
    }

    private int chooseEmailType() {
        showEmailTypes();
        return validChoice(1, 6);
    }

    public void printSearchResult(TreeMap<IdAndContactNamePair, Contact> treeMap) {
        if (treeMap == null || treeMap.size() == 0) {
            System.out.println(ANSI_RED + "\nThere is no contact matching your input." + ANSI_RESET);
        } else {
            System.out.println("\nSearching result:\n");
            int itemNumber = 0;
            for (IdAndContactNamePair pair : treeMap.navigableKeySet()) {
                System.out.println(++itemNumber + ". " + pair.getContactName() + '\n' + treeMap.get(pair).toString());
            }
        }
    }

    public void startMakeChanges(IdAndContactNamePair oldPair, Contact oldContact,
                                 IdAndContactNamePair newPair, Contact newContact) {
        while (true) {
            showActionsListForUpdate();
            int updateChoice = validChoice(0, 5);
            if (updateChoice == 5) {
                return;
            }
            switch (updateChoice) {
                case 1:
                    String newContactName = validContactName();
                    newPair.setContactName(newContactName);
                    break;
                case 2:
                    makeChangesInPhoneNumbers(newContact);
                    break;
                case 3:
                    makeChangesInEmails(newContact);
                    break;
                case 4:
                    String newCompanyName = validCompanyName();
                    newContact.setCompanyName(newCompanyName);
                    break;
                case 0:
                    replaceEntryInContacts(oldPair, oldContact, newPair, newContact);
                    System.out.println("Contact was successfully updated.");
                    return;
            }
        }
    }

    /**
     * Returns a pair of IdAndContactNamePair and Contact, for performing with it two actions:
     * delete or update.
     *
     * @param treeMap - a result of the search method
     * @param index   - an integer specifying which treemap entry should be returned
     */
    public Map.Entry<IdAndContactNamePair, Contact> entryForUpdateOrDelete(
            TreeMap<IdAndContactNamePair, Contact> treeMap, int index) {
        int indexHelper = 1;
        Set<Map.Entry<IdAndContactNamePair, Contact>> entrySet = treeMap.entrySet();
        for (Map.Entry<IdAndContactNamePair, Contact> currentEntry : entrySet) {
            if (index == indexHelper) {
                return currentEntry;
            }
            indexHelper++;
        }
        return null;
    }

    private void makeChangesInPhoneNumbers(Contact contact) {
        Contact newContact = new Contact(contact);
        List<PhoneNumberTypeAndPhoneNumberPair> phoneNumbers = newContact.getPhoneNumbers();
        while (true) {
            if (phoneNumbers == null) {
                addPhoneNumberToContact(newContact);
            } else {
                showActionsForUpdatingContact();
                int updatePhoneNumberChoice = validChoice(0, 3);
                switch (updatePhoneNumberChoice) {
                    case 0:
                        contact.setPhoneNumbers(newContact.getPhoneNumbers());
                        return;
                    case 1:
                        PhoneNumberTypeAndPhoneNumberPair oldPair =
                                showInfoOfContactForUpdating(newContact.getPhoneNumbers());
                        PhoneNumberType newType = PhoneNumberType.findById(choosePhoneNumberType());
                        String newPhoneNumber = validPhoneNumber();
                        PhoneNumberTypeAndPhoneNumberPair newPair =
                                new PhoneNumberTypeAndPhoneNumberPair(newType, newPhoneNumber);
                        newContact.replaceElementInPhoneNumbers(oldPair, newPair);
                        break;
                    case 2:
                        addPhoneNumberToContact(newContact);
                        break;
                    case 3:
                        return;
                }
            }
        }
    }

    private void makeChangesInEmails(Contact contact) {
        Contact newContact = new Contact(contact);
        List<EmailTypeAndEmailPair> emails = newContact.getEmails();
        while (true) {
            if (emails == null) {
                addEmailToContact(newContact);
            } else {
                showActionsForUpdatingContact();
                int updateEmailChoice = validChoice(0, 3);
                switch (updateEmailChoice) {
                    case 0:
                        contact.setEmails(newContact.getEmails());
                        return;
                    case 1:
                        EmailTypeAndEmailPair oldPair =
                                showInfoOfContactForUpdating(newContact.getEmails());
                        EmailType newType = EmailType.findById(chooseEmailType());
                        String newEmail = validEmail();
                        EmailTypeAndEmailPair newPair =
                                new EmailTypeAndEmailPair(newType, newEmail);
                        newContact.replaceElementInEmails(oldPair, newPair);
                        break;
                    case 2:
                        addEmailToContact(newContact);
                        break;
                    case 3:
                        return;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <E> E showInfoOfContactForUpdating(List<E> infoOfContact) {
        int number = 0;
        Object[] infoArray = new Object[infoOfContact.size()];
        for (E e : infoOfContact) {
            System.out.println(++number + ". " + e.toString());
            infoArray[number - 1] = e;
        }
        int lineNumber = validChoice(1, number);
        return (E) infoArray[lineNumber - 1];
    }

    public void showActionsListForCreate() {
        System.out.println("\nEnter the appropriate line number of the action you want to perform:\n" +
                "1. To enter contact's phone number label and phone number.\n" +
                "2. To enter contact's email label and email.\n" +
                "3. To enter contact's company name.\n" +
                "4. To discard adding and return to main menu.\n" +
                "0. To save contact.");
    }

    public void showActionsListForSearch() {
        System.out.println("\nEnter the appropriate line number of the criteria by which you want to search:\n" +
                "1. Search by contact's name.\n" +
                "2. Search by contact's phone number.\n" +
                "3. Search by contact's email.\n" +
                "4. Search by contact's company name.\n" +
                "0. Finish searching.");
    }

    private void showActionsListForUpdate() {
        System.out.println("\nEnter the appropriate line number of the action you want to perform:\n" +
                "1. To update contact's name.\n" +
                "2. To update contact's phone number label or phone number.\n" +
                "3. To update contact's email label or email.\n" +
                "4. To update contact's company name.\n" +
                "5. To discard changes.\n" +
                "0. To save changes.");
    }

    private void showActionsForUpdatingContact() {
        System.out.println("\nEnter the appropriate line number of the action you want to perform:\n" +
                "1. To update an existing item in the contact.\n" +
                "2. To add a new item to the contact.\n" +
                "3. To discard changes.\n" +
                "0. To save changes.");
    }

    private void showPhoneNumberTypes() {
        System.out.println("\nEnter the appropriate line number to choose phone number label you want:");
        int number = 0;
        for (PhoneNumberType phoneNumberType : PhoneNumberType.values()) {
            System.out.println(++number + ". " + phoneNumberType.getType());
        }
    }

    private void showEmailTypes() {
        System.out.println("\nEnter the appropriate line number to choose email label you want:");
        int number = 0;
        for (EmailType emailType : EmailType.values()) {
            System.out.println(++number + ". " + emailType.getType());
        }
    }
}
