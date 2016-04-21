package controlLayer;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import dbLayer.DbArchive;
import dbLayer.DbBooking;
import dbLayer.DbCustomer;
import dbLayer.DbEmployee;
import dbLayer.DbInvoice;
import dbLayer.DbRoom;

public class CtrStatistics {

	public CtrStatistics(){
		
	}
	
	public int getRegisteredCustomers(){
		
		int customers = 0;
		ResultSet rsCus;
		DbCustomer dbCusObj = new DbCustomer();
		
		try{
			
			rsCus=dbCusObj.refreshTableCustomer();
			while(rsCus.next()){
				
				customers++;
			}
		}
		catch(Exception e){
			
			System.out.println("Error while getting customer statistics");
			return (Integer) null;
		}
		
		return customers;
	}
	
	public int getDanishCustomers(){
		
		int customers = 0;
		ResultSet rsCus;
		DbCustomer dbCusObj = new DbCustomer();
		
		try{
			
			rsCus=dbCusObj.refreshTableCustomer();
			while(rsCus.next()){
				
				if(rsCus.getString("Country").equals("Denmark") || rsCus.getString("Country").equals("denmark")){
					
					customers++;
				}
			}
		}
		catch(Exception e){
			
			System.out.println("Error while getting customer statistics");
			return (Integer) null;
		}
		
		return customers;
	}
	
	public int getRegisteredEmployees(){
		
		int employees = 0;
		ResultSet rsEmp;
		DbEmployee dbEmpObj = new DbEmployee();
		
		try{
			
			rsEmp=dbEmpObj.refreshTableEmployee();
			while(rsEmp.next()){
				
				employees++;
			}
		}
		catch(Exception e){
			
			System.out.println("Error while getting employee statistics");
			return (Integer) null;
		}
		
		return employees;
	}
	
	public float getAvarageSalary(){
		
		float avarageSalary = 0;
		int employees = 0;
		ResultSet rsEmp;
		DbEmployee dbEmpObj = new DbEmployee();
		
		try{
			
			rsEmp = dbEmpObj.refreshTableEmployee();
			while(rsEmp.next()){
				
				avarageSalary += rsEmp.getFloat("salary");
				employees ++;
			}
			
			avarageSalary /= employees;
		}
		catch(Exception e){
			
			System.out.println("Error while getting employee statistics");
			return (Float) null;
		}
		
		
		return avarageSalary;
	}
	
	public int getNumberOfRooms(){
		
		int rooms = 0;
		ResultSet rsRoom;
		DbRoom dbRoomObj = new DbRoom();
		
		try{
			
			rsRoom=dbRoomObj.refreshTableRoom();
			while(rsRoom.next()){
				
				rooms++;
			}
		}
		catch(Exception e){
			
			System.out.println("Error while getting room statistics");
			return (Integer) null;
		}
		return rooms;
	}
	
	public int getNumberOfBookings(){
		
		int bookings = 0;
		ResultSet rsBook;
		DbBooking dbBookObj = new DbBooking();
		
		try{
			
			rsBook=dbBookObj.refreshTableBooking();
			while(rsBook.next()){
				
				bookings++;
			}
		}
		catch(Exception e){
			
			System.out.println("Error while getting booking statistics");
			return (Integer) null;
		}
		return bookings;
	}
	
	public int getCheckedIn(){
		
		int bookings = 0;
		ResultSet rsBook;
		DbBooking dbBookObj = new DbBooking();
		
		try{
			
			rsBook=dbBookObj.refreshTableBooking();
			while(rsBook.next()){
				
				if(rsBook.getDate("checked_in") != null){
					
					bookings++;
				}
			}
		}
		catch(Exception e){
			
			System.out.println("Error while getting booking statistics");
			return (Integer) null;
		}
		return bookings;
	}
	
	public int getOccupancy(int roomNumber, int year){
		
		int days = 0;
		int sumDays = 0;
		ResultSet rs;
		DbArchive dbArchObj = new DbArchive();
		java.sql.Date from;
		java.sql.Date till;
		
		try{
			
			rs = dbArchObj.getOccupancy(year, roomNumber);
			while(rs.next()){
				
				from = rs.getDate("booked_from");
				till = rs.getDate("checked_out");
				
				days = calculateNumberOfDays(from, till, year);
				sumDays = sumDays + days;
			}
		}
		catch(Exception e){
			
			System.out.println("Error while counting occupancy days");
		}
		return sumDays;
	}
	
	public int calculateNumberOfDays(java.sql.Date dateFrom, java.sql.Date dateTill, int year){
		
		int days = 0;
		String min = year + "-01-01";
		String max = year + "-12-31";

		java.sql.Date dateMin = java.sql.Date.valueOf(min);
		java.sql.Date dateMax = java.sql.Date.valueOf(max);
	
		if(dateFrom.compareTo(dateMin) >= 0 && dateMax.compareTo(dateTill) >= 0){
			//interval is in the range
			
			days = (int) (dateTill.getTime() - dateFrom.getTime()) / (1000 * 60 * 60 * 24);
			if(days == 0){
				
				days = 1;
			}
			
		}		
		
		return days;
	}
	public float getAvaragePrice(){
		
		DbInvoice dbInvObj = new DbInvoice();
		ResultSet rs;
		int counter = 0;
		float price = 0;
		
		try{
			
			rs = dbInvObj.refreshTableInvoice();
			while(rs.next()){
				
				price = price + rs.getFloat("price");
				counter++;
			}
			
		price = price / counter;
			
		}catch(Exception e){
			
			System.out.println("Error while calculating the invoice");
		}
		return price;
	}
}
