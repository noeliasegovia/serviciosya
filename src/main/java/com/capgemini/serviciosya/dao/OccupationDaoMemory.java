
package com.capgemini.serviciosya.dao;


import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.*;

import com.capgemini.serviciosya.beans.domain.Occupation;


public class OccupationDaoMemory implements IOccupationDao {


    private Map<String, Occupation> occupations;


    public OccupationDaoMemory() {

        super ();

        this.occupations = new TreeMap<>();

        // Load occupations.
        Occupation o1 = new Occupation (randomAlphabetic(5),
                                        "Entandador de Serpientes",
                                    "Entandador de Serpientes");

        Occupation o2 = new Occupation (randomAlphabetic(5),
                                       "Cuidador de Suegras",
                                   "Cuidador de Suegras");

        // Add values to map.
        this.occupations.put (o1.getId (), o1);
        this.occupations.put (o2.getId (), o2);
    }

    @Override
    public List<Occupation> findAllOccupations () {

        // Get the entries.
        Set<Map.Entry<String, Occupation>> entries = this.occupations.entrySet ();

        // Build the occupation list.
        List<Occupation> list = new ArrayList<> ();
        for (Map.Entry<String, Occupation> item: entries) {

            list.add (item.getValue ());
        }

        // Return the occupations.
        return list;
    }

    @Override
    public void add (Occupation occupation) {

        this.occupations.put (occupation.getId (), occupation);
    }


	@Override
	public void remove( Occupation occupation) {
		// TODO Auto-generated method stub
		 this.occupations.remove(occupation.getId(), occupation);
	}

	@Override
	public void update(Occupation occupation, String nameNew, String descriptionNew) {
		// TODO Auto-generated method stub
		occupation.setDescription(descriptionNew);
		occupation.setName(nameNew);
	}


	

}