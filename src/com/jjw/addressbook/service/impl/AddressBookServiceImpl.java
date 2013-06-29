package com.jjw.addressbook.service.impl;

import java.util.ArrayList;

import com.jjw.addressbook.pojo.Person;
import com.jjw.addressbook.service.AddressBookServiceIF;

/**
 * In memory representation of our address book
 * 
 * @author jjwyse
 */
public class AddressBookServiceImpl implements AddressBookServiceIF
{
    int myId = 0;

    private ArrayList<Person> myAddressBook = new ArrayList<Person>();

    @Override
    public Person getPerson(long id)
    {
        return myAddressBook.get((int) id);
    }

    @Override
    public void addPerson(Person person)
    {
        myAddressBook.add(person);
        myId++;
    }
}
