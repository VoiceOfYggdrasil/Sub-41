package com.pluralsight.sandwich;

public class Meat extends Topping {
    public Meat(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        switch (size) {
            case "4\"":
                return 1;
            case "8\"":
                return 2;
            case "12\n":
                return 3;
            default:
                return 1;
        }
    }
}
