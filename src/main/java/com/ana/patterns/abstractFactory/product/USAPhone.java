package com.ana.patterns.abstractFactory.product;

import com.ana.patterns.abstractFactory.product.Phone;

public class USAPhone implements Phone {

    private final String number;

    public USAPhone(String number) {
        this.number = number;
    }

    @Override
    public String format() {
        return "+1 " + number;
    }
}
