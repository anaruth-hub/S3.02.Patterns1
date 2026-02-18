package com.ana.patterns.abstractFactory;

import com.ana.patterns.abstractFactory.factory.*;
import com.ana.patterns.abstractFactory.model.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void shouldFormatSpainContact() {
        ContactFactory factory =
                new SpainContactFactory("Carrer Major 34", "Barcelona", "08001", "123456789");

        Contact contact = new Contact(factory);

        assertTrue(contact.toString().contains("+34"));
        assertTrue(contact.toString().contains("08001 Barcelona"));
    }

    @Test
    void shouldFormatUSAContact() {
        ContactFactory factory =
                new USAContactFactory("154 5th Avenue", "New York", "NY 10001", "987654321");

        Contact contact = new Contact(factory);

        assertTrue(contact.toString().contains("+1"));
        assertTrue(contact.toString().contains("New York"));
    }
}
