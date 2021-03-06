/*

package com.capgemini.serviciosya.repository.test.orm;


import org.junit.Assert;
import org.junit.Test;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repository.ICountryRepository;
import com.capgemini.serviciosya.repository.orm.CountryDaoHibernate;

import java.util.List;


public class CountryDaoAnnotationTest {


    private ICountryRepository dao = new CountryDaoHibernate ();


    @Test
    public void testCreate () {

        CountryEntity c = new CountryEntity ();
        c.setName ("Venezuela");
        this.dao.create (c);

      Assert.assertNotNull ("Failure creating new country.", c.getId ());
    }

    @Test
    public void testUpdate () {

        CountryEntity c = new CountryEntity ();
        c.setId (2);
        c.setName ("ARGENTINA");
        this.dao.update (c);

        Assert.assertEquals ("Failure updating country.", "ARGENTINA", c.getName ());
    }

    @Test
    public void testDelete () {

        int id = 4;
        this.dao.delete (id);

        CountryEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting country.", c);
    }

    @Test
    public void testFindAll () {

        List<CountryEntity> list = this.dao.findAll ();

        CountryEntity c = list.get (0);

        list.forEach (System.out::println);

        Assert.assertFalse ("Failure find all countries.", list.isEmpty ());
    }

    @Test
    public void testFindByName () {

        CountryEntity c = this.dao.findByName ("ARGENTINA");

        Assert.assertNotNull ("Failure finding country by name!", c);
    }

    @Test
    public void testGetAllProvinces () {

        CountryEntity c = this.dao.findByName ("ARGENTINA");

        c.getProvinces().forEach ( e -> System.out.println (e.getName ()));

        Assert.assertFalse ("Failure finding country by name!", c.getProvinces().isEmpty ());
    }
}*/
