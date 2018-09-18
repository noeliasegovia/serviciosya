package com.capgemini.serviciosya.dao.test.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ClientEntity;
import com.capgemini.serviciosya.dao.IClientDao;
import com.capgemini.serviciosya.dao.orm.ClientDaoHibernate;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class ClientDaoTest {

    private IClientDao dao = new ClientDaoHibernate();

    @Test
    public void testCreate() {

        ClientEntity c = new ClientEntity();

        CityEntity city = new CityEntity();
        city.setId(2);


        c.setName("Marge");
        c.setLastName("Simpson");
        c.setDni(4567);
        c.setEmail("margesimpson@gmail.com");
        c.setPhone("2345891");
        c.setAddress("Cordoba");
        c.setCity(city);

        this.dao.create(c);

        Assert.assertNotNull("Failure creating new client.", c.getId());
    }

    @Test
    public void testFindAll () {


        List<ClientEntity> list= this.dao.findAll();
        list.forEach (e -> System.out.println (e));
        Assert.assertFalse ("Failure find all providers.", list.isEmpty());
    }


    @Test
    public void testFindByDNI () {

        ClientEntity c = this.dao.findByDNI (4567);

        Assert.assertNotNull ("Failure find by dni.", c);
    }

    @Test
    public void testFindByEmail (){
        ClientEntity c = this.dao.findByEmail ("margesimpson@gmail.com");

        Assert.assertNotNull ("Failure find by email.", c);

    }

    @Test
    public void testFindByPhone () {
        ClientEntity c = this.dao.findByPhone("2345891");

        Assert.assertNotNull("Failure find by phone.", c);
    }





}
