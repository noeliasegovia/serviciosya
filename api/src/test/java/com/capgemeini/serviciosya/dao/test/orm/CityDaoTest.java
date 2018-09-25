package com.capgemeini.serviciosya.dao.test.orm;
import java.util.List;

import com.capgemeini.serviciosya.beans.entity.CityEntity;
import com.capgemeini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemeini.serviciosya.dao.ICityDao;
import com.capgemeini.serviciosya.dao.orm.CityDaoHibernate;


import org.junit.Assert;
import org.junit.Test;

import org.apache.log4j.Logger;



public class CityDaoTest {

    private ICityDao dao = new CityDaoHibernate();


    @Test
    public void testCreate () {

        CityEntity p = new CityEntity ();
        ProvinceEntity c = new ProvinceEntity ();
        c.setId (1);
        p.setName ("CABA");
        p.setProvince(c);
        this.dao.create (p);

        Assert.assertNotNull ("Failure creating new City.", c.getId ());
    }

    @Test
    public void testUpdate () {

        ProvinceEntity p = new ProvinceEntity ();
        CityEntity c = new CityEntity ();
        p.setId (1);
        c.setId (3);
        c.setName ("La plata");
        c.setProvince (p);
        this.dao.update (c);

        Assert.assertEquals ("Failure updating City.", "La plata", c.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        CityEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting City.", c);
    }

    @Test
    public void testFindAll () {

        List<CityEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName () + " -> " + e.getProvince ().getName ()));

        Assert.assertFalse ("Failure find all cities.", list.isEmpty ());
    }
}
