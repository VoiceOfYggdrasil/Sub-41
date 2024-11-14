package com.pluralsight.sandwich;

public abstract class Toppings {
    private String type;

    public Toppings(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract double calculatePrice(String size);
}
