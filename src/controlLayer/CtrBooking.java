package controlLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelLayer.MdlBooking;
import modelLayer.MdlCustomer;
import modelLayer.MdlRates;
import modelLayer.MdlRoom;
import modelLayer.MdlRoomType;
import dbLayer.DbBooking;
import dbLayer.DbCustomer;
import dbLayer.DbRates;
import dbLayer.DbRoom;
import dbLayer.DbRoomType;

public class CtrBooking {

	//contructor
	public CtrBooking(){
		
	}
	
	//refresh table method
	public ResultSet refreshTableBooking(){
		
		//declare result set
		ResultSet rs;
		//declare booking object in db layer
		DbBooking dbBookObj = new DbBooking();
		
		//assign result set to (select * from booking, in db layer)
		rs = dbBookObj.refreshTableBooking();
		
		//return result set (gui layer)
		return rs;
	}
	
	//select from table by clicking on the row
	public MdlBooking selectFromTableBooking(String selectedId){
		
		//declare booking object in db layer
		DbBooking dbBookObj = new DbBooking();
		//declare model object
		MdlBooking mdlBookObj = new MdlBooking();
		//declare boolean, saying whether discount is in percent or not
		boolean percent = true;
		
		//assign model object
		mdlBookObj = dbBookObj.selectFromTableBooking(selectedId);
		//assign model object (only changes price ) 
		mdlBookObj = calculatePrice(mdlBookObj, percent);
		
		//return model object (gui)
		return mdlBookObj;
	}
	
	//calculate price and set model object
	public MdlBooking calculatePrice(MdlBooking mdlBookObj, boolean percent){
		
		//declare price variables needed for calculation
		float price = 0, priceRoomType = 0, priceRates = 0;
		//booleans will be initialized from rates
		boolean breakfast, lunch, dinner;
		int discount;
		//declare number of days
		int days;
		
		//room model object
		MdlRoomType mdlRoomTypeObj = new MdlRoomType();
		//room db object
		DbRoomType dbRoomTypeObj = new DbRoomType();
		//rates model object
		MdlRates mdlRatesObj = new MdlRates();
		//rates db object
		DbRates dbRatesObj = new DbRates();
		
		//get room type from model Booking object
		String roomType = mdlBookObj.getRoomType();
		//get rates from model Booking object
		String rates = mdlBookObj.getRates();
		
		//assign room type object, passing roomType string (from model Booking)
		mdlRoomTypeObj = dbRoomTypeObj.selectFromTableRoomType(roomType);
		//get price of particular room type
		priceRoomType = mdlRoomTypeObj.getPrice();
		
		mdlRatesObj = dbRatesObj.selectFromTableRates(rates);
		breakfast = mdlRatesObj.isBreakfast();
		lunch = mdlRatesObj.isLunch();
		dinner = mdlRatesObj.isDinner();
		
		//calculate number of days between two dates
		days = (int) (mdlBookObj.getBookedTill().getTime() - mdlBookObj.getBookedFrom().getTime()) / (1000 * 60 * 60 * 24);
		
		//add price based on value of booleans (services)
		if(breakfast == true){
			
			priceRates += 50;
		}
		
		if(lunch == true){
			
			priceRates += 150;
		}
		
		if(dinner == true){
			
			priceRates += 200;
		}
		
		//if discount is in percent
		if(percent == true){
			
			//assign discount and calculate price
			discount = mdlBookObj.getDiscount();
			price = ((priceRoomType + priceRates) * days);
			price = price - ((price /100) * discount);
			//set price to model booking object
			mdlBookObj.setPrice(price);
		}
		else{
			
			//assign discount and calculate price
			float ammount = mdlBookObj.getDiscountAmmount();
			price = ((priceRoomType + priceRates) * days);
			price = price - ammount;
			//set price in model booking object
			mdlBookObj.setPrice(price);
		}
		
		//return booking model object
		return mdlBookObj;
	}
	
