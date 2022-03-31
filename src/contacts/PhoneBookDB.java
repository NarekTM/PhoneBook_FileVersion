package contacts;

import models.Contact;
import models.pairs.IdAndContactNamePair;

import java.util.*;

public class PhoneBookDB {
    private static final TreeMap<IdAndContactNamePair, Contact> CONTACTS = new TreeMap<>();

    public static TreeMap<IdAndContactNamePair, Contact> getContacts() {
        return CONTACTS;
    }

    public static void addIdCntNamePairAndContactToContacts(IdAndContactNamePair idAndContactPair, Contact contact) {

    }
}
