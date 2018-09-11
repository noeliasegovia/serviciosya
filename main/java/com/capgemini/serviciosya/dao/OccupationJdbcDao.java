package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.domain.Occupation;

import java.util.List;

public class OccupationJdbcDao implements IOccupationDao {

  @Override
  public List<Occupation> findAllOccupations() {
    return null;
  }

  @Override
  public void add(Occupation occupation) {

  }

  @Override
  public void remove(Occupation occupation) {
	  // TODO Auto-generated method stub
	 
  }

@Override
public void update(Occupation occupation, String name, String description) {
	// TODO Auto-generated method stub
	
}




}
