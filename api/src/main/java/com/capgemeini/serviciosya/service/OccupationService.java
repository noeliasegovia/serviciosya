
package com.capgemeini.serviciosya.service;


import com.capgemeini.serviciosya.repository.IOccupationRepository;


public class OccupationService {


    private IOccupationRepository occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (IOccupationRepository occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }



}