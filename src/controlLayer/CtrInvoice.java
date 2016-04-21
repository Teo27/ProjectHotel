package controlLayer;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import modelLayer.MdlCustomer;
import modelLayer.MdlInvoice;
import modelLayer.MdlRates;
import dbLayer.DbCustomer;
import dbLayer.DbInvoice;
import dbLayer.DbRates;
import dbLayer.DbRoomType;

public class CtrInvoice {

	
	public CtrInvoice(){
		
	}
	
	public ResultSet refreshTableInvoice(){
		
		ResultSet rs;
		DbInvoice dbInvObj = new DbInvoice();
		
		rs = dbInvObj.refreshTableInvoice();

		return rs;
	}
	
	public MdlInvoice selectFromTableInvoice(String selectedId){
		
		DbInvoice dbInvObj = new DbInvoice();
		MdlInvoice mdlInvObj = new MdlInvoice();
		
		mdlInvObj = dbInvObj.selectFromTableInvoice(selectedId);
		
		return mdlInvObj;
	}
	
	public String CustomerInfoToString(String name, String surname, String country, String city, String street, String zipCode, String contact, String customerType){
		
		String textCustomerInfo;
		
		String space = "          ";
		String largeSpace = "                  ";
		String textTitle = "     HOTEL INVOICE\n\n";
		String textName = 	 "\n Name:     " + space + name;
		String textSurname = "\n Surname:" + space + surname;
		String textAddress = "\n Address: "+ space + street + "\n " + largeSpace + space + city + zipCode + "\n " + largeSpace + space + country;  
		String textCustomerType = "\n\n Type:" + largeSpace + customerType;
		String textContact = "\n Contact:   " + space + contact;
		
		textCustomerInfo = textTitle + textName + textSurname + textAddress + textCustomerType + textContact;

		
		return textCustomerInfo;
	}
	
	public String BookingInfoToString(java.sql.Date bookedFrom, java.sql.Date bookedTill, java.sql.Date checkedIn, java.sql.Date checkedOut, String roomNumber, String roomType, String rates, int numberOfPeople, int days){
		
		String textBookingInfo = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String bookedFromString = df.format(bookedFrom);
		String bookedTillString = df.format(bookedTill);
		String checkedInString = df.format(checkedIn);
		String checkedOutString = df.format(checkedOut);
		
		String space = "          ";
		String largeSpace = "                  ";
		String textBookedFrom = "\n\n\n Booked from:   "+ bookedFromString + largeSpace + largeSpace;
		String textBookedTill = "\n Booked till:       "  + bookedTillString + largeSpace + largeSpace;
		String textCheckedIn =  "\n Checked in:     "  + checkedInString + largeSpace + largeSpace;
		String textCheckedOut = "\n Checked out:   "  + checkedOutString + largeSpace + largeSpace;
		String textNumberOfDays = "\n Days:" + largeSpace + days;
		
		String textRoomNumber =  "Room number:  " + largeSpace + roomNumber;
		String textRoomType = "Room type:         " + largeSpace + roomType;
		String textRates = "Rates:" + largeSpace + largeSpace + rates;
		String textNumberOfPeople = "Number of people:    " + space + numberOfPeople;
		
		textBookingInfo = textBookedFrom + textRoomNumber + textBookedTill + textRoomType + textCheckedIn + textRates + textCheckedOut + textNumberOfPeople + textNumberOfDays;
		
		return textBookingInfo;
	}
	
