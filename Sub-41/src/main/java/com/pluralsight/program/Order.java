package com.pluralsight.program;

import com.pluralsight.addOns.Chips;
import com.pluralsight.addOns.Drink;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.sandwich.Topping;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double getTotalPrice() {
        double total = 0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    public String newOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order Summary:\n");

        int numOfSandwich = 1;
        for (Sandwich sandwich : sandwiches) {
            summary.append("Sandwich ").append(numOfSandwich++).append(":\n")
                    .append("\tBread: ").append(sandwich.getBread().getType()).append("\n")
                    .append("\tSize: ").append(sandwich.getSize()).append("\n")
                    .append("\tToasted: ").append(sandwich.isToasted() ? "Yes" : "No").append("\n")
                    .append("\tToppings:\n");

            for (Topping topping : sandwich.getToppings()) {
                summary.append("\t\t- ").append(topping.getType()).append("\n");
            }

            summary.append("\tPrice: $").append(sandwich.getPrice()).append("\n\n");
        }

        int numOfDrink = 1;
        for (Drink drink : drinks) {
            summary.append("Drink ").append(numOfDrink++).append(":\n")
                    .append("\tSize: ").append(drink.getSize()).append("\n")
                    .append("\tFlavor: ").append(drink.getFlavor()).append("\n")
                    .append("\tPrice: $").append(drink.getPrice()).append("\n\n");
        }

        int numOfChips = 1;
        for (Chips chip : chips) {
            summary.append("Chips ").append(numOfChips++).append(":\n")
                    .append("\tType: ").append(chip.getType()).append("\n")
                    .append("\tPrice: $").append(chip.getPrice()).append("\n\n");
        }

        summary.append("Total Price: $").append(getTotalPrice()).append("\n");
        return summary.toString();
    }

    public void checkOut(){
        String receipt = newOrderSummary();

        ReceiptFileManager.writeNewReceipt(receipt);
    }
}
