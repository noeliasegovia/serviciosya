
package com.capgemini.serviciosya.dao;


import java.util.List;

import com.capgemini.serviciosya.beans.domain.Occupation;


public interface IOccupationDao {


    List<Occupation> findAllOccupations ();

    void add (Occupation occupation);

	void remove(Occupation occupation);
	
	void update(Occupation occupation, String nameNew, String descriptionNew);

    //Occupation searchById(String id);
}
