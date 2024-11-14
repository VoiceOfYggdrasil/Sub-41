package com.pluralsight.program;

import com.pluralsight.addOns.Chips;
import com.pluralsight.addOns.Drinks;
import com.pluralsight.sandwich.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drinks> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drinks drink) {
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
        for (Drinks drink : drinks) {
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
                    .append(" Bread: ").append(sandwich.getBread().getType()).append("\n")
                    .append(" Size: ").append(sandwich.getSize()).append("\n")
                    .append(" Toasted: ").append(sandwich.isToasted() ? "Yes" : "No").append("\n")
                    .append(" Toppings:\n");
        }
    }

    public void checkOut(){
        ReceiptFileManager receiptFileManager = new ReceiptFileManager();

        receiptFileManager.writeNewReceipt(receiptFileManager.printReceipt(this));
    }
}
