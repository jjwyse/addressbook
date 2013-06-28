package com.jjw.addressbook.service;

import com.jjw.addressbook.pojo.Person;

public interface AddressBookServiceIF
{
    public Person getPerson(long id);

    public void addPerson(Person person);
}
