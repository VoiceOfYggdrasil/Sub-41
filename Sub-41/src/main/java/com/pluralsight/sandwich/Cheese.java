package com.pluralsight.sandwich;

public class Cheese extends Toppings{
    public Cheese(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return .75 * (size / 4);
    }
}
