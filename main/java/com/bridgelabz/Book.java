package com.bridgelabz;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;


import java.io.BufferedWriter;
import java.io.File;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileWriter;
import java.io.IOException;


public class Book {
    static ArrayList<Contact> contactlist = new ArrayList<Contact>();

    /* This method is used to delete the contact if exists in the contact book
    @param takes firstname as input
    @return boolean value true if removed else false
     */

    public boolean removeContact(String name) {
        if (contactlist.size() > 0) {
            for (int i = 0; i < contactlist.size(); i++) {
                Contact contact = contactlist.get(i);
                if ((contact.firstname + contact.lastname).equals(name)) {
                    contactlist.remove(i);
                    return true;
                } else {
                    System.out.println("name not available to edit");
                    return false;
                }
            }
        } else {
            System.out.println("No contacts");

        }
        return false;
    }

    /* This method is used to add the contact, if already exists in the contact book
    not adding else adding
    @param takes contact input
    @return boolean value true if added else false
     */

    public boolean addNewContact(Contact contact) {
        int bit_add = 0;
        if (contactlist.size() > 0) {
            int i = 0;
            while (i < contactlist.size() && bit_add == 0) {
                Contact contactPresent = contactlist.get(i);
                if (contact.equals(contactPresent)) {
                    bit_add = 1;
                    System.out.println("name available Present duplicate not allowed");
                    return false;
                }
                i++;
            }
            if (bit_add == 0) {
                contactlist.add(contact);
                return true;
            }
        }
        contactlist.add(contact);
        return true;
    }

    /* This method is used to update the contact,only  if exists in the contact book
    @param takes String oldname and newname as an input
    @return boolean value true if updated else false
     */

    public boolean updateContact(Contact oldcontact, Contact newContact) {
        boolean check = checkContactExtists(oldcontact);
        if (check == false) {
            if (contactlist.size() > 0) {
                for (int i = 0; i < contactlist.size(); i++) {
                    if (contactlist.get(i).equals(oldcontact)) {
                        contactlist.add(i, newContact);
                        return true;
                    }
                }
            }
            else
            {
                System.out.println("name not available to edit");
                return false;
            }
        }
        System.out.println("No contacts");
        return false;
    }

    /* This method is used to print the contacts
     */

    public void printContactList() {
        System.out.println("You have " + contactlist.size() + " contacts in your list");
        for (int i = 0; i < contactlist.size(); i++) {
            Contact v = contactlist.get(i);
            System.out.println("First_name :"+v.firstname + "\n" +"Last_name :"+ v.lastname + "\n" +
                    "Phone_number :"+v.PhoneNumber + "\n" +"emailID :"+ v.email + "\n" +"City :"+ v.city + "\n"
                    +"State :"+v.state + "\n" +"Zip :"+ v.zip);
            System.out.println("================================");
        }
    }

    /* This method is used to search the contact,only  if exists in the contact book
    @param takes contacts
    @return boolean value true if present else false
     */

    public boolean checkContactExtists(Contact contact) {
        if (contactlist.size() > 0) {
            int i = 0;
            while (i < contactlist.size()) {
                Contact contactPresent = contactlist.get(i);
                if (contact.equals(contactPresent)) {
                    System.out.println("Contact Exists");
                    return true;
                }
                i++;
            }
            return false;
        }
        return false;
    }

    /* This method is used to search the contact,only  if exists in the contact book
    @param takes contacts
    @return contact value true if present else null
     */

    public Contact checkContactExistsStream(Contact contact){
        return contactlist.stream().filter(contac -> contac.equals(contact))
                .findAny()
                .orElse(null);
    }

        /* This method is used to search the contact by name of city, only  if exists in the contact book
    @param takes city
    @return list of contact value true
     */

    public List<Contact> checkContactByCityStream(String sample_city) {
        List<Contact> contactsByCity = contactlist.stream().filter(contac -> contac.city.equals(sample_city))
                .collect(Collectors.toList());
        Iterator<Contact> contactIterator=contactsByCity.iterator();
        while(contactIterator.hasNext()){
            System.out.println(contactIterator.next().firstname);
        }
        return contactsByCity;
    }

    /* This method is used to search the contact by name of state, only  if exists in the contact book
    @param takes state
    @return list of contact value true
     */

    public List<Contact> checkContactByStateStream(String sample_state) {
        List<Contact> contactsByState = contactlist.stream().filter(contac -> contac.state.equals(sample_state))
                .collect(Collectors.toList());
        Iterator<Contact> contactIterator=contactsByState.iterator();
        while(contactIterator.hasNext()){
            System.out.println(contactIterator.next().firstname);
        }
        return contactsByState;
    }

    /* This method is used get the count of contact by name of city,
    @param takes state
    @return size
     */
    public int checkContactlengthByCityStream(String sample_city) {
        List<Contact> contactsByCity = contactlist.stream().filter(contac -> contac.city.equals(sample_city))
                .collect(Collectors.toList());
        int leng=contactsByCity.size();
        return leng;
    }

    /* This method is used get the count of contact by name of state,
   @param takes state
   @return size
    */
    public int checkContactlengthByStateStream(String sample_state) {
        List<Contact> contactsByState = contactlist.stream().filter(contac -> contac.state.equals(sample_state))
                .collect(Collectors.toList());
        int leng=contactsByState.size();
        return leng;
    }

    /* This method is used write JSonFile,
    @param takes filename
    @return bollean value
    */
    public boolean writeToFileJson(String fileName) throws IOException {
        for (int i = 0; i < contactlist.size(); i++) {
            Contact contact = contactlist.get(i);
            JSONObject jsObject=new JSONObject();
            JSONObject obj=new JSONObject();
            jsObject.put("id",i);
            jsObject.put("firstname",contact.firstname);
            jsObject.put("lastname",contact.lastname);
            jsObject.put("phoneNumber",contact.PhoneNumber);
            jsObject.put("city",contact.city);
            jsObject.put("state",contact.state);
            jsObject.put("zip",contact.zip);
            jsObject.put("email",contact.email);
            BufferedWriter fileWriter=new BufferedWriter(new FileWriter(fileName, true));
            try {
               char doubleQuotes='"';
               if(i==0)
                   fileWriter.append("{ "+ doubleQuotes+"contact"+doubleQuotes+":[");
               fileWriter.append(jsObject.toJSONString());

               if(i<contactlist.size()-1)
                  fileWriter.append(",\n");
               if(i==contactlist.size()-1)
                  fileWriter.append("]}");
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                fileWriter.flush();
                fileWriter.close();
            }
        }
        return true;
    }
}

