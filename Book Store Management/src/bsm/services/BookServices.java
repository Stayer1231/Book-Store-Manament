package bsm.services;

import java.util.HashSet;
import java.util.Scanner;
import bsm.entities.Book;
import bsm.util.Validation;

public class BookServices {

    Scanner sc = new Scanner(System.in);
    String ID;
    String name;
    String status;
    double price;
    int quantity;
    boolean updateID;

    public Book createBook(HashSet set) {
        Book book = new Book();
        Validation bookValid = new Validation();
        boolean run = true;

        //ID
        do {
            try {
                System.out.print("ID: ");
                book.setId(sc.nextLine());
                ID = book.getId();
                if (!ID.matches(bookValid.getBookID())
                        || !bookValid.checkBookID(ID, set)
                        || ID.isEmpty()) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Wrong format, duplicated ID or empty. Enter again");
                run = true;
            }
        } while (run == true);

        //NAME
        do {
            try {
                System.out.print("Name: ");
                book.setName(sc.nextLine());
                name = book.getName();
                if (!name.matches(bookValid.getBookName()) || name.isEmpty()) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Wrong format or empty. Enter again");
                run = true;
            }
        } while (run == true);

        //PRICE
        do {
            try {
                System.out.print("Price: ");
                book.setPrice(Double.parseDouble(sc.nextLine()));
                price = book.getPrice();
                if (price <= 0) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Price must be greater than 0. Enter again");
                run = true;
            }
        } while (run == true);

        //QUANTITY
        do {
            try {
                System.out.print("Quantity: ");
                book.setQuantity(Integer.parseInt(sc.nextLine()));
                quantity = book.getQuantity();
                if (quantity <= 0) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Quantity must be greater than 0. Enter again");
                run = true;
            }
        } while (run == true);
        
        //STATUS
        do {
            try {
                System.out.print("Status (Avaiable or Not avaiable): ");
                book.setStatus(sc.nextLine());
                status = book.getStatus();
                if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Not available")) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Wrong, Enter again");
                run = true;
            }
        } while (run == true);
        return book;
    }

    public Book updateBook(HashSet set, String ID, Book book) {
        String inputString;
        Validation bookValid = new Validation();
        boolean run = true;

        //NAME
        do {
            try {
                System.out.print("Name: ");
                inputString = sc.nextLine();
                if (inputString.isEmpty()) {
                    break;
                } else {
                    name = inputString;
                    if (!name.matches(bookValid.getBookName())) {
                        throw new Exception();
                    } else {
                        book.setName(name);
                    }
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Wrong format or empty. Enter again");
                run = true;
            }
        } while (run == true);

        //PRICE
        do {
            try {
                System.out.print("Price: ");
                inputString = sc.nextLine();
                if (inputString.isEmpty()) {
                    break;
                } else {
                    price = Double.parseDouble(inputString);
                    if (price < 0) {
                        throw new Exception();
                    } else {
                        book.setPrice(price);
                    }
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Price must be greater than 0. Enter again");
                run = true;
            }
        } while (run == true);

        //QUANTITY
        do {
            try {
                System.out.print("Quantity: ");
                inputString = sc.nextLine();
                if (inputString.isEmpty()) {
                    break;
                } else {
                    quantity = Integer.parseInt(inputString);
                    if (quantity < 0) {
                        throw new Exception();
                    } else {
                        book.setQuantity(quantity);
                    }
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Quantity must be greater than 0. Enter again");
                run = true;
            }
        } while (run == true);
        
        //STATUS
        do {
            try {
                System.out.print("Status: ");
                inputString = sc.nextLine();
                if (inputString.isEmpty()) {
                    break;
                } else {
                    status = inputString;
                    if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Not available")) {
                        throw new Exception();
                    } else {
                        book.setStatus(status);
                    }
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Wrong, Enter again");
                run = true;
            }
        } while (run == true);
        return book;
    }
}
