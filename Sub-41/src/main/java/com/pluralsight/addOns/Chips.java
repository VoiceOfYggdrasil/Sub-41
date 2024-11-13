package com.pluralsight.addOns;

import com.pluralsight.program.IPrice;

public class Chips implements IPrice {
    private String type;

    public Chips(String type) {
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
