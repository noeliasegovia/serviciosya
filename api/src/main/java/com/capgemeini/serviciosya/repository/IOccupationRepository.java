
package com.capgemeini.serviciosya.repository;


import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IOccupationRepository extends JpaRepository<OccupationEntity, Integer> {

    List<OccupationEntity> findAllByOccupation (OccupationEntity occupation);
}