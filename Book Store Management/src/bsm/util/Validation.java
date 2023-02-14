package bsm.util;

import java.util.HashSet;

public class Validation {

    private final String publisherID = "P\\d{5}";
    private final String publisherName = "^[a-zA-Z ]{5,30}$";
    private final String publisherPhone = "\\d{10,12}$";
    private final String bookID = "B\\d{5}";
    private final String bookName = "^[a-zA-Z0-9-+_.'\"?()# ]{5,30}$";

    //PUBLISHER
    public String getPublisherID() {
        return publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherPhone() {
        return publisherPhone;
    }

    public boolean checkPublisherID(String ID, HashSet<String> set) {
        return set.add(ID);
    }

    //BOOK
    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean checkBookID(String ID, HashSet<String> set) {
        return set.add(ID);
    }

}
