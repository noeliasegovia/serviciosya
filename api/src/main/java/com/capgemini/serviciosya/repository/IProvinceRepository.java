
package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {

    List<ProvinceEntity> findAllByCountryOrderByName (CountryEntity country);

}
