package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity,Integer> {

        ClientEntity findByEmail (String email);

        ClientEntity findBydni (Integer dni);

        ClientEntity findByPhone (String phone);

}
