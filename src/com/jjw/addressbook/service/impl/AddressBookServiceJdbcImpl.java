package com.jjw.addressbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.addressbook.dao.AddressBookJdbcDao;
import com.jjw.addressbook.pojo.Person;
import com.jjw.addressbook.service.AddressBookServiceIF;

public class AddressBookServiceJdbcImpl implements AddressBookServiceIF
{
    @Autowired
    private AddressBookJdbcDao myAddressBookJdbcDao;

    @Override
    public Person getPerson(long id)
    {
        return myAddressBookJdbcDao.getPerson(id);
    }

    @Override
    public void addPerson(Person person)
    {
        myAddressBookJdbcDao.addPerson(person);
    }
}
