package com.jjw.webservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjw.webservice.dao.AddressBookJdbcDao;
import com.jjw.webservice.pojo.Person;

@Controller
public class AddressBookController
{
    /** Logger instance. */
    Logger LOG = Logger.getLogger(AddressBookController.class);

    @Autowired
    private AddressBookJdbcDao myAddressBookJdbcDao;

    /**
     * Handles a default request on the default URL
     * (http://localhost:8080/com.jjw.webservice.
     * 
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getDefaultName(ModelMap model)
    {
        model.addAttribute("name", "DEFAULT");
        return "AddressBook";
    }

    /**
     * 
     * @param personId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addressbook/{personId}", headers = "Accept=application/xml")
    public @ResponseBody
    Person getPerson(@PathVariable("personId") String personId)
    {
        LOG.info("Received a GET for ID: " + personId);

        Person product = myAddressBookJdbcDao.getPerson(Long.parseLong(personId));
        return product;
    }

    /**
     * 
     * @param personId
     * @param person
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/addressbook/{personId}")
    public @ResponseBody
    Person addPerson(@PathVariable("personId") String personId, @RequestBody Person person)
    {
        LOG.info("Received a POST for ID: " + personId);

        myAddressBookJdbcDao.addPerson(Long.parseLong(personId), person);
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

        myAddressBookJdbcDao.updatePerson(Long.parseLong(personId), person);
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

        myAddressBookJdbcDao.removePerson(Long.parseLong(personId));
    }
}
