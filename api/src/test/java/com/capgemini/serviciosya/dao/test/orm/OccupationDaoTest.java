package com.capgemini.serviciosya.dao.test.orm;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import com.capgemini.serviciosya.dao.IOccupationDao;
import com.capgemini.serviciosya.dao.orm.OccupationDaoHibernate;

import java.util.List;

public class OccupationDaoTest {

    IOccupationDao dao = new OccupationDaoHibernate ();

    @Test

    public void testCreate () {

        OccupationEntity o = new OccupationEntity ();
        o.setName ("Bibliotecario");
        o.setDescription("Se dedica a la gestion d libros");
        this.dao.create (o);

        Assert.assertNotNull ("Failure creating new occupation.", o.getId ());
    }

    @Test
    public void testUpdate () {

        OccupationEntity oc = new OccupationEntity ();
        oc.setId(4);
        oc.setName ("Doctor");
        oc.setDescription ("Se dedica a la salud");
        oc.setOccupation(oc);

        this.dao.update (oc);

        Assert.assertEquals ("Failure updating occupation.", "Doctor", oc.getName ());
    }

    @Test
    public void testDelete () {

        int id = 12;
        this.dao.delete (id);

        OccupationEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting occupation.", c);
    }

    @Test
    public void testFindAll () {

        List<OccupationEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName () + ": " + e.getDescription()));

        Assert.assertFalse ("Failure find all occupations.", list.isEmpty ());
    }
}