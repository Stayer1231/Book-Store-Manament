package bsm.main;

import java.io.Serializable;
import java.util.Scanner;

import Others.Menu;
import Others.Function;

public class BookStoreManagement implements Serializable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bigChoice = 0;
        int smallChoice;
        int decision;
        boolean run = true;
        boolean program_executed = true;
        Function p_Function = new Function();

        do {
            System.out.println("=== Book Store Management ===");
            System.out.println();
            Function.seperator(30);
            System.out.println("1- Publishers’ management");
            System.out.println("2- Books management");
            System.out.println("Others- Quit");
            System.out.println();
            System.out.print("Enter your choice: ");

            //CHECK USER INPUT
            do {
                try {
                    bigChoice = Integer.parseInt(sc.nextLine());
                    run = false;
                } catch (NumberFormatException e) {
                    System.out.print("Enter again: ");
                    run = true;
                }
            } while (run == true);

            //INTO SMALL MENU
            switch (bigChoice) {

                //PUBLISHER
                case 1:
                    do {
                        System.out.println();
                        Function.seperator(30);
                        Menu.menu1();
                        smallChoice = Function.userChoice(0, 5);
                        switch (smallChoice) {

                            //CHECK CASE
                            case 0:
                                p_Function.checkP();
                                break;

                            //CREATE PUBLISHER   
                            case 1:
                                p_Function.createPublisher();
                                break;

                            //DELETE PUBLISHER
                            case 2:
                                p_Function.deletePublisher();
                                break;

                            //SAVE TO FILE
                            case 3:
                                p_Function.savePToFile();
                                break;

                            //LOAD FROM FILE
                            case 4:
                                p_Function.loadPFromFile();
                                break;
                        }
                    } while (smallChoice != 5);
                    break;

                //BOOK
                case 2:
                    do {
                        System.out.println();
                        Function.seperator(30);
                        Menu.menu2();
                        smallChoice = Function.userChoice(0, 7);
                        switch (smallChoice) {

                            //CHECK CASE
                            case 0:
                                p_Function.checkB();
                                break;

                            //CREATE BOOK    
                            case 1:
                                p_Function.createBook();
                                break;

                            //SEARCH BOOK
                            case 2:
                                p_Function.searchBook();
                                break;

                            //UPDATE BOOK
                            case 3:
                                p_Function.updateBook();
                                break;

                            //DELETING BOOK
                            case 4:
                                p_Function.deleteBook();
                                break;

                            //SAVE TO FILE
                            case 5:
                                p_Function.saveBToFile();
                                break;

                            //LOAD FROM FILE
                            case 6:
                                p_Function.loadBFromFile();
                                break;
                        }
                    } while (smallChoice != 7);
                    break;

                //IF USER ENTER ANOTHER CHOICE
                default:
                    System.out.println("Do you want to exit?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    decision = Integer.parseInt(sc.nextLine());
                    switch (decision) {
                        case 1:
                            program_executed = false;
                            break;
                        case 2:
                            program_executed = true;
                    }
            }
        } while (program_executed == true);
    }
}
