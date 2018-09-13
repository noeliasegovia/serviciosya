package com.capgemini.serviciosya.dao.test.orm;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.dao.ICountryDao;
import com.capgemini.serviciosya.dao.orm.CountryDaoHibernate;

import java.util.List;

public class CountryDaoTest {

    private  ICountryDao dao = new CountryDaoHibernate();

    @Test
    public void testCreate () {

        CountryEntity c = new CountryEntity ();
        c.setName ("Colombia");
        this.dao.create (c);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
    }

    @Test
    public void testUpdate () {

        CountryEntity c = new CountryEntity ();
        c.setId (3);
        c.setName ("ARGENTINA");
        this.dao.update (c);

        Assert.assertEquals ("Failure updating country.", "ARGENTINA", c.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
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
}
