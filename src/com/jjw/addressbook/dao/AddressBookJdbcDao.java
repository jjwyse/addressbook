package com.jjw.webservice.dao;

import com.jjw.webservice.pojo.Person;

/**
 * Interface that talks with the database and keeps track of people's address information
 * 
 * @author jjwyse
 * 
 */
public interface AddressBookJdbcDao
{
    /**
     * Inserts a new Person into our database
     * 
     * @param id The ID of the person to add to the database
     * @param person The person to store in the database
     */
    public void addPerson(Person person);

    /**
     * Retrieves the person in our database with the specified phone number
     * 
     * @param id The ID of the person from the address book
     * 
     * @return The person with that phone number
     */
    public Person getPerson(Long id);

    /**
     * Remove a person from the address book
     * 
     * @param id The ID of the person to remove
     */
    public void removePerson(Long id);

    /**
     * Update the person in the address book
     * 
     * @param id ID of the person we're going to update
     * @param person The new person to store
     */
    public void updatePerson(Long id);
}
