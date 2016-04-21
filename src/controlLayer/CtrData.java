package controlLayer;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbLayer.DbBooking;
import dbLayer.DbCustomer;
import dbLayer.DbEmployee;
import dbLayer.DbRoom;

public class CtrData {

	String errorMessage = "";
	
	public CtrData(){
		
	}
	
	public String checkUsername(String username){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z0-9]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(username);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect username\n";
		}
		
		return errorMessage;
	}
	
	public String checkSecurityLevel(int securityLevel){
		
		DbEmployee dbEmpObj = new DbEmployee();
		int maxSecurityLevel = dbEmpObj.getMaxSecurityLevel();
		
		if(securityLevel > maxSecurityLevel){
			
			errorMessage = 	errorMessage + "Incorrect security level (max " + maxSecurityLevel + " ) \n";
		}
		
		return errorMessage;
	}
	
	public String checkName(String name){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(name);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect name\n";
		}
		
		return errorMessage;
	}
	
	public String checkSurname(String surname){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(surname);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect surname\n";
		}
		
		return errorMessage;
	}
	
	public String checkGender(String gender){
				
		if(gender == null){
			
			errorMessage = errorMessage + "Incorrect gender\n";
		}
		
		return errorMessage;
	}
	
	public String checkCountry(String country){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(country);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect country\n";
		}
		
		return errorMessage;
	}
	
	public String checkCity(String city){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(city);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect city\n";
		}
		
		return errorMessage;
	}
	
	public String checkStreet(String street){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(street);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect street\n";
		}
		
		return errorMessage;
	}
	
	public String checkZipCode(String zipCode){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^0-9]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(zipCode);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect zip code\n";
		}
		
		return errorMessage;
	}
	
	public String checkContact(String contact){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^+]+^[0-9]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(contact);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect contact\n";
		}
		
		return errorMessage;
	}
	
	public String checkContractType(String contractType){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(contractType);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect contract type\n";
		}
		
		return errorMessage;
	}
	
	public String checkSsn(int ssn){
		
		String sSsn = Integer.toString(ssn);
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^0-9]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(sSsn);
		
		if(m.find() || sSsn.length() != 6){
			
			errorMessage = errorMessage + "Incorrect ssn (use number of 6 digits)\n";
		}
		
		return errorMessage;
	}
	
	public String checkDepartmentNumber(int departmentNumber){
		
		DbEmployee dbEmpObj = new DbEmployee();
		int maxDepartmentNumber = dbEmpObj.getMaxDepartmentNumber();
		
		if(departmentNumber  > maxDepartmentNumber){
			
			errorMessage = 	errorMessage + "Incorrect department number (max " + maxDepartmentNumber + " ) \n";
		}
		
		return errorMessage;
	}
		
	public String checkRoomNumber(int roomNumber){
		
		String sRoomNumber = Integer.toString(roomNumber);
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^0-9]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(sRoomNumber);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect room number\n";
		}
		
		return errorMessage;
	}
	
	public String checkPrice(float price){
		
		String sPrice = Float.toString(price);
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(sPrice);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect price\n";
		}
		
		return errorMessage;
	}
	
	public String checkCapacity(int capacity){
		
		String sCapacity = Integer.toString(capacity);
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^0-9]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(sCapacity);
		
		if(m.find() || capacity >4){
			
			errorMessage = errorMessage + "Incorrect capacity (max 4)\n";
		}
		
		return errorMessage;
	}
	
	public String checkCustomerUsername(String customerUsername){
		
		DbBooking dbBookObj = new DbBooking();
		boolean exists = false;
		
		exists = dbBookObj.checkCustomerUsername(customerUsername);
		if(exists  == false){
			
			errorMessage = 	errorMessage + "Incorrect customer username \n";
		}
		
		return errorMessage;
	}
	
	public String checkEmployeeUsername(String employeeUsername){
		
		DbBooking dbBookObj = new DbBooking();
		boolean exists = false;
		
		exists = dbBookObj.checkEmployeeUsername(employeeUsername);
		if(exists  == false){
			
			errorMessage = 	errorMessage + "Incorrect employee username \n";
		}
		
		return errorMessage;
	}
	
	public String checkRoomNumberMax(int roomNumber){
		
		DbRoom dbRoomObj = new DbRoom();
		int maxRoomNumber;
		
		maxRoomNumber = dbRoomObj.getMaxRoomNumber();
		if(roomNumber > maxRoomNumber){
			
			errorMessage = 	errorMessage + "Incorrect room number ( max "+ maxRoomNumber + ") \n";
		}
		
		return errorMessage;
	}
	
	public String checkRoomType(int roomType){
		
		DbBooking dbBookingObj = new DbBooking();
		int maxRoomType;
		
		maxRoomType = dbBookingObj.getMaxRoomType();
		if(roomType > maxRoomType){
			
			errorMessage = 	errorMessage + "Incorrect room type ( max "+ maxRoomType + ") \n";
		}
		
		return errorMessage;
	}
	
	public String checkRatesNumber(int ratesNumber){
		
		DbBooking dbBookingObj = new DbBooking();
		int maxRatesNumber;
		
		maxRatesNumber = dbBookingObj.getMaxRatesNumber();
		if(ratesNumber > maxRatesNumber){
			
			errorMessage = 	errorMessage + "Incorrect rates number ( max "+ maxRatesNumber + ") \n";
		}
		
		return errorMessage;
	}
	
	public String checkNumberOfPeople(int numberOfPeople, int roomNumber){
		
		DbRoom dbRoomObj = new DbRoom();
		int maxNumberOfPeople;
		
		maxNumberOfPeople = dbRoomObj.getMaxCapacity(roomNumber);
		if(numberOfPeople > maxNumberOfPeople || numberOfPeople <= 0){
			
			errorMessage = 	errorMessage + "Incorrect number of people \n(max capacity of the room "+ maxNumberOfPeople + ") \n";
		}
		
		return errorMessage;
	}
	
	public String checkTypeName (String typeName){
		
		String exPattern;
		Pattern pattern;
		Matcher m;
		
		exPattern = "[^a-zA-Z]";
		pattern = Pattern.compile(exPattern);
		m = pattern.matcher(typeName);
		
		if(m.find()){
			
			errorMessage = errorMessage + "Incorrect Room type name\n";
		}
		
		return errorMessage;
	}
	
	public String checkDiscountPercent( int discountPercent){
		
		if(discountPercent < 0 || discountPercent > 100){
			
			errorMessage = errorMessage + "Incorect discount\n";
		}
		
		return errorMessage;
	}
	
	public String checkDiscountAmmount( float ammount){
		
		if(ammount < 0){
			
			errorMessage = errorMessage + "Incorect discount ammount\n";
		}
		
		return errorMessage;
	}
	
	public String checkDates(java.sql.Date bookedFrom, java.sql.Date bookedTill){
		
		Date currentDate = new Date();
		
		//Subtract 1 day to current date, to be able to book at that date
		currentDate.setTime(currentDate.getTime() - 1 * 24 * 60 * 60 * 1000);
		
		//Check if from is before till
		if(bookedFrom.compareTo(bookedTill) > 0){
			
			errorMessage = errorMessage + "Incorrect date input,\nensure that booked from is before booked till\n";
		}
		
		//Check if booked from is before current date
		if(currentDate.compareTo(bookedFrom) > 0){
			
			errorMessage = errorMessage + "Incorrect date input,\nensure that booking date is not bigger that current date\n";
		}
		
		return errorMessage;
	}
}
