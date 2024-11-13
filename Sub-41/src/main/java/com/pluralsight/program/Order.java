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

    public void checkOut(){

    }
}
