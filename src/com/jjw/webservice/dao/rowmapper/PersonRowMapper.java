package com.jjw.webservice.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jjw.webservice.pojo.Person;

/**
 * Maps a response from the database to our Person object
 * 
 * @author jjwyse
 */
public final class PersonRowMapper implements RowMapper<Person>
{
    /**
     * {@inheritDoc}
     */
    @Override
    public Person mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        Person person = new Person();
        person.setName(resultSet.getString("NAME"));
        person.setAddress(resultSet.getString("ADDRESS"));
        person.setCity(resultSet.getString("CITY"));
        person.setState(resultSet.getString("STATE"));
        person.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
        return person;
    }
}
