package com.capgemini.serviciosya.dao.test.spring;

import java.util.List;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProviderEntity;

import com.capgemini.serviciosya.dao.IProviderDao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import static com.capgemini.serviciosya.dao.IProviderDao.*;


public class ProviderSpringTest {

    private static final Logger logger = Logger.getLogger(ProviderSpringTest.class);

    public ProviderSpringTest() {
        super();
    }


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IProviderDao p = context.getBean(IProviderDao.class);

        ProviderEntity prov = new ProviderEntity();
        prov.setName("Lisa");
        prov.setLastName("Simpson");
        prov.setDni(7896);
        prov.setEmail("lisasimpson@gmail.com");
        prov.setPhone("456789123");
        prov.setAddress("souriges");

        CityEntity c = new CityEntity();
        c.setId(2);
        prov.setCity(c);
        prov.setStatus(0);

        IProviderDao.save(prov);

        logger.info(String.format("Provider  %s ", prov.toString()));

    }

}


