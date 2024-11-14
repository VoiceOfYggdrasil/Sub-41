package com.pluralsight.sandwich;

public class Cheese extends Topping {
    public Cheese(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        switch (size) {
            case "4\"":
                return 0.75;
            case "8\"":
                return 1.5;
            case "12\n":
                return 2.25;
            default:
                return 0.75;
        }
    }
}
