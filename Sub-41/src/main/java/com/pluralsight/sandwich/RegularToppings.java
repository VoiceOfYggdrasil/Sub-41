package com.pluralsight.sandwich;

public class RegularToppings extends Toppings{
    public RegularToppings(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        return 0;
    }
}
