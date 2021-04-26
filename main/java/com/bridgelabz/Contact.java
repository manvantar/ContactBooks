package com.bridgelabz;

import java.util.Objects;

public class Contact {
    String firstname;
    String lastname;
    String city;
    String state;
    int zip;
    String PhoneNumber;
    String email;

    public Contact(String firstname, String lastname, String city, String state, int zip, String mob, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.PhoneNumber = mob;
        this.email = email;
    }

    public Contact() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return zip == contact.zip && Objects.equals(firstname, contact.firstname) && Objects.equals(lastname, contact.lastname) && Objects.equals(city, contact.city) && Objects.equals(state, contact.state) && Objects.equals(PhoneNumber, contact.PhoneNumber) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, city, state, zip, PhoneNumber, email);
    }
}
