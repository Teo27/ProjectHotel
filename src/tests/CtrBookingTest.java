package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import modelLayer.MdlBooking;

import org.junit.Test;

import controlLayer.CtrBooking;

public class CtrBookingTest {

	@Test
	public void ctrRefreshTableBooking() {

		ResultSet rs;
		CtrBooking ctrBookObj = new CtrBooking();
		
		rs = ctrBookObj.refreshTableBooking();
		
		if(rs != null){
			
			System.out.println("Booking - CTR refresh table Booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test 
	public void ctrSelectFromTableBooking(){
		
		CtrBooking ctrBookObj = new CtrBooking();
		MdlBooking mdlBookObj = new MdlBooking();
		
		mdlBookObj = ctrBookObj.selectFromTableBooking("2");
		
		if(mdlBookObj.getCustomerUsername() != null){
			
			System.out.println("Booking - CTR select from table Booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void ctrCalculatePrice(){
		
		CtrBooking ctrBookObj = new CtrBooking();
		MdlBooking mdlBookObj = new MdlBooking();
		
		mdlBookObj.setRoomType("single");
		mdlBookObj.setRates("FB");
		mdlBookObj.setBookedFrom(java.sql.Date.valueOf("2016-01-01"));
		mdlBookObj.setBookedTill(java.sql.Date.valueOf("2016-01-06"));
		mdlBookObj.setDiscount(10);
		
		mdlBookObj = ctrBookObj.calculatePrice(mdlBookObj, true);
		
		assertEquals(6300,mdlBookObj.getPrice(),0);
	}
	
	@Test
	public void ctrSearchDate(){
		
		CtrBooking ctrBookObj = new CtrBooking();
		ResultSet rs;
		
		rs = ctrBookObj.searchDate(java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"));
		
		if(rs != null){
			
			System.out.println("Booking - CTR search date successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void checkInputData(){
		
		String errorMessage;
		CtrBooking ctrBookObj = new CtrBooking();
		
		errorMessage = ctrBookObj.checkInputData("ERROR", "Default", java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"), 1, "default", "default", 1, 10, 0);
		
		if(errorMessage.length() != 0){
			
			System.out.println("Booking - CTR check input data successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void ctrAddBooking(){
		
		boolean success;
		CtrBooking ctrBookObj = new CtrBooking();
		
		success = ctrBookObj.addBooking("Default", "Default", java.sql.Date.valueOf("2016-01-01"), java.sql.Date.valueOf("2016-01-06"), 1, "single", "BB", 1, 10, 0, 1000);
		
		if(success == true){
			
			System.out.println("Booking - CTR add booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void ctrDeleteBooking(){
		
		boolean success;
		CtrBooking ctrBookObj = new CtrBooking();
		
		success = ctrBookObj.deleteBooking(1);
		
		if(success == true){
			
			System.out.println("Booking - CTR delete booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void ctrSearchBooking(){
		
		ResultSet rs;
		CtrBooking ctrBookObj = new CtrBooking();
		
		rs = ctrBookObj.searchBooking("customer_username", "default");
		
		if(rs != null){
			
			System.out.println("Booking - CTR search Booking successful");
		}
		else{
			
			fail("Not yet implemented");
		}
	}

}
