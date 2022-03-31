package service;

import models.Contact;
import models.PhoneNumberType;
import models.pairs.IdAndContactNamePair;

import static validator.GetValidInputs.*;
import static contacts.PhoneBookDB.*;

public class ContactService {
    public void create(String contactName) {
        IdAndContactNamePair idAndContactNamePair = new IdAndContactNamePair(contactName);
        Contact contact = new Contact();
        while (true) {
            showActionsListForCreate();
            int createChoice = validCreateChoice();
            switch (createChoice) {
                case 1:
                    showPhoneNumberTypes();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    addIdCntNamePairAndContactToContacts(idAndContactNamePair, contact);
                    System.out.printf("Contact %s successfully saved.\n", contactName);
                    return;
            }
        }
    }

    private void showActionsListForCreate() {
        System.out.println("Enter the number of the action you want to perform:\n" +
                "1. To enter contact's phone number label and phone number.\n" +
                "2. To enter contact's email label and email.\n" +
                "3. To enter contact's company name.\n" +
                "0. To save contact.");
    }

    private void showPhoneNumberTypes() {
        System.out.println("Enter the appropriate line number to choose phone number label you want:");
        int number = 0;
        PhoneNumberType[] phoneNumberTypes = PhoneNumberType.values();
        for (PhoneNumberType phoneNumberType : phoneNumberTypes) {
            System.out.println(++number + ". " + phoneNumberType);
        }
    }

    public void update() {

    }

    public void delete() {

    }

    public void search(String field) {

    }


}
