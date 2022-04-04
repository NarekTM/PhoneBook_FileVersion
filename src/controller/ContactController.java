package controller;

import model.Contact;
import model.pair.IdAndContactNamePair;

import java.util.TreeMap;

public interface ContactController {
    void create(String contactName);

    TreeMap<IdAndContactNamePair, Contact> search();

    void update();

    void delete();
}
