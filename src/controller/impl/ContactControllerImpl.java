package controller.impl;

import controller.ContactController;
import model.Contact;
import model.pair.IdAndContactNamePair;
import service.ContactService;

import java.util.Map;
import java.util.TreeMap;

import static service.PhoneBookDBService.*;
import static validator.GetValidInputs.*;

public class ContactControllerImpl implements ContactController {

    ContactService contactService = new ContactService();


    @Override
    public void create(String contactName) {
        IdAndContactNamePair idAndContactNamePair = new IdAndContactNamePair(contactName);
        Contact contact = new Contact();
        while (true) {
            contactService.showActionsListForCreate();
            int createChoice = validChoice(0, 4);
            switch (createChoice) {
                case 1:
                    contactService.addPhoneNumberToContact(contact);
                    break;
                case 2:
                    contactService.addEmailToContact(contact);
                    break;
                case 3:
                    String companyName = validCompanyName();
                    contact.setCompanyName(companyName);
                    break;
                case 4:
                    idAndContactNamePair.removeLastElementOfIdList();
                    return;
                case 0:
                    addIdCntNamePairAndContactToContacts(idAndContactNamePair, contact);
                    System.out.printf("Contact %s successfully saved.\n", contactName);
                    return;
            }
        }
    }

    @Override
    public TreeMap<IdAndContactNamePair, Contact> search() {
        while (true) {
            contactService.showActionsListForSearch();
            int searchChoice = validChoice(0, 4);
            if (searchChoice == 0) {
                return null;
            }
            String searchValue = validSearchValue();
            switch (searchChoice) {
                case 1:
                    return searchInContactsByName(searchValue);
                case 2:
                    return searchInContactsByPhoneNumber(searchValue);
                case 3:
                    return searchInContactsByEmail(searchValue);
                case 4:
                    return searchInContactsByCompanyName(searchValue);
            }
        }
    }

    @Override
    public void update() {
        System.out.println("For first you need to find and choose contact that you want to update.");
        TreeMap<IdAndContactNamePair, Contact> searchResult = this.search();
        contactService.printSearchResult(searchResult);
        int size;
        if (searchResult != null && searchResult.size() != 0) {
            size = searchResult.size();
        } else {
            return;
        }
        IdAndContactNamePair oldPair;
        IdAndContactNamePair newPair;
        Contact oldContact;
        Contact newContact;
        if (size == 1) {
            oldPair = searchResult.firstKey();
            oldContact = searchResult.firstEntry().getValue();
        } else {
            System.out.println("\nEnter the appropriate line number of the contact you want to update:\n");
            int contactLineNumber = validChoice(1, searchResult.size());
            Map.Entry<IdAndContactNamePair, Contact> entry =
                    contactService.entryForUpdateOrDelete(searchResult, contactLineNumber);
            assert entry != null;
            oldPair = entry.getKey();
            oldContact = entry.getValue();
        }
        newPair = new IdAndContactNamePair(oldPair);
        newContact = new Contact(oldContact);
        contactService.startMakeChanges(oldPair, oldContact, newPair, newContact);
    }

    @Override
    public void delete() {
        System.out.println("For first you need to find and choose contact that you want to delete.");
        TreeMap<IdAndContactNamePair, Contact> searchResult = this.search();
        contactService.printSearchResult(searchResult);
        int size;
        if (searchResult != null && searchResult.size() != 0) {
            size = searchResult.size();
        } else {
            return;
        }
        IdAndContactNamePair pair;
        if (size == 1) {
            pair = searchResult.firstKey();
        } else {
            System.out.println("\nEnter the appropriate line number of the contact you want to delete:\n");
            int contactLineNumber = validChoice(1, searchResult.size());
            Map.Entry<IdAndContactNamePair, Contact> entry =
                    contactService.entryForUpdateOrDelete(searchResult, contactLineNumber);
            assert entry != null;
            pair = entry.getKey();
        }
        System.out.println("\nEnter the appropriate line number of the action you want to perform:\n" +
                "1. To delete contact.\n" +
                "2. To return main menu.");
        int deleteChoice = validChoice(1, 2);
        if (deleteChoice == 1) {
            deleteEntryInContacts(pair);
            System.out.println("Contact was successfully deleted.");
        }
    }
}
