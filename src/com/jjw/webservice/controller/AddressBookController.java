package com.jjw.webservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjw.webservice.pojo.Person;
import com.jjw.webservice.service.AddressBookServiceIF;

@Controller
@RequestMapping("/api")
public class AddressBookController
{
    /** Logger instance. */
    Logger LOG = Logger.getLogger(AddressBookController.class);

    @Autowired
    AddressBookServiceIF myAddressBookService;

    /**
     * 
     * @param personId
     * @return
     */
    @RequestMapping("/addressbook/{personId}")
    @ResponseBody
    public Person getPerson(@PathVariable long personId)
    {
        LOG.info("Received a GET for ID: " + personId);

        Person product = myAddressBookService.getPerson(personId);
        return product;
    }

    /**
     * 
     * @param personId
     * @param person
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/addressbook/{personId}")
    @ResponseBody
    public Person addPerson(@PathVariable("personId") String personId, @RequestBody Person person)
    {
        LOG.info("Received a POST for ID: " + personId);

        myAddressBookService.addPerson(Long.parseLong(personId), person);
        return person;
    }

    /**
     * 
     * @param personId
     * @param person
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/addressbook/{personId}")
    public @ResponseBody
    Person updatePerson(@PathVariable("personId") String personId, @RequestBody Person person)
    {
        LOG.info("Received a PUT for ID: " + personId);

        myAddressBookService.updatePerson(Long.parseLong(personId), person);
        return person;
    }

    /**
     * 
     * @param personId
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/addressbook/{personId}")
    public @ResponseBody
    void removeCategory(@PathVariable("personId") String personId)
    {
        LOG.info("Received a DELETE for ID: " + personId);

        myAddressBookService.removePerson(Long.parseLong(personId));
    }
}
