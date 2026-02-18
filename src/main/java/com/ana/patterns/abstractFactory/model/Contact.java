package com.ana.patterns.abstractFactory.model;

import com.ana.patterns.abstractFactory.factory.ContactFactory;
import com.ana.patterns.abstractFactory.product.Address;
import com.ana.patterns.abstractFactory.product.Phone;

public class Contact {

    private final Address address;
    private final Phone phone;

    public Contact(ContactFactory factory) {
        this.address = factory.createAddress();
        this.phone = factory.createPhone();
    }

    @Override
    public String toString() {
        return "Address: " + address.format() +
                " | Phone: " + phone.format();
    }
}
