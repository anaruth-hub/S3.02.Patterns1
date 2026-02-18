package com.ana.patterns.abstractFactory.product;

public class SpainPhone implements Phone {

    private final String number;

    public SpainPhone(String number) {
        this.number = number;
    }

    @Override
    public String format() {
        return "+34 " + number;
    }
}
