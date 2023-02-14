/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import bsm.entities.Book;
import bsm.entities.Publisher;
import bsm.services.BookServices;
import bsm.services.PublisherServices;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Function {

    private static Readable file;
    //ATTRIBUTES
    int smallChoice;
    Scanner sc = new Scanner(System.in);
    boolean run;
    String userInput;
    File p = new File("D:\\Studying\\Java\\NetBeans\\Project\\Book Store Management\\src\\File\\Publisher.dat");
    File b = new File("D:\\Studying\\Java\\NetBeans\\Project\\Book Store Management\\src\\File\\Book.dat");

    //OBJECT
    Publisher publisher;
    PublisherServices pService = new PublisherServices();
    Book book;
    BookServices bService = new BookServices();

    //COLLECTION
    HashSet<String> setOfPublisherID = new HashSet<>();
    ArrayList<Publisher> listOfPublishers = new ArrayList<>();
    HashSet<String> setOfBookID = new HashSet<>();
    ArrayList<Book> listOfBooks = new ArrayList<>();
    HashMap<String, ArrayList<Book>> author = new HashMap<>();

    //======================FOR PUBLISHER======================
    public void checkP() {
        System.out.println();
        seperator(30);
        System.out.println("For ID: ");
        for (String id : setOfPublisherID) {
            System.out.println(id);
        }
        System.out.println();
        System.out.println("For publisher: ");
        for (Object items : listOfPublishers) {
            System.out.println(items);
        }
        System.out.println("");
        System.out.println(author);
    }

    public void createPublisher() {
        ArrayList<Book> books = new ArrayList<>();
        System.out.println();
        seperator(30);
        publisher = pService.createPublisher(setOfPublisherID);
        setOfPublisherID.add(publisher.getId());
        listOfPublishers.add(publisher);
        author.put(publisher.getId(), books);
    }

    public void deletePublisher() {
        System.out.println();
        seperator(30);
        if (setOfPublisherID.isEmpty()) {
            System.out.println("No data");
            return;
        }
        System.out.print("Enter Publisher's ID: ");
        userInput = sc.nextLine();
        if (setOfPublisherID.add(userInput)) {
            setOfPublisherID.remove(userInput);
            System.out.println("Publisher’s Id does not exist");
        } else {

            //DELETE FROM HASHMAP
            Iterator iter = author.keySet().iterator();
            while (iter.hasNext()) {
                if (iter.next().equals(userInput)) {
                    iter.remove();
                }
            }

            //DETELE FROM LIST
            for (int i = 0; i < listOfPublishers.size(); i++) {
                if (userInput.equals(listOfPublishers.get(i).getId())) {
                    listOfPublishers.remove(i);
                }
            }

            //DELETE FROM ID SET
            for (int i = 0; i < setOfPublisherID.size(); i++) {
                if (setOfPublisherID.contains(userInput)) {
                    setOfPublisherID.remove(userInput);
                }
            }
        }
    }

    public void savePToFile() {
        System.out.println();
        seperator(30);
        boolean append = false;
        int i = 1;
        try (FileWriter fw = new FileWriter(p, append);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println("=====PUBLISHER=====");

            if (listOfPublishers.isEmpty()) {
                System.out.println("No data to save");
                return;
            }

            for (Publisher items : listOfPublishers) {
                pw.println(i + ". " + items.getId() + ", " + items.getName()
                        + ", " + items.getPhone());
                i++;
            }
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Failed!");
        }
    }

    public void loadPFromFile() {
        System.out.println();
        seperator(30);
        try (FileReader fr = new FileReader(p);
                BufferedReader br = new BufferedReader(fr)) {
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Failed!");
        }
    }

    //======================FOR BOOKS======================
    public void checkB() {
        System.out.println();
        seperator(30);
        System.out.println("For ID: ");
        for (String id : setOfBookID) {
            System.out.println(id);
        }
        System.out.println();
        System.out.println("For Books: ");
        for (Object items : listOfBooks) {
            System.out.println(items);
        }
        System.out.println("");
        System.out.println(author);
    }

    public void createBook() {
        book = new Book();
        run = true;
        System.out.println();
        seperator(30);
        if (listOfPublishers.isEmpty()) {
            System.out.println("Create Publisher before create a new book");
            return;
        } else {
            System.out.print("Enter Publisher's ID: ");
            do {
                try {
                    userInput = sc.nextLine();
                    if (setOfPublisherID.add(userInput)) {
                        setOfPublisherID.remove(userInput);
                        throw new Exception();
                    }
                    book.setPublisherID(userInput);
                    run = false;
                } catch (Exception e) {
                    System.out.print("Not found, enter again: ");
                    run = true;
                }
            } while (run == true);

            String publisherID = book.getPublisherID();
            book = bService.createBook(setOfBookID);
            book.setPublisherID(publisherID);
            setOfBookID.add(book.getId());
            listOfBooks.add(book);
            author.get(book.getPublisherID()).add(book);
        }
    }

    public void searchBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        seperator(30);
        if (listOfBooks.isEmpty()) {
            System.out.println("Have no any Book");
            return;
        }
        System.out.println("1- Search book by name.");
        System.out.println("2- Search book by Publisher's ID.");
        System.out.println();
        System.out.print("Your choice: ");
        smallChoice = userChoice(1, 2);
        switch (smallChoice) {

            //SEARCH BOOK BY NAME
            case 1:
                System.out.println();
                seperator(30);
                System.out.print("Enter book name: ");
                userInput = sc.nextLine();

                for (int i = 0; i < listOfBooks.size(); i++) {
                    if (listOfBooks.get(i).getName().contains(userInput)) {
                        System.out.println(listOfBooks.get(i));
                    }
                }
                break;

            //SEARCH BOOK BY PUBLISHER ID    
            case 2:
                System.out.println();
                seperator(30);
                System.out.print("Enter Publisher's ID: ");
                userInput = sc.nextLine();

                if (author.get(userInput) != null) {
                    for (Book x : author.get(userInput)) {
                        System.out.println(x);
                    }
                } else {
                    System.out.println("Not found any books");
                }
        }
    }

    public void updateBook() {
        System.out.println();
        seperator(30);
        if (listOfBooks.isEmpty()) {
            System.out.println("There is no book yet");
            return;
        }

        System.out.print("Enter book ID: ");
        do {
            try {
                userInput = sc.nextLine();
                if (setOfBookID.add(userInput)) {
                    setOfBookID.remove(userInput);
                    System.out.println("Book’s Name does not exist");
                    break;
                } else {
                    Iterator iter = author.keySet().iterator();
                    while (iter.hasNext()) {
                        ArrayList<Book> tempList = author.get(iter.next());
                        for (Book x : tempList) {
                            if (x.getId().equals(userInput)) {
                                book = bService.updateBook(setOfBookID, userInput, x);
                            }
                        }
                    }
                }
                run = false;
            } catch (Exception e) {
                run = true;
            }
        } while (run == true);
    }

    public void deleteBook() {
        System.out.println();
        seperator(30);
        try (FileReader fr = new FileReader(p);
                BufferedReader br = new BufferedReader(fr)) {
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Failed!");
        }
        if (listOfBooks.isEmpty()) {
            System.out.println("There is no book yet");
            return;
        }

        System.out.print("Enter Book's ID: ");
        userInput = sc.nextLine();
        if (setOfBookID.add(userInput)) {
            setOfBookID.remove(userInput);
            System.out.println("Book’s Name does not exist");
            return;
        } else {

            //DELETE FROM HASHMAP
            Iterator iter = author.keySet().iterator();
            while (iter.hasNext()) {
                ArrayList<Book> tempList = author.get(iter.next());
                System.out.println(tempList);
                if (tempList.isEmpty()) {
                    System.out.println("Nothing to delete");
                    break;
                }
                for (int i = 0; i < tempList.size(); i++) {
                    if (tempList.get(i).getId().equals(userInput)) {
                        tempList.remove(i);
                    }
                }
            }

            //DELETE FROM LIST
            for (int i = 0; i < listOfBooks.size(); i++) {
                if (userInput.equals(listOfBooks.get(i).getId())) {
                    listOfBooks.remove(i);
                }
            }

            ////DELETE FROM ID SET
            for (int i = 0; i < setOfBookID.size(); i++) {
                if (setOfBookID.contains(userInput)) {
                    setOfBookID.remove(userInput);
                }
            }
        }
    }

    public void saveBToFile() {
        boolean append = false;
        int i = 1;
        try (FileWriter fw = new FileWriter(b, append);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println("=====BOOKS=====");
            for (Book items : listOfBooks) {
                pw.println(i + ". " + items.getId() + ", " + items.getName() + ", "
                        + items.getPrice() + ", " + items.getQuantity() + ", " + items.getStatus());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success!");
    }

    public void loadBFromFile() {
        System.out.println();
        seperator(30);
        try (FileReader fr = new FileReader(b);
                BufferedReader br = new BufferedReader(fr)) {
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Failed!");
        }
    }

    //======================OTHERS======================
    public static int userChoice(int first, int last) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean run = true;
        do {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < first || choice > last) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.print("Choose the above option. Enter again: ");
                run = true;
            }
        } while (run == true);
        return choice;
    }
    
    public static void seperator(int number) {
        int i;
        for (i = 0; i <= number; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
