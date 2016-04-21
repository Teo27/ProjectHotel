package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlLayer.CtrBooking;

public class CtrNumberOfPeopleTest {

	//testing checkInputData method as a part of addBooking method in CtrBooking class with different "number_of_people" inputs and capacity of the room 4;
	
	//inserting negative number of people (-1)
	@Test
	public void CtrNumberOfPeopleNegative() {
		
		String errorMessage;
		CtrBooking ctrBookObj = new CtrBooking();
		
		errorMessage = ctrBookObj.checkInputData("Default", "Default", java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"), 1, "default", "default", -1, 10, 0);
		
		if(errorMessage.length() == 0){
			
			System.out.println("Number of people (-1) - CTR check input data successful (expected Error) ");
		}
		else{
			
			System.out.println("Number of people (-1) - CTR check input data throws an Error (as expected) ");
			fail("Not yet implemented");
		}
	}
	
	//inserting null as number of people (0)
	@Test
	public void CtrNumberOfPeopleNull() {
		
		String errorMessage;
		CtrBooking ctrBookObj = new CtrBooking();
		
		errorMessage = ctrBookObj.checkInputData("Default", "Default", java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"), 1, "default", "default", 0, 10, 0);
		
		if(errorMessage.length() == 0){
			
			System.out.println("Number of people (0) - CTR check input data successful (expected Error) ");
		}
		else{
			
			System.out.println("Number of people (0) - CTR check input data throws an Error (as expected) ");
			fail("Not yet implemented");
		}
	}
	
	//inserting number of people in range (3)
	@Test
	public void CtrNumberOfPeopleInRange() {
		
		String errorMessage;
		CtrBooking ctrBookObj = new CtrBooking();
		
		errorMessage = ctrBookObj.checkInputData("Default", "Default", java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"), 1, "default", "default", 3, 10, 0);
		
		if(errorMessage.length() == 0){
			
			System.out.println("Number of people (3) - CTR check input data successful (as expected) ");
		}
		else{
			
			System.out.println("Number of people (3) - CTR check input data throws an Error (expected Success) ");
			fail("Not yet implemented");
		}
	}
	
	//inserting number of people on the edge (4)
	@Test
	public void CtrNumberOfPeopleEdge() {
		
		String errorMessage;
		CtrBooking ctrBookObj = new CtrBooking();
		
		errorMessage = ctrBookObj.checkInputData("Default", "Default", java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"), 1, "default", "default", 4, 10, 0);
		
		if(errorMessage.length() == 0){
			
			System.out.println("Number of people (4) - CTR check input data successful (as expected) ");
		}
		else{
			
			System.out.println("Number of people (4) - CTR check input data throws an Error (expected Success) ");
			fail("Not yet implemented");
		}
	}
	
	//inserting number of people not in range (5)
	@Test
	public void CtrNumberOfPeopleNotInRange() {
		
		String errorMessage;
		CtrBooking ctrBookObj = new CtrBooking();
		
		errorMessage = ctrBookObj.checkInputData("Default", "Default", java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"), 1, "default", "default", 5, 10, 0);
		
		if(errorMessage.length() == 0){
			
			System.out.println("Number of people (5) - CTR check input data successful (expected Error) ");
		}
		else{
			
			System.out.println("Number of people (5) - CTR check input data throws an Error (as expected) ");
			fail("Not yet implemented");
		}
	}

}
