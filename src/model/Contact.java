package model;

import model.pair.EmailTypeAndEmailPair;
import model.pair.PhoneNumberTypeAndPhoneNumberPair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Serializable {
    private List<PhoneNumberTypeAndPhoneNumberPair> phoneNumbers = new ArrayList<>();
    private String companyName;
    private List<EmailTypeAndEmailPair> emails = new ArrayList<>();

    public List<PhoneNumberTypeAndPhoneNumberPair> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }

    public void setPhoneNumbers(List<PhoneNumberTypeAndPhoneNumberPair> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<EmailTypeAndEmailPair> getEmails() {
        return new ArrayList<>(emails);
    }

    public void setEmails(List<EmailTypeAndEmailPair> emails) {
        this.emails = emails;
    }

    public Contact() {
    }

    public Contact(Contact contact) {
        this.phoneNumbers = contact.getPhoneNumbers();
        this.companyName = contact.getCompanyName();
        this.emails = contact.getEmails();
    }

    public void addElementToPhoneNumbers(int phoneNumberTypeChoice, String phoneNumber) {
        PhoneNumberType phoneNumberType = PhoneNumberType.findById(phoneNumberTypeChoice);
        PhoneNumberTypeAndPhoneNumberPair phoneNumberTypeAndPhoneNumberPair =
                new PhoneNumberTypeAndPhoneNumberPair(phoneNumberType, phoneNumber);
        phoneNumbers.add(phoneNumberTypeAndPhoneNumberPair);
    }

    public void addElementToEmails(int emailTypeChoice, String email) {
        EmailType emailType = EmailType.findById(emailTypeChoice);
        EmailTypeAndEmailPair emailTypeAndEmailPair =
                new EmailTypeAndEmailPair(emailType, email);
        emails.add(emailTypeAndEmailPair);
    }

    public void replaceElementInPhoneNumbers(PhoneNumberTypeAndPhoneNumberPair oldPair,
                                             PhoneNumberTypeAndPhoneNumberPair newPair) {
        int index = this.phoneNumbers.indexOf(oldPair);
        this.phoneNumbers.remove(oldPair);
        this.phoneNumbers.add(index, newPair);
    }

    public void replaceElementInEmails(EmailTypeAndEmailPair oldPair,
                                       EmailTypeAndEmailPair newPair) {
        int index = this.emails.indexOf(oldPair);
        this.emails.remove(oldPair);
        this.emails.add(index, newPair);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PhoneNumberTypeAndPhoneNumberPair pair : phoneNumbers) {
            result.append(pair).append('\n');
        }
        if (companyName != null) {
            result.append("Company: ").append(companyName).append('\n');
        }
        for (EmailTypeAndEmailPair pair : emails) {
            result.append(pair).append('\n');
        }
        return result.toString();
    }
}
