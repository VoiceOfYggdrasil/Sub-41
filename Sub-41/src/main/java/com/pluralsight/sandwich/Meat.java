package com.pluralsight.sandwich;

public class Meat extends Toppings{
    public Meat(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return .75 * (size / 4);
    }
}
