
/*
package com.capgemeini.serviciosya.repository.test.orm;


import com.capgemeini.serviciosya.beans.entity.CityEntity;
import com.capgemeini.serviciosya.beans.entity.ProviderEntity;
import com.capgemeini.serviciosya.repository.IProviderRepository;
import com.capgemeini.serviciosya.repository.orm.ProviderDaoHibernate;
import org.junit.Assert;
import org.junit.Test;



public class ProviderDaoTest {


    private IProviderRepository dao = new ProviderDaoHibernate();

    @Test
    public void testCreate() {

        ProviderEntity p = new ProviderEntity();
        p.setName("Lisa");
        p.setLastName("Simpson");
        p.setDni(4567);
        p.setEmail("lisasimpson@gmail.com");
        p.setPhone("546889");
        p.setAddress("Cordoba");
        CityEntity city = new CityEntity();
        city.setId(2);
        p.setCity(city);
        p.setStatus(0);
        this.dao.create(p);

        Assert.assertNotNull("Failure creating new country.", p.getId());
    }

    @Test
    public void testUpdate() {

        ProviderEntity p = new ProviderEntity();
        p.setId(1);
        p.setName("Simour");
        p.setLastName("Skinner");
        p.setDni(4565);
        p.setEmail("simoskin@gmail.com");
        p.setPhone("4648");
        p.setAddress("Calle 123");
        CityEntity city = new CityEntity();
        city.setId(2);
        p.setCity(city);
        p.setStatus(1);
        this.dao.update(p);

        Assert.assertEquals("Failure updating Provider.", "Simour", p.getName());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        ProviderEntity p = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Provider.", p);
    }

    //falla porqe falta cargar ocupaciones

    @Test
    public void testFindAll () {

        ProviderEntity p = this.dao.findById (1);
        p.getOccupations().forEach( e -> System.out.println (e.getName ()));
        Assert.assertFalse ("Failure find all providers.", p.getOccupations().isEmpty());
    }

    @Test
    public void testFindById () {

        ProviderEntity p = this.dao.findById (2);

        Assert.assertNotNull ("Failure find by id.", p);

    }

    @Test
    public void testFindByDNI () {

        ProviderEntity p = this.dao.findByDNI (4565);

        Assert.assertNotNull ("Failure find by dni.", p);

    }

    @Test
    public void testFindByEmail () {

        ProviderEntity p = this.dao.findByEmail ("nedflan@gmail.com");

        Assert.assertNotNull ("Failure find by email.", p);

    }

    @Test
    public void testFindByPhone () {

        ProviderEntity p = this.dao.findByPhone ("465678");

        Assert.assertNotNull ("Failure find by phone.", p);

    }
}*/
