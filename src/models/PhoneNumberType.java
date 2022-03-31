package models;

public enum PhoneNumberType {
    MOBILE("Mobile"),
    HOME("Home"),
    WORK("Work"),
    SCHOOL("School"),
    OTHER("Other");

    private final String type;

    private PhoneNumberType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return type;
    }
}
