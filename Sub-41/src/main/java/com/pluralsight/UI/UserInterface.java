package com.pluralsight.UI;

import com.pluralsight.addOns.Chips;
import com.pluralsight.addOns.Drink;
import com.pluralsight.program.Order;
import com.pluralsight.program.ReceiptFileManager;
import com.pluralsight.sandwich.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Order currentOrder;
    private Scanner scanner = new Scanner(System.in);

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
            System.exit(0);
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

    public List<Topping> chooseMeat() {
        List<Topping> meats = new ArrayList<>();
        System.out.println("WE HAVE THE MEATS (don't sue me please):");
        System.out.println("1. Steak");
        System.out.println("2. Chicken");
        System.out.println("3. Turkey");
        System.out.println("4. Brisket");
        System.out.println("5. Deli");
        System.out.println("6. Bacon");
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
                case 6 -> meats.add(new Meat("Bacon"));
                case 0 -> { return meats; }
                default -> System.out.println("ERROR: Invalid Choice.");
                }
            System.out.println("GET THEM MEATS (or type '0' to finish):");
        }
    }

    public List<Topping> chooseCheese() {
        List<Topping> cheeses = new ArrayList<>();
        System.out.println("CHEEEEEEEEEESE, Gromit:");
        System.out.println("1. American");
        System.out.println("2. Swiss");
        System.out.println("3. Provolone");
        System.out.println("4. Mozzarella");
        System.out.println("5. Cheddar");
        System.out.println("PRESS '0' TO END SELECTION");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> cheeses.add(new Cheese("American"));
                case 2 -> cheeses.add(new Cheese("Swiss"));
                case 3 -> cheeses.add(new Cheese("Provolone"));
                case 4 -> cheeses.add(new Cheese("Mozzarella"));
                case 5 -> cheeses.add(new Cheese("Cheddar"));
                case 0 -> { return cheeses; }
                default -> System.out.println("ERROR: Invalid Choice.");
            }
            System.out.println("Dost thou want more (press '0' to finish):");
        }
    }

    public List<Topping> chooseSauce() {
        List<Topping> sauces = new ArrayList<>();
        System.out.println("Sauces. For when you want your sandwich to be wetter:");
        System.out.println("1. Aioli");
        System.out.println("2. Thousand Island");
        System.out.println("3. Oil");
        System.out.println("4. Dijon Mustard");
        System.out.println("5. Ranch");
        System.out.println("PRESS '0' TO END SELECTION");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> sauces.add(new Sauce("Aioli"));
                case 2 -> sauces.add(new Sauce("Thousand Island"));
                case 3 -> sauces.add(new Sauce("Oil"));
                case 4 -> sauces.add(new Sauce("Dijon Mustard"));
                case 5 -> sauces.add(new Sauce("Ranch"));
                case 0 -> { return sauces; }
                default -> System.out.println("ERROR: Invalid Choice.");
            }
            System.out.println("Dost thou want for more sauce (press '0' to finish):");
        }
    }

    public List<Topping> chooseRegTopping() {
        List<Topping> regToppings = new ArrayList<>();
        System.out.println("Free Toppings (ya cheapskate):");
        System.out.println("1. Lettuce (Not Shredded)");
        System.out.println("2. Tomatoes");
        System.out.println("3. Onions");
        System.out.println("4. Spinach");
        System.out.println("5. Mushrooms");
        System.out.println("6. Pickles");
        System.out.println("PRESS '0' TO END SELECTION");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> regToppings.add(new RegularTopping("Lettuce"));
                case 2 -> regToppings.add(new RegularTopping("Tomatoes"));
                case 3 -> regToppings.add(new RegularTopping("Onions"));
                case 4 -> regToppings.add(new RegularTopping("Spinach"));
                case 5 -> regToppings.add(new RegularTopping("Mushrooms"));
                case 6 -> regToppings.add(new RegularTopping("Pickles"));
                case 0 -> { return regToppings; }
                default -> System.out.println("ERROR: Invalid Choice.");
            }
            System.out.println("Dost thou want more (press '0' to finish):");
        }
    }

    public Drink chooseDrink() {
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        String size;
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sizeChoice) {
            case 1 -> size = "Small";
            case 2 -> size = "Medium";
            case 3 -> size = "Large";
            default -> {
                System.out.println("ERROR: Invalid Choice.");
                size = "Small";
            }
        }

        System.out.println("DRINKS FOR THE DRINK GOD:");
        System.out.println("1. RC Cola");
        System.out.println("2. Sprite");
        System.out.println("3. Barq's");
        System.out.println("4. Arizona");
        System.out.println("5. Vitamin Water");
        System.out.println("6. Red Bull");
        System.out.println("7. Water");
        System.out.println("PRESS '0' TO END SELECTION");

        String type;
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (typeChoice) {
            case 1 -> type = "RC Cola";
            case 2 -> type = "Sprite";
            case 3 -> type = "Barq's";
            case 4 -> type = "Arizona";
            case 5 -> type = "Vitamin Water";
            case 6 -> type = "Red Bull";
            case 7 -> type = "Water";
            default -> {
                System.out.println("ERROR: Invalid Choice.");
                type = "Water";
            }
        }
        return new Drink(size, type);
    }

    public Chips chooseChips() {
        System.out.println("CHIPS FOR THE STARCH THRONE:");
        System.out.println("1. Lay's");
        System.out.println("2. Snyder's");
        System.out.println("3. UTZ");
        System.out.println("4. Cheetos");
        System.out.println("5. Cheez-Its");
        System.out.println("6. Pretzels");
        System.out.println("7. Sun Chips");
        System.out.println("PRESS '0' TO END SELECTION");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return switch (choice) {
            case 1 -> new Chips("Lay's");
            case 2 -> new Chips("Snyder's");
            case 3 -> new Chips("UTZ");
            case 4 -> new Chips("Cheetos");
            case 5 -> new Chips("Cheez-Its");
            case 6 -> new Chips("Pretzels");
            case 7 -> new Chips("Sun Chips");
            default -> {
                System.out.println("ERROR: Invalid Choice.");
                yield new Chips("Lay's");
            }
        };
    }

    public void displayCheckoutScreen() {
        System.out.println("Checkout Summary:");
        String orderSummary = currentOrder.newOrderSummary();
        System.out.println(orderSummary);

        System.out.print("Confirm Order? (Y or N): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equalsIgnoreCase("y")) {
            ReceiptFileManager.writeNewReceipt(orderSummary);
            displayMainScreen();
        } else if (confirm.equalsIgnoreCase("n")) {
            System.out.println("Order Canceled. No Worries.");
            displayOrderScreen();
        } else {
            System.out.println("ERROR: Invalid Choice.");
            displayCheckoutScreen();
        }
    }
}
