package com.jjw.addressbook.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{
    private static final Logger LOG = Logger.getLogger(HomeController.class);

    /**
     * Get a person by ID from our data store
     * 
     * @param personId The ID of the person
     * @return The person or null
     */
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String showHomePage(Map<String, Object> model)
    {
        LOG.info("Handling getPerson request");

        return "addressbook";
    }
}
