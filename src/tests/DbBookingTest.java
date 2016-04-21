package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import modelLayer.MdlBooking;

import org.junit.Test;

import dbLayer.DbBooking;

public class DbBookingTest {

	@Test
	public void dbRefreshTableBooking() {
		
		
		ResultSet rs;
		DbBooking dbBookObj = new DbBooking();
		
		rs = dbBookObj.refreshTableBooking();
		
		if(rs != null){
			
			System.out.println("Booking - DB refresh table Booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void dbSelectFromTableBooking(){
		
		DbBooking dbBookObj = new DbBooking();
		MdlBooking mdlBookObj = new MdlBooking();
		
		mdlBookObj = dbBookObj.selectFromTableBooking("2");
		
		if(mdlBookObj.getCustomerUsername() != null){
			
			System.out.println("Booking - DB select from table Booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void dbAddBooking(){
		
		boolean success = false;
		DbBooking dbBookObj = new DbBooking();
		MdlBooking mdlBookObj = new MdlBooking();
		
		mdlBookObj.setCustomerUsername("Default");
		mdlBookObj.setEmployeeUsername("Default");
		mdlBookObj.setBookedFrom(java.sql.Date.valueOf("2015-06-13"));
		mdlBookObj.setBookedTill(java.sql.Date.valueOf("2015-06-16"));
		mdlBookObj.setRoomNumber(1);
		mdlBookObj.setRoomType("single");
		mdlBookObj.setRates("FB");
		mdlBookObj.setNumberOfPeople(1);
		mdlBookObj.setDiscount(10);
		
		success = dbBookObj.insertBooking(mdlBookObj);
		
		if(success == true){
			
			System.out.println("Booking - DB insert booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void dbUpdateBooking(){
		
		boolean success = false;
		DbBooking dbBookObj = new DbBooking();
		MdlBooking mdlBookObj = new MdlBooking();
		
		mdlBookObj.setId(1);
		mdlBookObj.setCustomerUsername("Default");
		mdlBookObj.setEmployeeUsername("Default");
		mdlBookObj.setBookedFrom(java.sql.Date.valueOf("2015-06-13"));
		mdlBookObj.setBookedTill(java.sql.Date.valueOf("2015-06-16"));
		mdlBookObj.setRoomNumber(1);
		mdlBookObj.setRoomType("single");
		mdlBookObj.setRates("FB");
		mdlBookObj.setNumberOfPeople(1);
		mdlBookObj.setDiscount(10);
		
		success = dbBookObj.updateBooking(mdlBookObj);
		
		if(success == true){
			
			System.out.println("Booking - DB update booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void dbDeleteBooking(){
		
		boolean success = false;
		DbBooking dbBookObj = new DbBooking();
		
		success = dbBookObj.deleteBooking(1);
		
		if(success == true){
			
			System.out.println("Booking - DB delete booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void dbSearchBooking(){
		
		ResultSet rs;
		DbBooking dbBookObj = new DbBooking();
		
		rs = dbBookObj.searchBooking("customer_username", "Default");
		
		if(rs != null){
			
			System.out.println("Booking - DB search booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	

}
