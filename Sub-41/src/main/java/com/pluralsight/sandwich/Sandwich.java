package com.pluralsight.sandwich;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements com.pluralsight.program.IPrice {
    private Bread bread;
    private String size;
    private List<Toppings> toppings;
    private boolean isToasted;

    public Sandwich(Bread bread, String size, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = new ArrayList<>();
        this.isToasted = isToasted;
    }

    public Bread getBread() {
        return bread;
    }

    public String getSize() {
        return size;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void addToppings(List<Toppings> toppings) {
        this.toppings.addAll(toppings);
    }

    private double sandwichPriceSize() {
        switch (size) {
            case "4\"":
                return 5.50;
            case "8\"":
                return 7.00;
            case "12\"":
                return 8.50;
            default:
                return 5.50;
        }
    }

    @Override
    public double getPrice() {
        double totalPrice = sandwichPriceSize();
        for (Toppings topping : toppings) {
            totalPrice += topping.calculatePrice(size);
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size=" + size +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}
