package com.jjw.webservice.service;

import com.jjw.webservice.pojo.Person;

public interface AddressBookServiceIF
{
    public Person getPerson(long id);

    public void addPerson(Person person);
}
