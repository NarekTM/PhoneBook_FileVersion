package contacts;

import models.Contact;
import models.pairs.IdContactNamePair;

import java.util.*;

public class PhoneBookDB {
    private static final TreeMap<IdContactNamePair, Contact> CONTACTS = new TreeMap<>();

    public static TreeMap<IdContactNamePair, Contact> getContacts() {
        return CONTACTS;
    }

    public static void addKeyAndValueToContacts(IdContactNamePair idContactPair, Contact contact) {

    }
}
