package com.capgemini.serviciosya.dao.test.orm;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.ICityDao;
import com.capgemini.serviciosya.dao.orm.CityDaoHibernate;


public class CityDaoTest {
    private ICityDao dao= new CityDaoHibernate();

    @Test
    public void testCreate(){

        CityEntity c = new CityEntity();
        ProvinceEntity p = new ProvinceEntity();
        p.setId(1);
        c.setName("Quilmes");
        c.setProvince(p);

        this.dao.create(c);

        Assert.assertNotNull ("Failure creating new City.", c.getId ());

    }

    @Test
    public void testUpdate () {

        CityEntity c = new CityEntity ();
        ProvinceEntity p = new ProvinceEntity ();
        p.setId (3);
        c.setId (3);
        c.setName ("Florencio Varela");
        c.setProvince(p);
        this.dao.update (c);

        Assert.assertEquals ("Failure updating City.", "Florencio Varela", c.getName ());
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

        Assert.assertFalse ("Failure find all provinces.", list.isEmpty ());
    }
}
