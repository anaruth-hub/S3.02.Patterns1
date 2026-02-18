package com.ana.patterns.abstractFactory.factory;

import com.ana.patterns.abstractFactory.product.*;

public class USAContactFactory implements ContactFactory {

    private final String street;
    private final String city;
    private final String statePostal;
    private final String phoneNumber;

    public USAContactFactory(String street, String city, String statePostal, String phoneNumber) {
        this.street = street;
        this.city = city;
        this.statePostal = statePostal;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Address createAddress() {
        return new USAAddress(street, city, statePostal);
    }

    @Override
    public Phone createPhone() {
        return new USAPhone(phoneNumber);
    }
}
