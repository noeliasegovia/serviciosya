/*package com.capgemeini.serviciosya.repository.test.orm;

import com.capgemeini.serviciosya.beans.entity.CityEntity;
import com.capgemeini.serviciosya.beans.entity.ClientEntity;
import com.capgemeini.serviciosya.repository.IClientRepository;
import com.capgemeini.serviciosya.repository.orm.ClientDaoHibernate;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ClientDaoTest {

    private IClientRepository dao = new ClientDaoHibernate();

    @Test
    public void testCreate () {

        ClientEntity c = new ClientEntity ();
        c.setName("Ned");
        c.setLastName("Flanders");
        c.setDni(7894);
        c.setEmail("nedflan@gmail.com");
        c.setPhone ("465678");
        c.setAddress("Buenos Aires");
        CityEntity city = new CityEntity();
        city.setId(2);
        c.setCity(city);
        this.dao.create (c);

        Assert.assertNotNull ("Failure creating new client.", c.getId ());
    }

    @Test
    public void testUpdate() {

        ClientEntity c = new ClientEntity();
        c.setId(1);
        c.setName("Margot");
        c.setLastName("Flanders");
        c.setDni(4879);
        c.setEmail("margotflanderress@gmail.com");
        c.setPhone("78941");
        c.setAddress("Calle");
        CityEntity city = new CityEntity();
        city.setId(2);
        c.setCity(city);

        this.dao.update(c);

        Assert.assertEquals("Failure updating Provider.", "Margot", c.getName());
    }

    @Test
    public void testDelete () {

        int id = 1;
        this.dao.delete (id);

        ClientEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Client.", c);
    }

    @Test
    public void testFindAll () {

        List<ClientEntity> list = this.dao.findAll ();

        ClientEntity c = list.get(0);

        list.forEach (System.out::println);

        Assert.assertFalse ("Failure find all clients.", list.isEmpty ());
    }

    @Test
    public void testFindById () {

        ClientEntity c = this.dao.findById (2);

        Assert.assertNotNull ("Failure find by id.", c);

    }

    @Test
    public void testFindByEmail () {

        ClientEntity c = this.dao.findByEmail ("nedflan@gmail.com");

        Assert.assertNotNull ("Failure find by email.", c);

    }

    @Test
    public void testFindByDNI () {

        ClientEntity c = this.dao.findByDNI (7894);

        Assert.assertNotNull ("Failure find by dni.", c);

    }

    @Test
    public void testFindByPhone () {

        ClientEntity c = this.dao.findByPhone ("465678");

        Assert.assertNotNull ("Failure find by phone.", c);

    }

}*/
