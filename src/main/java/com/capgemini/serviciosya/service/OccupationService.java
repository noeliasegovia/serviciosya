
package com.capgemini.serviciosya.service;


import java.util.List;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.IOccupationDao;


public class OccupationService {


    private IOccupationDao occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (IOccupationDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }

    public void setOccupationDao(IOccupationDao occupationDao) {

        this.occupationDao = occupationDao;
    }

    public List<Occupation> findAllOccupations () {

        return this.occupationDao.findAllOccupations ();
    }

    public void addOccupation (Occupation occupation) {

        this.occupationDao.add (occupation);
    }
    
    public void removeOccupation (Occupation occupation) {
    	
    	this.occupationDao.remove(occupation);
    }
    
    public void update(Occupation occupation, String nameNew, String descriptionNew) {
		// TODO Auto-generated method stub
		occupation.setDescription(descriptionNew);
		occupation.setName(nameNew);
	}


}