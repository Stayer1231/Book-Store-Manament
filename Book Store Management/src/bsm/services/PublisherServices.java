package bsm.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import bsm.entities.Publisher;
import bsm.util.Validation;

public class PublisherServices extends Publisher {
    public Publisher createPublisher(HashSet set) {
        Scanner sc = new Scanner(System.in);
	Publisher publisher = new Publisher();
	Validation publisherValid = new Validation();
	String ID;
	String name;
	String phone;
	boolean run = true;
		
	do {
            try {
		System.out.print("ID: ");
		publisher.setId(sc.nextLine());
		ID = publisher.getId();
		if (!ID.matches(publisherValid.getPublisherID()) || 
                    ID.isEmpty() || 
                    !publisherValid.checkPublisherID(ID, set)) {
                    throw new Exception();
		}
		run = false;
		} catch (Exception e) {
                    System.out.println("Duplicated, wrong format or empty. "
                            + "Enter again.");
                    run = true;
			}
	} while (run == true);
		
	do {
            try {
                System.out.print("Name: ");
       		publisher.setName(sc.nextLine());
                name = publisher.getName();
                if (!name.matches(publisherValid.getPublisherName())
                    || name.isEmpty()) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Enter again.");
                run = true;
            }
        } while (run == true);
        
        do {
            try {
                System.out.print("Phone: ");
                publisher.setPhone(sc.nextLine());
                phone = publisher.getPhone();
                if (!phone.matches(publisherValid.getPublisherPhone())
                        || phone.isEmpty()) {
                    throw new Exception();
                }
                run = false;
            } catch (Exception e) {
                System.out.println("Enter again.");
                run = true;
            }
        } while (run == true);
        return publisher;
    }
}
