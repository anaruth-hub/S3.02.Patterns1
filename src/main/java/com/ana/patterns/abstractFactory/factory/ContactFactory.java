package com.ana.patterns.abstractFactory.factory;

import com.ana.patterns.abstractFactory.product.Address;
import com.ana.patterns.abstractFactory.product.Phone;

public interface ContactFactory {
    Address createAddress();
    Phone createPhone();
}
