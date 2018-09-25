
package com.capgemeini.serviciosya.dao;


import com.capgemeini.serviciosya.beans.domain.Occupation;
import com.capgemeini.serviciosya.beans.entity.OccupationEntity;


public interface IOccupationDao extends IDao<OccupationEntity, Integer> {

    OccupationEntity findByName (String name);
}