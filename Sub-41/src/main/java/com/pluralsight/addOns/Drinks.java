package com.pluralsight.addOns;

import com.pluralsight.program.IPrice;

public class Drinks implements IPrice {
    private String type;

    public Drinks(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return 1.5;
    }
}
