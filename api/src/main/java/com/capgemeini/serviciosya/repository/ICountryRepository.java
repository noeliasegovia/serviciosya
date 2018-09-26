
package com.capgemeini.serviciosya.repository;


import com.capgemeini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity, Integer> {


      CountryEntity findByName (String name);
}