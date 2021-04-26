package com.bridgelabz;

import com.bridgelabz.ContactBooks.AddressBookMain;
import com.bridgelabz.ContactBooks.Book;
import com.bridgelabz.ContactBooks.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookTester {

    @Test
    public void givenContact_whenadded_shouldReturnTrue(){
        Contact contact1=new Contact("Manu","Kv","Bengalur","Karnataka",
                560076,"9663393660","manukvshetty@gmail.com");
        Contact contact2=new Contact("Srinivar",null,"Bemgaluru","Karnataka",
                560076,"9663393660","srinivar@gmail.com");
        Book book=new Book();
        Assertions.assertTrue(book.addNewContact(contact1));
        Assertions.assertTrue(book.addNewContact(contact2));
        book.printContactList();
    }

    @Test
    public void givenContact_whenUpdated_shouldReturnTrue(){
        Contact contact1=new Contact("Manu","Kv","Bengalur","Karnataka",
                560076,"9663393660","manukvshetty@gmail.com");
        Contact contact2=new Contact("Srinivar",null,"Bemgaluru","Karnataka",
                560076,"9663393660","srinivar@gmail.com");
        Contact contact3=new Contact("inivar",null,"Bemgaluru","Karnataka",
                560076,"9663393660","nivar@gmail.com");
        Book book=new Book();
        book.addNewContact(contact1);
        book.addNewContact(contact2);
        book.addNewContact(contact3);
        book.printContactList();
        Assertions.assertTrue(book.updateContact("Manu","Naanu"));
        Assertions.assertEquals(false,book.updateContact("Manu","Naanu"));
        book.printContactList();
    }


}
