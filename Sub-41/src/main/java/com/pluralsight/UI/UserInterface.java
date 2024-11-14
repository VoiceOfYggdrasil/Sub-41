package com.pluralsight.UI;

import com.pluralsight.addOns.Chips;
import com.pluralsight.addOns.Drinks;
import com.pluralsight.program.Order;
import com.pluralsight.sandwich.Bread;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.Toppings;

import java.util.List;
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
        boolean continueOrder = true;

        while (continueOrder) {
            System.out.println("ORDER MENU:");
            System.out.println("\t1. Build a New Sandwich");
            System.out.println("\t2. Grab a Drink");
            System.out.println("\t3. Want Some Chips With That?");
            System.out.println("\t4. Checkout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSandwich();
                case 2 -> {
                    currentOrder.addDrink(chooseDrink());
                    System.out.println("Drink added to cart.");
                }
                case 3 -> {
                    currentOrder.addChips(chooseChips());
                    System.out.println("Chips added to cart.");
                }
                case 4 -> {
                    displayCheckoutScreen();
                    continueOrder = false;
                }
                default -> System.out.println("ERROR: Invalid Choice.");
            }
        }
    }

    public void addSandwich() {
        String breadType = chooseBread();
        String size = chooseSandwichSize();
        boolean isToasted = chooseToast();
        Sandwich sandwich = new Sandwich(new Bread(breadType), size, isToasted);

        sandwich.addToppings(chooseMeat());
        sandwich.addToppings(chooseCheese());
        sandwich.addToppings(chooseSauce());
        sandwich.addToppings(chooseRegTopping());

        currentOrder.addSandwich(sandwich);
        System.out.println("Sandwich added to cart.");
        displayOrderScreen();
    }

    public String chooseSandwichSize() {

    }

    public String chooseBread() {

    }

    public Boolean chooseToast() {

    }

    public List<Toppings> chooseMeat() {

    }

    public List<Toppings> chooseCheese() {

    }

    public List<Toppings> chooseSauce() {

    }

    public List<Toppings> chooseRegTopping() {

    }

    public Drinks chooseDrink() {

    }

    public Chips chooseChips() {

    }

    public void displayCheckoutScreen() {

    }
}
