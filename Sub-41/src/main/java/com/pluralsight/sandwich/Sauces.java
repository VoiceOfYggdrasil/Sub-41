package com.pluralsight.sandwich;

public class Sauces extends Toppings{
    public Sauces(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return 0;
    }
}
