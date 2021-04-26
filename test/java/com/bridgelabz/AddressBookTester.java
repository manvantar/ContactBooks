package com.bridgelabz;

import com.bridgelabz.ContactBooks.AddressBookMain;
import com.bridgelabz.ContactBooks.Book;
import com.bridgelabz.ContactBooks.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTester {
    Contact contact1=new Contact("Manu","Kv","Bengaluru","Karnataka",
            560076,"9663393660","manukvshetty@gmail.com");
    Contact contact2=new Contact("Srinivar",null,"Bengaluru","Karnataka",
            560076,"9663393660","srinivar@gmail.com");
    Contact contact3=new Contact("inivar",null,"Mysuru","Karnataka",
            560076,"9663393660","nivar@gmail.com");


    @Test
    public void givenContactToAdd_whenAlredyExists_shouldReturnFalse(){
        Contact contact1=new Contact("Manu","Kv","Bengalur","Karnataka",
                560076,"9663393660","manukvshetty@gmail.com");
        Contact contact2=new Contact("Srinivar",null,"Bemgaluru","Karnataka",
                560076,"9663393660","srinivar@gmail.com");
        Contact contact3=new Contact("inivar",null,"Bemgaluru","Karnataka",
                560076,"9663393660","nivar@gmail.com");
        Contact contact4=new Contact("Manu","Kv","Bengalur","Karnataka",
                560076,"9663393660","manukvshetty@gmail.com");
        Book book=new Book();
        book.addNewContact(contact1);
        Assertions.assertEquals(false,book.addNewContact(contact1));

    }

    @Test
    public void givenContactToSearch_whenExists_shouldReturnContact(){
        Contact contact1=new Contact("Manu","Kv","Bengalur","Karnataka",
                560076,"9663393660","manukvshetty@gmail.com");
        Contact contact2=new Contact("Srinivar",null,"Bemgaluru","Karnataka",
                560076,"9663393660","srinivar@gmail.com");
        Contact contact3=new Contact("inivar",null,"Bemgaluru","Karnataka",
                560076,"9663393660","nivar@gmail.com");
        Contact contact4=new Contact("Manu","Kv","Bengalur","Karnataka",
                560076,"9663393660","manukvshetty@gmail.com");
        Book book=new Book();
        book.addNewContact(contact1);
        book.addNewContact(contact2);
        book.addNewContact(contact3);
        Assertions.assertEquals(contact3,book.checkContactExistsStream(contact3));
    }

    @Test
    public void givenCityToSearch_whenExists_shouldReturnContactList(){
        Book book=new Book();
        book.addNewContact(contact1);
        book.addNewContact(contact3);
        book.addNewContact(contact2);
        List<Contact> cityList=book.checkContactByCityStream("Bengaluru");
        List<Contact> cityList2=book.checkContactByCityStream("Mysuru");
        Assertions.assertEquals(2,cityList.size());
        Assertions.assertEquals(1,cityList2.size());
    }


}
