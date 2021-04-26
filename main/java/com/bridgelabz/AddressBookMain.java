package com.bridgelabz;
import java.util.*;
public class AddressBookMain{

    /* This is the method used to creation of contact object by using system console
    @param scanner class object
    @return Contact onject
    */

    public Contact createContact(Scanner consoleInputOutputReader){
        Contact contact=new Contact();
        System.out.println("Please enter the below details");
        System.out.println("Firstname");
        String fname=consoleInputOutputReader.next();
        contact.firstname=fname;
        System.out.println("lastname");
        String lname=consoleInputOutputReader.next();
        contact.lastname=lname;
        System.out.println("city");
        String city=consoleInputOutputReader.next();
        contact.city=city;
        System.out.println("state");
        String state=consoleInputOutputReader.next();
        contact.state=state;
        System.out.println("zip");
        int zip=consoleInputOutputReader.nextInt();
        contact.zip=zip;
        System.out.println("phoneNumber");
        String phoneNumber=consoleInputOutputReader.next();
        contact.PhoneNumber = phoneNumber;
        System.out.println("email");
        String email=consoleInputOutputReader.next();
        contact.email= email;
        return contact;
    }

    public Contact createContact(String firstname, String lastname, String city, String state, int zip, String mob, String email){
        Contact contact=new Contact();
        contact.firstname = firstname;
        contact.lastname = lastname;
        contact.city = city;
        contact.state = state;
        contact.zip = zip;
        contact.PhoneNumber = mob;
        contact.email = email;
        return contact;
    }

    public static void main(String[] args) {
        Book book=new Book();
        Scanner consoleInputOutputReader= new Scanner(System.in);
        AddressBookMain addressBookMain=new AddressBookMain();
        book.addNewContact(addressBookMain.createContact(consoleInputOutputReader));
        book.addNewContact(addressBookMain.createContact(consoleInputOutputReader));
        book.printContactList();
    }

}
