package models;

import models.pairs.EmailTypeEmailPair;
import models.pairs.PhoneNumberTypePhoneNumberPair;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private List<PhoneNumberTypePhoneNumberPair> phoneNumbers = new ArrayList<>();
    private String companyName;
    private List<EmailTypeEmailPair> emails = new ArrayList<>();

    public List<PhoneNumberTypePhoneNumberPair> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberTypePhoneNumberPair> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<EmailTypeEmailPair> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailTypeEmailPair> emails) {
        this.emails = emails;
    }
}
