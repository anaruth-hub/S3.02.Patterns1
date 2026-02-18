package com.ana.patterns.abstractFactory.product;

public class SpainAddress implements Address {

    private final String street;
    private final String city;
    private final String postalCode;

    public SpainAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String format() {
        return street + ", " + postalCode + " " + city;
    }
}
