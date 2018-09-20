package com.capgemini.serviciosya.dao.test.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.dao.IProviderDao;
import com.capgemini.serviciosya.dao.orm.ProviderDaoHibernate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProviderDaoTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

    private IProviderDao dao = context.getBean (IProviderDao.class);

    @Test
    public void testCreate () {

        ProviderEntity p = new ProviderEntity ();
        p.setName("Margaret");
        p.setLastName("Simpson");
        p.setDni(7899);
        p.setEmail("mgsimpson@gmail.com");
        p.setPhone ("546489");
        p.setAddress("Villa Maria");
        CityEntity city = new CityEntity();
        city.setId(2);
        p.setCity(city);
        p.setStatus(1);

        this.dao.create (p);

        Assert.assertNotNull ("Failure creating new provider.", p.getId ());
    }


    @Test
    public void testFindAll () {


        ProviderEntity p = this.dao.findById (1);

        p.getOccupations().forEach( e -> System.out.println (e.getName ()));


        Assert.assertFalse ("Failure find all providers.", p.getOccupations().isEmpty());
    }


    @Test
    public void testFindByDNI () {

        ProviderEntity p = this.dao.findByDNI (1234);

       Assert.assertNotNull ("Failure find by dni.", p);
    }

    @Test
    public void testFindByEmail (){
        ProviderEntity p = this.dao.findByEmail ("bartsimpson@gmail.com");

        Assert.assertNotNull ("Failure find by email.", p);

    }

    @Test
    public void testFindByPhone () {
        ProviderEntity p = this.dao.findByPhone("1234567890");

        Assert.assertNotNull("Failure find by dni.", p);
    }

}