	public MdlRoom selectFromTableBookingRooms(String selectedRoomNumber){
		
		DbBooking dbBookObj = new DbBooking();
		MdlRoom mdlRoomObj = new MdlRoom();
		
		mdlRoomObj = dbBookObj.selectFromTableBookingRooms(selectedRoomNumber);
		
		return mdlRoomObj;
	}
	
	//search if room is available for this time interval
	public ResultSet searchDate(java.sql.Date bookedFrom, java.sql.Date bookedTill){
		
		//declare result sets:
		//final result set of free rooms
		ResultSet rsFinal;
		//result set holding only free rooms
		ResultSet rsAllRooms;
		//result set holding occupied rooms
		ResultSet rsOccupiedRooms;
		
		DbBooking dbBookObj = new DbBooking();
		DbRoom dbRoomObj = new DbRoom();
		
		//declare array list
		ArrayList<Integer> allRooms = new ArrayList<Integer>();
		ArrayList<Integer> occupiedRooms = new ArrayList<Integer>();
		ArrayList<Integer> freeRooms = new ArrayList<Integer>();
		
		int currentRoom = 0;
		
		try{
			
			//get result set containing all rooms
			rsAllRooms = dbRoomObj.refreshTableRoom();
			//get result set containing occupied rooms
			rsOccupiedRooms = dbBookObj.searchOccupiedRooms(bookedFrom, bookedTill);
			
			//go through result set
			while(rsAllRooms.next()){
				
				//assign current room number to integer variable
				currentRoom =rsAllRooms.getInt("room_number");
				//add room number to array list
				allRooms.add(currentRoom);
			}
			
			//same with occupied rooms
			while(rsOccupiedRooms.next()){
				
				currentRoom =rsOccupiedRooms.getInt("room_number");
				occupiedRooms.add(currentRoom);
			}
			
			//get free rooms array list ( allRooms - occupied ) 
			freeRooms = getFreeRooms(allRooms, occupiedRooms);
			//get result set
			rsFinal = dbRoomObj.searchFreeRooms(freeRooms);
		}
		catch(Exception e){
			
			System.out.print("Error while searching.\n");
			return null;
		}

		return rsFinal;
	}
	
	public boolean checkExistingCheckIn(int id){
		
		//check if rooms was checked in already
		boolean exists = true;
		DbBooking dbBookObj = new DbBooking();
		
		exists = dbBookObj.checkExistingCheckIn(id);
		
		return exists;
	}
	
	public boolean checkCheckInDate(int id){
		
		//method checks if its already possible to check in
		boolean success = false;
		MdlBooking mdlBookObj = new MdlBooking();
		DbBooking dbBookObj = new DbBooking();
		//booked from date of booking
		java.sql.Date bookedFrom;
		//declare current date as Date object
		Date currentDate = new Date();
				
		//get modelBookObject passing ID
		mdlBookObj = dbBookObj.selectFromTableBooking(Integer.toString(id));
		//initialize booked from with date of model object
		bookedFrom = mdlBookObj.getBookedFrom();
		
		//if current date is after (or same) as booked from
		if(currentDate.compareTo(bookedFrom) > 0){
			
			success = true;
		}
		
		return success;
	}
	
	public void checkInCurrentDate(int id){
		
		//check in with current date
		String currentDate;
		//declare date object
		Date date = new Date();
		//declare date format
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DbBooking dbBookObj = new DbBooking();
		
		//get string of current date in date format
		currentDate = dateFormat.format(date);
		//do check in in db layer
		dbBookObj.checkInCurrentDate(currentDate, id);
	}
	
	public java.sql.Date getCheckInDate(int id){
		
		java.sql.Date checkIn;
		DbBooking dbBookObj = new DbBooking();
		
		checkIn = dbBookObj.getCheckInDate(id);
		
		return checkIn;
	}
	
