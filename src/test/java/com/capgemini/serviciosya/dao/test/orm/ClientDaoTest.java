package com.capgemini.serviciosya.dao.test.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ClientEntity;
import com.capgemini.serviciosya.dao.IClientDao;
import com.capgemini.serviciosya.dao.orm.ClientDaoHibernate;
import org.junit.Assert;
import org.junit.Test;



public class ClientDaoTest {

    private IClientDao dao = new ClientDaoHibernate();

    @Test
    public void testCreate() {

        ClientEntity c = new ClientEntity();
        c.setName("Marge");
        c.setLastName("Simpson");
        c.setDni(4567);
        c.setEmail("margesimpsongmail.com");
        c.setPhone("234567891");
        c.setAddress("Cordoba");
        CityEntity city = new CityEntity();
        city.setId(2);
        c.setCity(city);
        c.setCreditcard_number(23456789);
        this.dao.create(c);

        Assert.assertNotNull("Failure creating new client.", c.getId());
    }




}
