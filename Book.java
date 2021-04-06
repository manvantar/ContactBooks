package com.addressbook;

import java.util.*;

public class Book {
    static ArrayList<Contact> contactlist = new ArrayList<Contact>();

    public static void main(String[] args) {
        start();
    }
    public static void start() {
        boolean quite = false;
        startPhone();
        printAction();
        Scanner s=new Scanner(System.in);
        while (!quite) {
            System.out.println("\n Enter action: (6 to show available actions)");

            int action =s.nextInt();
            switch (action) {
                case 0:
                    System.out.println("\n Shuting down .. ");
                    quite = true;
                    break;

                case 1:
//                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;


            }



        }
    }
    private static void removeContact() {
    }

    private static void addNewContact() {
        AddressBookMain address = new AddressBookMain();
        contactlist.add(address.CreateContact());
        printContactList();
    }

    private static void updateContact() {
        System.out.println("If you wish to edit the contact press 1");
        Scanner s = new Scanner(System.in);
        int entry = s.nextInt();
        if (entry == 1) {
            System.out.println("Enter the name to edit");
            String name = s.next();
            if (contactlist.size() > 0) {
                for (int i = 0; i < contactlist.size(); i++) {
                    Contact v = contactlist.get(i);
                    if (name.equals(v.firstname)) {
                        System.out.println("name available to edit");
                        System.out.println("Enter the new name to edit");
                        String newName = s.next();
                        v.firstname = newName;
                    } else
                        System.out.println("name not available to edit");

                }
            }
            else{
                System.out.println("No contacts");
            }
        }
    }

    private static void queryContact() {
    }

    private static void startPhone() {
        System.out.println("Starting Phone . . .");
    }
    private static void printAction() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutDown\n" +
                "1 - to print contacts\n"+
                "2 - to add a new contact\n"+
                "3 - to update an existing contact\n"+
                "4 - to remove and existing contact\n"+
                "5 - query for existing contact\n"+
                "6 - to print a list of available actions.");
        System.out.println("Choose Your Action: ");
    }


    private static void printContactList() {
        System.out.println("You have " + contactlist.size() + " contacts in your list");
        for (int i = 0; i < contactlist.size(); i++) {
            Contact v= contactlist.get(i);
            System.out.println(v.firstname+"\n"+v.lastname+"\n"+v.PhoneNumber+"\n"+v.email+"\n"+v.city+"\n"+v.state+"\n"+v.zip);


        }
    }
}