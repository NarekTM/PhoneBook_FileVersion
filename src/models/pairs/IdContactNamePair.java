package models.pairs;

import java.util.ArrayList;

public class IdContactNamePair implements Comparable<IdContactNamePair> {
    private String contactName;
    private final int id;
    private static final ArrayList<Integer> ID_LIST = new ArrayList<>();

    public IdContactNamePair(String contactName) {
        this.contactName = contactName;
        addElementToIdList();
        this.id = ID_LIST.get(ID_LIST.size() - 1);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getId() {
        return id;
    }

    private void addElementToIdList() {
        int size = ID_LIST.size();
        if (size == 0) {
            ID_LIST.add(1);
        } else {
            int lastElement = ID_LIST.get(size - 1);
            ID_LIST.add(lastElement + 1);
        }
    }

    @Override
    public int compareTo(IdContactNamePair o) {
        return this.contactName.compareTo(o.contactName);
    }
}
