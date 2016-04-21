package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Test;

import dbLayer.DbArchive;

public class DbArchiveTest {

	@Test
	public void dbGetOccupancy(){
		
		DbArchive dbArchObj = new DbArchive();
		ResultSet rs;
		
		rs = dbArchObj.getOccupancy(2015, 1);
		
		if(rs != null){
			
			System.out.println("Archive - DB get Occupancy successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}

}
