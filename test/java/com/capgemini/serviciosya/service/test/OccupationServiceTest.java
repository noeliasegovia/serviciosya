package com.capgemini.serviciosya.service.test;


import java.util.List;

import com.capgemini.serviciosya.dao.IOccupationDao;
import com.capgemini.serviciosya.dao.OccupationDaoMemory;
import org.junit.Assert;
import org.junit.Test;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.service.OccupationService;

public class OccupationServiceTest {
	
	private OccupationService occupationService = new OccupationService ();

    private IOccupationDao occupationDao = new OccupationDaoMemory ();


    @Test
    public void testFindAllOccupations () {


        this.occupationService.setOccupationDao (this.occupationDao);

        List<Occupation> list = this.occupationService.findAllOccupations ();

        Assert.assertFalse (list.isEmpty ());
    }

    @Test
    public void testAddOccupation () {


        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");

        List<Occupation> init = this.occupationDao.findAllOccupations ();

        this.occupationService.addOccupation (o);

        List<Occupation> end = this.occupationDao.findAllOccupations ();

        Assert.assertTrue (init.size()+1 == end.size());
    }

  @Test
  
  public void testDeleteOccupation() {
      this.occupationService.setOccupationDao (this.occupationDao);

      Occupation a = new Occupation ("2", "vigilante", "vigilar ...");
      occupationService.addOccupation(a);

      List<Occupation> listan = this.occupationService.findAllOccupations ();
      
      this.occupationService.removeOccupation(a);
      

      List<Occupation> listam = this.occupationService.findAllOccupations ();
      
      Assert.assertTrue(listan.size() == listam.size()+1);
  }
  
 @Test
  
  public void testUpdateOccupation() {
	  this.occupationService.setOccupationDao(occupationDao);
	  
	  Occupation b = new Occupation("3","maestra","enseña");
	  
	  List<Occupation> listab = this.occupationService.findAllOccupations ();
	  
	  this.occupationService.update(b, "profesora", "educa");
	  
	  List<Occupation> listac = this.occupationService.findAllOccupations ();
	  
	  Assert.assertTrue(listab.equals(listac));
	  
	  
  }
}
