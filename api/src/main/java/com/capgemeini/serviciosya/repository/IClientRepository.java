package com.capgemeini.serviciosya.repository;

import com.capgemeini.serviciosya.beans.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity,Integer> {

        ClientEntity findByEmail (String email);

        ClientEntity findBydni (Integer dni);

        ClientEntity findByPhone (String phone);

}
