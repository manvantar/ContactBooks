package com.addressbook;

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
}