	//checks inputed data by user
	public String checkInputData(String customerUsername, String employeeUsername, java.sql.Date bookedFrom, java.sql.Date bookedTill,  int roomNumber, String roomType, String rates, int numberOfPeople, int discountPercent, float discountAmmount){
		
		 CtrData ctrBookDatObj = new CtrData();
		 //declare error message, initialize it empty ( to be able to add to it)
		 String errorMessage = "";
		 
		 //check critical atributes
		 errorMessage =  ctrBookDatObj.checkCustomerUsername(customerUsername);
		 errorMessage =  ctrBookDatObj.checkEmployeeUsername(employeeUsername);
		 errorMessage =  ctrBookDatObj.checkRoomNumberMax(roomNumber);
		 errorMessage =  ctrBookDatObj.checkNumberOfPeople(numberOfPeople, roomNumber);
		 errorMessage =  ctrBookDatObj.checkDiscountPercent(discountPercent);
		 errorMessage = ctrBookDatObj.checkDates(bookedFrom, bookedTill);
		 
		 return errorMessage;
	}
	
	//insert booking method
	public boolean addBooking(String customerUsername, String employeeUsername, java.sql.Date bookedFrom, java.sql.Date bookedTill,  int roomNumber, String roomType, String rates, int numberOfPeople, int discountPercent, float discountAmmount, float price){
		
 		MdlBooking mdlBookObj = new MdlBooking();
 		DbBooking dbBookObj = new DbBooking();
	 
		boolean success = false;
					
		//set model object
		mdlBookObj.setCustomerUsername(customerUsername); 
		mdlBookObj.setEmployeeUsername(employeeUsername);
		mdlBookObj.setBookedFrom(bookedFrom);
		mdlBookObj.setBookedTill(bookedTill);
		mdlBookObj.setRoomNumber(roomNumber);
		mdlBookObj.setRoomType(roomType);
		mdlBookObj.setRates(rates);
		mdlBookObj.setNumberOfPeople(numberOfPeople);
		
		//if discount is in ammount
		if(discountPercent == 0 && discountAmmount > 0){
			
			//calculate discount in percent and set model object
			price = price + discountAmmount;
			discountPercent = Math.round((discountAmmount / (price / 100)));
			mdlBookObj.setDiscount(discountPercent);
		}
		else{
			
			//set model object ( discount is in percent already)
			mdlBookObj.setDiscount(discountPercent);
		}

		try{
			
			//insert booking
			success = dbBookObj.insertBooking(mdlBookObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating a Customer Object.");
		}
		
		return success;
	}
		
	public boolean deleteBooking(int id){
		
		DbBooking dbBookObj = new DbBooking();
		boolean success = false;
		
		try{
			
			success = dbBookObj.deleteBooking(id);
		}
		catch(Exception e){
			
			System.out.println("Error while deleting a Booking.");
		}
		
		return success;
	}
	
	public ResultSet searchBooking(String selection, String searchBooking){
		
		DbBooking dbBookObj = new DbBooking();
		ResultSet rs;
		
		try{
			
			rs = dbBookObj.searchBooking(selection, searchBooking);
		}
		catch(Exception e){
			
			System.out.println("Error while searching a Booking.");
			return null;
		}
		
		return rs;
	}
	
	//find free rooms
	public ArrayList<Integer> getFreeRooms(ArrayList<Integer> allRooms, ArrayList<Integer> occupiedRooms){
		
		//declare arry list
		ArrayList<Integer> freeRooms = new ArrayList<Integer>();
		
		
		int counter = 0;
		//go through all rooms arraylist
		for (int intRoom : allRooms) {
		    
			//go through occupied rooms arry list
			for (int intOccupRoom: occupiedRooms) {
			    
				//if roomNumber(from all rooms) is accupied add counter
				if(intOccupRoom == intRoom ){
					
					counter++;
				}
			}
			
			//if counter is null ( if roomNumber from all rooms ISNT accupied, add room number to free room arraylist
			if(counter == 0){
				freeRooms.add(intRoom);
			}
			else{
				
			//if ocunter isnt null, assign it to null
				counter = 0;
			}
		}
		
		//return array list
		return freeRooms;
	}
}
