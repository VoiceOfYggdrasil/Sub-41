package com.pluralsight.sandwich;

public class Meat extends Toppings{
    public Meat(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        return ((double) size / 4);
    }
}
