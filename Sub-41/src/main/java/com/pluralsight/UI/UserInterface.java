package com.pluralsight.UI;

import com.pluralsight.program.Order;

import java.util.Scanner;

public class UserInterface {
    private Order currentOrder;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        this.currentOrder = new Order();
    }

    public void startProgram() {
        displayMainScreen();
    }

    public void displayMainScreen() {
        System.out.println("Welcome to SUB-41, house of good subs and bad puns! ");
        System.out.println("\t1. New Order");
        System.out.println("\t2. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            newOrder();
        } else if (choice == 2) {
            System.out.println("Thank you for stopping by!");
        } else {
            System.out.println("ERROR: Invalid Choice.");
            displayMainScreen();
        }
    }

    public void newOrder() {
        this.currentOrder = new Order();
        displayOrderScreen();
    }

    public void displayOrderScreen() {

    }

    public void addSandwich() {

    }

    public void chooseSandwichSize() {

    }

    public void chooseBread() {

    }

    public void chooseToast() {

    }

    public void chooseMeat() {

    }

    public void chooseCheese() {

    }

    public void chooseSauce() {

    }

    public void chooseRegTopping() {

    }

    public void chooseDrink() {

    }

    public void chooseChips() {

    }

    public void displayCheckoutScreen() {
        
    }
}
