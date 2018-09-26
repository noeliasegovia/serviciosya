/*
package com.capgemeini.serviciosya.repository.test.orm;

import com.capgemeini.serviciosya.beans.entity.ProviderEntity;
import org.junit.Assert;
import org.junit.Test;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import com.capgemeini.serviciosya.repository.IOccupationRepository;
import com.capgemeini.serviciosya.repository.orm.OccupationDaoHibernate;

import java.util.List;

public class OccupationDaoTest {

    private IOccupationRepository dao = new OccupationDaoHibernate ();


    @Test
    public void testCreate () {

        OccupationEntity o = new OccupationEntity() ;
        ProviderEntity p = new ProviderEntity();
        p.setId(1);
        o.setId(1);
        o.setName ("Police man");
        o.setDescription("Police");
        o.setProviders(p);

        this.dao.create(o);

        Assert.assertNotNull ("Failure creating new occupation.", o.getId ());
    }

    @Test
    public void testUpdate() {

        OccupationEntity o = new OccupationEntity();
        o.setId(1);
        o.setName("Bomber");
        o.setDescription("Bomber men");

        this.dao.update(o);

        Assert.assertEquals("Failure updating occupation.", "Bomber", o.getName());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        OccupationEntity o = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Provider.", o);
    }

    @Test
    public void testFindAll () {

        List<OccupationEntity> list = this.dao.findAll ();

        OccupationEntity o = list.get(0);

        list.forEach (System.out::println);

        Assert.assertFalse ("Failure find all clients.", list.isEmpty ());
    }

    @Test
    public void testFindById () {

        OccupationEntity o = this.dao.findById (1);

        Assert.assertNotNull ("Failure find by id.", o);

    }

    @Test
    public void testFindByName () {

        OccupationEntity o = this.dao.findByName ("Bomber");

        Assert.assertNotNull ("Failure find by dni.", o);

    }



}
*/
