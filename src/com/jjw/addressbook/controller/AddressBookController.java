package com.jjw.webservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjw.webservice.pojo.Person;
import com.jjw.webservice.service.AddressBookServiceIF;

@Controller
@RequestMapping("addressbook")
public class AddressBookController
{
    /** Logger instance. */
    Logger LOG = Logger.getLogger(AddressBookController.class);

    @Autowired
    AddressBookServiceIF myAddressBookService;

    /**
     * Get a person by ID from our data store
     * 
     * @param personId The ID of the person
     * @return The person or null
     */
    @RequestMapping("/addressbook/{id}")
    @ResponseBody
    public Person getPerson(@PathVariable long id)
    {
        LOG.info("Handling getPerson request");

        return myAddressBookService.getPerson(id);
    }

    /**
     * Add a person to our data store
     * 
     * @param person
     * @return
     */
    @RequestMapping(value = "person", method = RequestMethod.POST)
    @ResponseBody
    public String addPerson(Person person)
    {
        LOG.info("Handling addPerson request");

        myAddressBookService.addPerson(person);
        return "Saved person " + person.toString();
    }
}
