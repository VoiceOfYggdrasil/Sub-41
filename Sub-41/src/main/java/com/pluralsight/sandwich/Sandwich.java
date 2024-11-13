package com.pluralsight.sandwich;

import java.util.List;

public class Sandwich implements com.pluralsight.program.IPrice {
    private String bread;
    private int size;
    private List<Toppings> toppings;
    private boolean isToasted;

    public Sandwich(String bread, int size, List<Toppings> toppings, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }

    public String getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    private double sandwichPriceSize() {
        switch (size) {
            case 4:
                return 5.50;
            case 8:
                return 7.00;
            case 12:
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
