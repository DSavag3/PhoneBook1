package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class camPhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>(map);
    }

    public PhoneBook()
    {
        this(new HashMap<>());
    }



    public void add(String name, String phoneNumber) {
        //Use if statement to see if hashmap contains a name
        if (phonebook.containsKey(name)) {
            //grabbing the list of phonumbers which is also the value that is associated with the key name
            List<String> phoneNumbers = phonebook.get(name);
            //Adding a number that is provided in the parameter to the list
            phoneNumbers.add(phoneNumber);
        } else {
            // if the key (name) does not exist we want to create a new list.
            List<String> phoneNumbers = new ArrayList<>();
            //add phoneNumber to the list
            phoneNumbers.add(phoneNumber);
            //adding name and phoneNumbers to the hashmap
            phonebook.put(name, phoneNumbers);
        }
    }

    public void addAll(String name, String[] phoneNumbers) {
        if (phonebook.containsKey(name)) {
            List<String> phoneNumber = phonebook.get(name);
            // checking to see if phonebook contains the key name and getting it from the List.
            for (String number : phoneNumbers) {
                phoneNumber.add(number);
            }
        } else { // if the name does not exist in the phone book, it will add the number
            List<String> phoneNumberList = new ArrayList<>();
            for (String number : phoneNumbers) {
                phoneNumberList.add(number);
            }
            phonebook.put(name, phoneNumberList); // Putting the name and number in to the hashmap.
        }
    }


        public void remove(String name) {
            if (phonebook.containsKey(name)) {
                phonebook.remove(name);
            } else {
                System.out.println("This name does not exist in your contact list");
            }
        }



    public Boolean hasEntry(String name) {
        if (phonebook.containsKey(name)){ //Looks to see if the key is in the list
            System.out.println(name + " Is now in your list of contacts"); //prints out the name plus the string
        }

        return phonebook.containsKey(name); //returns the key value
    }

    public List<String> lookup(String name) {
        if (phonebook.containsKey(name)) { // Looks to see if the key is the list.
            return phonebook.get(name); // gets the name from the hashmap
        } else {
            System.out.println("This name does not exist in your contact list"); // Prints out the string
            return new ArrayList<>(); // or return null if desired
        }

    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) { //looks over what is inside the map
            List<String> numbers = entry.getValue(); // gets the value
            if (numbers.contains(phoneNumber)) {
                return entry.getKey(); // return the name if the number is found
            }
        }
        return null; // return null if the number is not found
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();
        for (String name : phonebook.keySet()) {
            contactNames.add(name);
        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {

        return phonebook;
    }
}
