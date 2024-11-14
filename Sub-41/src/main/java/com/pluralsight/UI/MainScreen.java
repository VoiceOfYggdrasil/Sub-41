/*package com.pluralsight.UI;

import java.util.Scanner;

public class MainScreen {
    private Scanner scanner = new Scanner(System.in);
    private UserInterface ui;

    public MainScreen(UserInterface ui) {
        this.ui = ui;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Welcome to SUB-41, house of good subs and bad puns! ");
            System.out.println("1. New Order");
            System.out.println("2. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    ui.newOrder();
                    break;
                case "2":
                    System.out.println("Thank you for stopping by!");
                    break;
                default:
                    System.out.println("ERROR: Invalid Choice.");
            }
        }
    }
}*/
