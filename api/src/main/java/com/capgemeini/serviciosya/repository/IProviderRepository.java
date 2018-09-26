
package com.capgemeini.serviciosya.repository;

import com.capgemeini.serviciosya.beans.entity.ProviderEntity;
import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProviderRepository extends JpaRepository<ProviderEntity, Integer> {


    ProviderEntity findByEmail (String email);

    ProviderEntity findBydni (Integer dni);

    ProviderEntity findByPhone (String phone);

    List<ProviderEntity> findAllByOccupations (OccupationEntity occupation);
}