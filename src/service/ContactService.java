package service;

import models.Contact;
import models.EmailType;
import models.PhoneNumberType;
import models.pairs.IdAndContactNamePair;
import models.pairs.PhoneNumberTypeAndPhoneNumberPair;

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
                    int phoneNumberTypeChoice = validPhoneNumberTypeChoice();
                    String phoneNumber = validPhoneNumber();
                    contact.addElementToPhoneNumbers(phoneNumberTypeChoice, phoneNumber);
                    break;
                case 2:
                    showEmailTypes();
                    int emailTypeChoice = validEmailTypeChoice();
                    String email = validEmail();
                    contact.addElementToEmails(emailTypeChoice, email);
                    break;
                case 3:
                    String companyName = validCompanyName();
                    contact.setCompanyName(companyName);
                    break;
                case 0:
                    addIdCntNamePairAndContactToContacts(idAndContactNamePair, contact);
                    System.out.printf("Contact %s successfully saved.\n", contactName);
                    return;
            }
        }
    }

    public void search(String field) {

    }

    public void update() {

    }

    public void delete() {

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
        for (PhoneNumberType phoneNumberType : PhoneNumberType.values()) {
            System.out.println(++number + ". " + phoneNumberType);
        }
    }

    private void showEmailTypes() {
        System.out.println("Enter the appropriate line number to choose email label you want:");
        int number = 0;
        for (EmailType emailType : EmailType.values()) {
            System.out.println(++number + ". " + emailType);
        }
    }
}
