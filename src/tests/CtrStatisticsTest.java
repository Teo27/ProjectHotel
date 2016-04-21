package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlLayer.CtrStatistics;

public class CtrStatisticsTest {

	@Test
	public void  ctrGetOccupancy() {
		
		CtrStatistics ctrStatObj = new CtrStatistics();
		int days;
		
		days = ctrStatObj.getOccupancy(1, 2015);
		
		if(days > 0){
			
			System.out.println("Statistics - CTR get Occupancy successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void ctrCalculateNumberOfDays(){
		
		CtrStatistics ctrStatObj = new CtrStatistics();
		int days;
		
		days = ctrStatObj.calculateNumberOfDays(java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-05"), 2016);
		
		if(days > 0){
			
			System.out.println("Statistics - CTR get Occupancy successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}

}
