package com.pluralsight.UI;

import com.pluralsight.addOns.Chips;
import com.pluralsight.addOns.Drinks;
import com.pluralsight.program.Order;
import com.pluralsight.sandwich.Bread;
import com.pluralsight.sandwich.Meat;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.Toppings;

import java.util.ArrayList;
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
        System.out.println("How big of a sandwich are we talking?");
        System.out.println("1. 4\"");
        System.out.println("2. 8\"");
        System.out.println("3. 12\"");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return switch (choice) {
            case 1 -> "4\"";
            case 2 -> "8\"";
            case 3 -> "12\"";
            default -> {
                System.out.println("ERROR: Invalid Choice.");
                yield "4\"";
            }
        };
    }

    public String chooseBread() {
        System.out.println("Let's get this bread (literally):");
        System.out.println("1. Italian");
        System.out.println("2. Multigrain");
        System.out.println("3. Rye");
        System.out.println("4. Pretzel");
        System.out.println("5. Flatbread");
        System.out.println("6. Ciabatta");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return switch (choice) {
            case 1 -> "italian";
            case 2 -> "multigrain";
            case 3 -> "rye";
            case 4 -> "pretzel";
            case 5 -> "flatbread";
            case 6 -> "ciabatta";
            default -> {
                System.out.println("ERROR: Invalid Choice.");
                yield "italian";
            }
        };
    }

    public Boolean chooseToast() {
        System.out.println("Anakin or Vader (toasted)?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice == 1;
    }

    public List<Toppings> chooseMeat() {
        List<Toppings> meats = new ArrayList<>();
        System.out.println("WE HAVE THE MEATS (don't sue me please):");
        System.out.println("1. Steak");
        System.out.println("2. Chicken");
        System.out.println("3. Turkey");
        System.out.println("4. Brisket");
        System.out.println("5. Deli");
        System.out.println("PRESS '0' TO END SELECTION");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> meats.add(new Meat("Steak"));
                case 2 -> meats.add(new Meat("Chicken"));
                case 3 -> meats.add(new Meat("Turkey"));
                case 4 -> meats.add(new Meat("Brisket"));
                case 5 -> meats.add(new Meat("Deli"));
                case 0 -> { return meats; }
                default -> System.out.println("ERROR: Invalid Choice.");
                }
            System.out.println("GET THEM MEATS (or type '0' to finish):");
        }
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