	public String ChargesInfoString(int roomCapacity,float roomTypePrice, boolean breakfast, boolean lunch, boolean dinner, int numberOfDays, int discount, float discountAmmount){
		
		String textChargesInfo = "";
		float balance = 0;
		float roomCharge;
		float ratesCharge;
		float daysCharge;
				
		String space = "          ";
		String largeSpace = "                  ";
		String textHead = "\n\n\n\n" + space + "Description" + largeSpace + largeSpace + largeSpace + "Charges" + space + "   " + "Balance";
		
		roomCharge = calculateRoomCharge(roomCapacity, roomTypePrice);
		balance = roomCharge;
		
		String textRoomCharge = "\n\n" + space + "ROOM           " + largeSpace + largeSpace + largeSpace + roomCharge + largeSpace + balance;
		
		ratesCharge = calculateRatesCharge(breakfast, lunch ,dinner);
		balance += ratesCharge;
				
		String textRatesCharge = "\n" + space + "RATES          " + largeSpace + largeSpace + largeSpace + ratesCharge + largeSpace + "  " + balance;
		
		daysCharge = balance * numberOfDays;
		balance = daysCharge;
		
		String textDaysCharge = "\n" + space + "DAYS (" + numberOfDays + ")         "  + largeSpace + largeSpace + largeSpace + " -       "  + largeSpace + balance; 
		
		String textTotal;
		String textDiscount;
		
		if(discountAmmount != 0){
			balance = calculateDiscountAmmount(balance, discountAmmount);
			
			textDiscount = "\n" + space + "DISCOUNT      "  + largeSpace + largeSpace + largeSpace + discountAmmount  + largeSpace + "       " +  balance;
			textTotal = "\n\n\n" + largeSpace + largeSpace + largeSpace + largeSpace + "TOTAL          " + largeSpace + balance;
		}
		else if(discount != 0){
			
			balance = calculateDiscount(balance, discount);
			
			 textDiscount = "\n" + space + "DISCOUNT      "  + largeSpace + largeSpace + largeSpace + discount + "%"  + largeSpace + "       " +  balance;
			 textTotal = "\n\n\n" + largeSpace + largeSpace + largeSpace + largeSpace + "TOTAL          " + largeSpace + balance;
		}
		else{
			
			 textDiscount = "\n" + space + "DISCOUNT      "  + largeSpace + largeSpace + largeSpace + 0  + largeSpace + "       " +  balance;
			 textTotal = "\n\n\n" + largeSpace + largeSpace + largeSpace + largeSpace + "TOTAL          " + largeSpace + balance;
		}
		
		textChargesInfo = textHead + textRoomCharge + textRatesCharge + textDaysCharge + textDiscount + textTotal + "\n\n\n";
		
		
		return textChargesInfo;
	}
	
	public float calculateDiscount(float balance, int discount){
		
		float total = 0;
		
		total = balance - ( (balance / 100) * discount );
		
		return total;
	}
	
	public float calculateDiscountAmmount(float balance, float discount){
		
		float total = 0;
		
		total = balance - discount ;
		
		return total;
	}
	
	public float calculateRoomCharge(int roomCapacity,float roomTypePrice){
		
		float total = 0;
		
		total = roomTypePrice;
				
		return total;
	}
	
	public float calculateRatesCharge(boolean breakfast, boolean lunch, boolean dinner){
		
		float total = 0;
		
		if(breakfast == true){
			
			total += 50;
		}
		
		if(lunch == true){
			
			total += 150;
		}
		
		if(dinner == true){
			
			total += 200;
		}
		
		return total;
	}
	
	public float calculatetTotal(float roomTypePrice, boolean breakfast, boolean lunch, boolean dinner, int days, int discount){
		
		float total = 0;
		
		total = roomTypePrice;
		if(breakfast == true){
			
			total += 50;
		}
		
		if(lunch == true){
			
			total += 150;
		}
		
		if(dinner == true){
			
			total += 200;
		}
		
		
		total = total * days;
		
		total = total - ((total / 100) * discount);
		
		return total;
	}
	
	public float calculatetTotalAmmount(float roomTypePrice, boolean breakfast, boolean lunch, boolean dinner, int days, float discountAmount){
		
		float total = 0;
		
		total = roomTypePrice;
		if(breakfast == true){
			
			total += 50;
		}
		
		if(lunch == true){
			
			total += 150;
		}
		
		if(dinner == true){
			
			total += 200;
		}
		
		total = total * days;
		
		total = total - discountAmount;
		
		return total;
	
	}
	
	public int numberOfDays(java.sql.Date bookedFrom, java.sql.Date checkedOut){
		
		int days;
		
		 days = (int) (checkedOut.getTime() - bookedFrom.getTime()) / (1000 * 60 * 60 * 24);
		
		return days;
	}
	
	//TABLE
	
	public ResultSet lastUpdated(){
		
		ResultSet rs;
		DbInvoice dbInvObj = new DbInvoice();
		
		rs = dbInvObj.lastUpdated();

		return rs;
	}
	
