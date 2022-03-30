package models;

public enum EmailType {
    GMAIL("Gmail"),
    MAILRU("Mail.ru"),
    OUTLOOK("Outlook"),
    ICLOUD("iCloud"),
    YAHOO("Yahoo"),
    OTHER("Other");

    private final String type;

    private EmailType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
