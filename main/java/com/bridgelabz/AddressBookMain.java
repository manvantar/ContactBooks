package com.bridgelabz;
import java.io.FileWriter;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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


    /* This method used to creat contact object
   @param String type firstname,lastname,city,state,mob,email and int type pincode
   @return Contact onject
   */

    public Contact createContact(String firstname, String lastname,
                                 String city, String state, String mob, String email){
        Contact contact=new Contact();
        contact.firstname = firstname;
        contact.lastname = lastname;
        contact.city = city;
        contact.state = state;
        contact.zip = 0;
        contact.PhoneNumber = mob;
        contact.email = email;
        return contact;
    }

    public static void main(String[] args) throws IOException {
        // consolewrite();
        //readFromCsv();
        writeToCsv();
    }

    /* This method is used to teston consoleinputOutputReader
     */

    private static void consolewrite() {
        Book book=new Book();
        Scanner consoleInputOutputReader= new Scanner(System.in);
        AddressBookMain addressBookMain=new AddressBookMain();
        book.addNewContact(addressBookMain.createContact(consoleInputOutputReader));
        book.addNewContact(addressBookMain.createContact(consoleInputOutputReader));
        book.printContactList();
    }

    /* This method used to create contact object using openCSV library
    where it reads file /home/mkv/contactsExample.csv CSV file
    and creates object of contact
    @exception IOexception,ArrayIndexOutOfBoundsException
    */

    public static void readFromCsv() throws IOException,ArrayIndexOutOfBoundsException {
        Book book=new Book();
        AddressBookMain addressBookMain=new AddressBookMain();
        String SAMPLE_CSV_FILE_PATH = "/home/mkv/contactsExample.csv";
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
             CSVReader csvReader = new CSVReader(reader);) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                book.addNewContact(addressBookMain.createContact(record[0], record[1],
                        record[2],record[3], record[4], record[5]));
            }
        }
        catch (CsvValidationException e) {}
        catch (CsvException e) {}
        catch (ArrayIndexOutOfBoundsException exception){}
        finally {
            book.printContactList();
        }
    }

    /* This method used to write the contact list into csv file
    in the path /home/mkv/contactsExampleWriting.csv
    */

    public static void writeToCsv() throws IOException {
        String SAMPLE_CSV_OUTFILE_PATH = "/home/mkv/contactsExampleWriting.csv";
        AddressBookMain addressBookMain=new AddressBookMain();
        List<Contact> contact=new ArrayList<>();
        Contact contact1=new Contact("Manu","Kv","Bengaluru","Karnataka",
                560076,"9663393660","manukvshetty@gmail.com");
        Contact contact2=new Contact("Srinivar",null,"Bengaluru","Karnataka",
                560076,"9663393660","srinivar@gmail.com");
        Contact contact3=new Contact("inivar",null,"Mysuru","Karnataka",
                560076,"9663393660","nivar@gmail.com");
        Contact contact4=new Contact("iar",null,"Vizak","Andhra",
                780076,"966323230","iar@gmail.com");
        contact.add(contact1);
        contact.add(contact2);
        contact.add(contact3);
        contact.add(contact4);
        FileWriter writer = new FileWriter(SAMPLE_CSV_OUTFILE_PATH);
        try {
            writer.append("firstName,lastName,PhoneNumber,city,state,zip,EmailId"+"\n");
            for (Contact contacts: contact) {
                writer.append(contacts.firstname+",");
                writer.append(contacts.lastname+",");
                writer.append(contacts.PhoneNumber+",");
                writer.append(contacts.city+",");
                writer.append(contacts.state+",");
                writer.append(String.valueOf(contacts.zip)+",");
                writer.append(contacts.email+",");
                writer.append("\n");
            }
        }
        catch (Exception e) { }
        finally {
            writer.flush();
            writer.close();
        }
    }

}





