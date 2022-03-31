package models;

import models.pairs.EmailTypeAndEmailPair;
import models.pairs.PhoneNumberTypeAndPhoneNumberPair;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private List<PhoneNumberTypeAndPhoneNumberPair> phoneNumbers = new ArrayList<>();
    private String companyName;
    private List<EmailTypeAndEmailPair> emails = new ArrayList<>();

    public List<PhoneNumberTypeAndPhoneNumberPair> getPhoneNumbers() {
        return phoneNumbers;
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
        return emails;
    }

    public void setEmails(List<EmailTypeAndEmailPair> emails) {
        this.emails = emails;
    }
}
