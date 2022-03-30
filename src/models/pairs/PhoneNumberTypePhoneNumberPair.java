package models.pairs;

import models.PhoneNumberType;

public class PhoneNumberTypePhoneNumberPair {
    private PhoneNumberType phoneNumberType;
    private String phoneNumber;

    public PhoneNumberTypePhoneNumberPair(PhoneNumberType phoneNumberType, String phoneNumber) {
        this.phoneNumberType = phoneNumberType;
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
