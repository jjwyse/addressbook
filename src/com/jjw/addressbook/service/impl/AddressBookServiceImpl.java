package com.jjw.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.webservice.dao.AddressBookJdbcDao;
import com.jjw.webservice.pojo.Person;
import com.jjw.webservice.service.AddressBookServiceIF;

public class AddressBookServiceImpl implements AddressBookServiceIF
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
