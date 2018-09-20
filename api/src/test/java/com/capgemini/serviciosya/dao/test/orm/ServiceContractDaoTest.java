package com.capgemini.serviciosya.dao.test.orm;

import com.capgemini.serviciosya.beans.entity.ServiceContractEntity;
import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.beans.entity.ClientEntity;
import com.capgemini.serviciosya.dao.IServiceContractDao;
import com.capgemini.serviciosya.dao.orm.ServiceContractHibernate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class ServiceContractDaoTest {

    private IServiceContractDao dao = new ServiceContractHibernate ();

    @Test
    public void testCreate() {

        ServiceContractEntity s = new ServiceContractEntity();
        ClientEntity c = new ClientEntity();
        ProviderEntity p = new ProviderEntity();
        c.setId(1);
        p.setId(1);
        s.setDescription("servicio de entretenimiento");
        s.setPrice(100);
        s.setWaytopay(1);
        s.setStatus(1);
        s.setClient(c);
        s.setProvider(p);

        this.dao.create(s);

        Assert.assertNotNull("Failure creating new service contract.", s.getId());
    }



}
