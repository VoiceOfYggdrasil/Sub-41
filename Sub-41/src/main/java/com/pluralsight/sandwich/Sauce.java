package com.pluralsight.sandwich;

public class Sauce extends Topping {
    public Sauce(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        return 0;
    }
}
