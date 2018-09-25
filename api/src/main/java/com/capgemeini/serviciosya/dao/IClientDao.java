package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.ClientEntity;

public interface IClientDao extends IDao <ClientEntity,Integer> {

    ClientEntity findByEmail (String email);

    ClientEntity findByDNI (Integer dni);

    ClientEntity findByPhone (String phone);

}
