package com.ana.patterns.abstractFactory.product;

public class USAAddress implements Address {

    private final String street;
    private final String city;
    private final String statePostal;

    public USAAddress(String street, String city, String statePostal) {
        this.street = street;
        this.city = city;
        this.statePostal = statePostal;
    }

    @Override
    public String format() {
        return street + ", " + city + ", " + statePostal;
    }
}
