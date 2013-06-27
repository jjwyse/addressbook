package com.jjw.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.webservice.dao.AddressBookJdbcDao;
import com.jjw.webservice.service.AddressBookServiceIF;

public class AddressBookServiceImpl implements AddressBookServiceIF
{
    @Autowired
    private AddressBookJdbcDao myAddressBookJdbcDao;
}
