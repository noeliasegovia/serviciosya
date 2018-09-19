package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import java.util.List;

public interface IProviderDao {

    public void save(ProviderEntity p);

    public void delete(Integer id);

    public void update(ProviderEntity p );

    ProviderEntity findByEmail (String email);

    ProviderEntity findByDNI (Integer dni);

    ProviderEntity findByPhone (String phone);

    public ProviderEntity findById (Integer id);

    public List<ProviderEntity> list();

}