	public boolean addInvoice(String name, String surname, String employee, float price, String paymentType, String paymentDeadline, boolean paid, boolean paymentOverdue){
		
		MdlInvoice mdlInvObj = new MdlInvoice();
		DbInvoice dbInvObj = new DbInvoice();
		 
		boolean success = false;

		
		mdlInvObj.setName(name); 
		mdlInvObj.setSurname(surname);
		mdlInvObj.setEmployee(employee);
		mdlInvObj.setPrice(price);
		mdlInvObj.setPaymentType(paymentType);
		mdlInvObj.setPaymentDeadline(paymentDeadline);
		mdlInvObj.isPaid();
		mdlInvObj.isPaymentOverdue();
	
		try{
			
			success = dbInvObj.insertInvoice(mdlInvObj);
		}
		catch(Exception e){
			
			System.out.println("Error while creating an Invoice");
		}
		
		return success;
	}
	
	
	public boolean updatePaymentType(String paymentType, int id, boolean paid){
		
		boolean success = false;
		DbInvoice dbInvObj = new DbInvoice();
		MdlInvoice mdlInvObj = new MdlInvoice();
		String paymentDeadline;
		
		paymentDeadline = setPaymentDeadline(paymentType);
		
		mdlInvObj.setId(id);
		
		if(paid == true){
			
			mdlInvObj.setPaid(paid);
			dbInvObj.updatePaid(mdlInvObj);
		}
				
		mdlInvObj.setPaymentType(paymentType);
		mdlInvObj.setPaymentDeadline(paymentDeadline);

		
		dbInvObj.updatePaymentType(mdlInvObj);
		success = dbInvObj.updatePaymentDeadline(mdlInvObj);
		
		
		return success;
	}
	
	public boolean updatePaid(boolean paid, int id){
		
		boolean success = false;
		DbInvoice dbInvObj = new DbInvoice();
		MdlInvoice mdlInvObj = new MdlInvoice();
		
		mdlInvObj.setId(id);
		mdlInvObj.setPaid(paid);
		
		success = dbInvObj.updatePaid(mdlInvObj);
		
		return success;
	}
	
	public boolean updatePaymentOverdue(boolean paymentOverdue, int id){
		
		boolean success = false;
		DbInvoice dbInvObj = new DbInvoice();
		MdlInvoice mdlInvObj = new MdlInvoice();
		
		mdlInvObj.setId(id);
		mdlInvObj.setPaymentOverdue(paymentOverdue);
		
		success = dbInvObj.updatePaymentOverdue(mdlInvObj);
		
		return success;
	}
	
	public boolean updatePrice(float price, int id){
		
		boolean success = false;
		DbInvoice dbInvObj = new DbInvoice();
		MdlInvoice mdlInvObj = new MdlInvoice();
		
		mdlInvObj.setId(id);
		mdlInvObj.setPrice(price);
		
		success = dbInvObj.updatePrice(mdlInvObj);
		
		return success;
	}
	
	public String setPaymentDeadline(String paymentType){
		
		String paymentDeadline= "";
		
		switch(paymentType){
		
		case "Business Voucher" :{ paymentDeadline = "End of the month"; break;}
		case "Advance":{paymentDeadline = "Paid in front";break;}
		default:{paymentDeadline = "On spot";break;}
		}
		
		return paymentDeadline;
	}
	
	public void deleteInvoice(){
		
		DbInvoice dbInvObj = new DbInvoice();
		ResultSet rs;
		int id = -1;
		
		try{
			
			rs = lastUpdated();
			while(rs.next()){
				
				id = rs.getInt("id");
			}
			
			dbInvObj.deleteInvoice(id);
		}
		catch(Exception e){
			
			System.out.println("Error while deleting an Invoice");
		}
	}
	
	public ResultSet searchInvoice(String selection, String searchInvoice){
		
		DbInvoice dbInvObj = new DbInvoice();
		ResultSet rs;
		
		try{
			
			rs = dbInvObj.searchInvoice(selection, searchInvoice);
		}
		catch(Exception e){
			
			System.out.println("Error while searching an Invoice.");
			return null;
		}
		
		return rs;
	}
}
