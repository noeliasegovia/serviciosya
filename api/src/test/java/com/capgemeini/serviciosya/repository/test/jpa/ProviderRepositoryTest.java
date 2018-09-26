package com.capgemeini.serviciosya.repository.test.jpa;

import java.util.*;

import com.capgemeini.serviciosya.beans.entity.*;
import com.capgemeini.serviciosya.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.apache.log4j.Logger;

@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ProviderRepositoryTest {

    @Autowired
    private IProviderRepository repositoryProvider = null;

    @Autowired
    private IOccupationRepository repositoryOccupation = null;

    @Autowired
    private ICityRepository repositoryCity = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;

    @Autowired
    private ICountryRepository repositoryCountry = null;

    private final Logger logger = Logger.getLogger(ProviderRepositoryTest.class);

    public ProviderRepositoryTest () {

        super ();
    }

    @Before
    public void setup () {

        logger.info ("Creating Occupation...");
        OccupationEntity[] occupations = new OccupationEntity[] {

                new OccupationEntity (Integer.valueOf (1), "Guardia carcel", "cuida de la carcel"),
                new OccupationEntity (Integer.valueOf (2), "Ingeniero Informatico", "Informatico"),
                new OccupationEntity (Integer.valueOf (3), "Ama de casa", "casa "),
                new OccupationEntity (Integer.valueOf (4), "Paseador", " paseador de perros"),

        };

        logger.debug ("Set occupation father");
        occupations[1].setOccupation (occupations[0]);
        occupations[2].setOccupation (occupations[0]);
        logger.debug (String.format ("Object occupation created %s", Arrays.toString(occupations)));

        logger.debug ("Saving occupations...");
        this.repositoryOccupation.save (Arrays.asList(occupations));
        logger.debug(String.format ("Occupations saved %s", Arrays.toString (occupations)));

        logger.info ("Creating city, province and country...");
        CountryEntity country = new CountryEntity (Integer.valueOf (1), "Argentina ");
        ProvinceEntity province = new ProvinceEntity (Integer.valueOf (1), "Buenos aires", country);
        CityEntity city = new CityEntity (Integer.valueOf (1), "Springfield", province);

        logger.debug ("Saving city, province and country...");
        this.repositoryCountry.save (country);
        this.repositoryProvince.save (province);
        this.repositoryCity.save (city);
        logger.debug(String.format("City, province and country saved %s, %s, %s", city, province, country));

        logger.debug("Setting set occupation...");
        Set<OccupationEntity> occupation1 = new HashSet<OccupationEntity>();
        occupation1.add (occupations[1]);
        occupation1.add (occupations[2]);

        Set<OccupationEntity> occupation2 = new HashSet<OccupationEntity>();
        occupation2.add(occupations[3]);

        logger.info("Creating provider...");
        ProviderEntity[] providers = new ProviderEntity[] {

                new ProviderEntity(Integer.valueOf(1), "Marge", "Simpsons",
                        "11645889", 4587986, "marge.simpsons@gmail.com",
                        "Calle falsa 123", 0, city, occupation1),

                new ProviderEntity(Integer.valueOf(2), "Mod", "flanders",
                        "11212654", 565456, "mod.flan@gmail.com",
                        "Calle falsa 122", 0, city, occupation2)
        };

        logger.debug("Saving Providers...");
        this.repositoryProvider.save (Arrays.asList(providers));
        logger.debug(String.format("Providers saved %s", Arrays.toString(providers)));
    }


    @Test
    public void testFindAllByEmail () {

        String email = "marge.simpsons@gmail.com";

        ProviderEntity p = this.repositoryProvider.findByEmail(email);

        System.out.println(p);

        Assert.assertNotNull ("it is provider", p);
    }

    @Test
    public void testFindAllBydni () {

        int dni = 565456;

        ProviderEntity p = this.repositoryProvider.findBydni(dni);

        System.out.println(p);

        Assert.assertNotNull ("it is provider", p);
    }

    @Test
    public void testFindAllByPhone () {

        String phone = "11645889";

        ProviderEntity p = this.repositoryProvider.findByPhone(phone);

        System.out.println(p);

        Assert.assertNotNull ("it is provider", p);
    }


    @Test
    public void testFindAllByOccupations () {

        OccupationEntity o = new OccupationEntity();
        o.setId(2);

        List<ProviderEntity> p = this.repositoryProvider.findAllByOccupations(o);

        System.out.println(p);

        Assert.assertFalse ("There are providers", p.isEmpty());
    }

}
