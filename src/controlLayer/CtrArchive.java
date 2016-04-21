package controlLayer;

import java.sql.ResultSet;

import modelLayer.MdlArchive;
import modelLayer.MdlCustomer;
import dbLayer.DbArchive;
import dbLayer.DbBooking;
import dbLayer.DbCustomer;

public class CtrArchive {

	public CtrArchive(){
		
	}
	
	public ResultSet refreshTableArchive(){
		
		ResultSet rs;
		DbArchive dbArchObj = new DbArchive();
		
		rs = dbArchObj.refreshTableArchive();

		return rs;
	}
	
	public boolean addArchive(String name, String surname, String country, String city, String street, 
			String zipCode, String contact, java.sql.Date bookedFrom, java.sql.Date bookedTill, java.sql.Date checkedIn, java.sql.Date checkedOut, int roomNumber){
		
 		MdlArchive mdlArchObj = new MdlArchive();
 		DbArchive dbArchObj = new DbArchive();
	 
		boolean success = false;

		mdlArchObj.setName(name);
		mdlArchObj.setSurname(surname);
		mdlArchObj.setCountry(country);
		mdlArchObj.setCity(city);
		mdlArchObj.setStreet(street);
		mdlArchObj.setZipCode(zipCode);
		mdlArchObj.setContact(contact);
		mdlArchObj.setBookedFrom(bookedFrom);
		mdlArchObj.setBookedTill(bookedTill);
		mdlArchObj.setCheckedIn(checkedIn);
		mdlArchObj.setCheckedOut(checkedOut);
		mdlArchObj.setRoomNumber(roomNumber);

		try{
			
			success = dbArchObj.insertArchive(mdlArchObj);
		}
		catch(Exception e){
			
			System.out.println("Error while inserting to Archive.");
		}
		
		return success;
	}
	
	public ResultSet searchArchive(String selection, String searchArchive){
		
		DbArchive dbArchObj = new DbArchive();
		ResultSet rs;
		
		try{
			
			rs = dbArchObj.searchArchive(selection, searchArchive);
		}
		catch(Exception e){
			
			System.out.println("Error while searching an Archive.");
			return null;
		}
		
		return rs;
	}
}
