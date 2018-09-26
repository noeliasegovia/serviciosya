package com.capgemeini.serviciosya.repository.test.jpa;


import java.util.*;

import com.capgemeini.serviciosya.beans.entity.CityEntity;
import com.capgemeini.serviciosya.beans.entity.ClientEntity;
import com.capgemeini.serviciosya.beans.entity.CountryEntity;
import com.capgemeini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemeini.serviciosya.repository.ICityRepository;
import com.capgemeini.serviciosya.repository.IClientRepository;
import com.capgemeini.serviciosya.repository.ICountryRepository;
import com.capgemeini.serviciosya.repository.IProvinceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ClientRepositoryTest {

    @Autowired
    private IClientRepository repositoryClient = null;

    @Autowired
    private ICountryRepository repositoryCountry = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;

    @Autowired
    private ICityRepository repositoryCity = null;

    private static final Logger logger = Logger.getLogger(ClientRepositoryTest.class);

    public ClientRepositoryTest () {

        super ();
    }

    @Before
    public void setup () {

        logger.info("Creating city, province and country...");
        CountryEntity country = new CountryEntity (Integer.valueOf (1), "Brasil");
        ProvinceEntity province = new ProvinceEntity (Integer.valueOf (1), "Brasilia", country);
        CityEntity city = new CityEntity (Integer.valueOf (1), "Bere bere", province);

        logger.debug ("Saving city, province and country...");
        this.repositoryCountry.save (country);
        this.repositoryProvince.save (province);
        this.repositoryCity.save (city);
        logger.debug(String.format("City, province and country saved %s, %s, %s", city, province, country));

        logger.info("Creating provider...");
        ClientEntity[] clients = new ClientEntity[] {

                new ClientEntity(Integer.valueOf(1), "Bart", "Simpsons","20589632",
                        4558463, "bartsimpson@gmail.com",
                        "Siempre viva 123",city),

                new ClientEntity(Integer.valueOf(1), "Margaret", "Simpsons","89455",
                        123456, "maggiesimpson@gmail.com",
                        "Siempre viva 1233",city),
        };

        logger.debug("Saving Providers...");
        this.repositoryClient.save (Arrays.asList(clients));
        logger.debug(String.format("Consumers saved %s", Arrays.toString(clients)));
    }


    @Test
    public void testFindAllBydni () {

        int dni = 123456;

        ClientEntity c = this.repositoryClient.findBydni(dni);

        System.out.println(c);

        Assert.assertNotNull ("it is client", c);
    }

    @Test
    public void testFindAllByEmail () {

        String email = "maggiesimpson@gmail.com";

        ClientEntity c = this.repositoryClient.findByEmail(email);

        System.out.println(c);

        Assert.assertNotNull ("it is client", c);
    }

    @Test
    public void testFindAllByPhone () {

        String phone = "89455";

        ClientEntity p = this.repositoryClient.findByPhone(phone);

        System.out.println(p);

        Assert.assertNotNull ("it is client", p);
    }

}
