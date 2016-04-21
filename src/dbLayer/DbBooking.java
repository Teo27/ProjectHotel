package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import modelLayer.MdlBooking;
import modelLayer.MdlCustomer;
import modelLayer.MdlRoom;

public class DbBooking {

	
	public DbBooking(){
		
	}
	
	public ResultSet refreshTableBooking(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Booking";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public MdlBooking selectFromTableBooking(String selectedId){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlBooking mdlBookObj = new MdlBooking();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from Booking where id = '"+ selectedId +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlBookObj.setId(rs.getInt("id"));
				mdlBookObj.setCustomerUsername(rs.getString("customer_username"));
				mdlBookObj.setEmployeeUsername(rs.getString("employee_username"));
				mdlBookObj.setBookedFrom(java.sql.Date.valueOf(rs.getString("booked_from")));
				mdlBookObj.setBookedTill(java.sql.Date.valueOf(rs.getString("booked_til")));
				mdlBookObj.setRoomNumber(Integer.parseInt(rs.getString("room_number")));
				mdlBookObj.setRoomType(rs.getString("room_type"));
				mdlBookObj.setRates(rs.getString("rates"));
				mdlBookObj.setNumberOfPeople(Integer.parseInt(rs.getString("number_of_people")));
				mdlBookObj.setDiscount(rs.getInt("discount"));
			}
			
			pst.close();
			return mdlBookObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		

	}
	
	public MdlRoom selectFromTableBookingRooms(String selectedRoomNumber){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlRoom mdlRoomObj = new MdlRoom();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from rooms where room_number = '"+ selectedRoomNumber +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlRoomObj.setRoomNumber(rs.getInt("room_number"));
			}
			
			pst.close();
			return mdlRoomObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		

	}
	
	public boolean insertBooking(MdlBooking mdlBookObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			
			query = "INSERT INTO Booking (customer_username, employee_username, booked_from, booked_til, room_number, room_type, rates, number_of_people, discount) VALUES(?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, mdlBookObj.getCustomerUsername());
			pst.setString(2, mdlBookObj.getEmployeeUsername());
			pst.setString(3, df.format(mdlBookObj.getBookedFrom()));
			pst.setString(4, df.format(mdlBookObj.getBookedTill()));
			pst.setString(5, Integer.toString(mdlBookObj.getRoomNumber()));
			pst.setString(6, mdlBookObj.getRoomType());
			pst.setString(7, mdlBookObj.getRates());
			pst.setString(8, Integer.toString(mdlBookObj.getNumberOfPeople()));
			pst.setInt(9, mdlBookObj.getDiscount());
			
			pst.execute();
			pst.close();
			success = true;
			
			return success;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return (Boolean) null;
		}
	}
	
	public boolean updateBooking(MdlBooking mdlBookObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "Update booking set customer_username = '"+ mdlBookObj.getCustomerUsername() +"' , employee_username= '"+ mdlBookObj.getEmployeeUsername()  +"', booked_from = '"+ mdlBookObj.getBookedFrom() +"' , booked_til= '"+ mdlBookObj.getBookedTill() +"' , room_number= '"+ mdlBookObj.getRoomNumber() +"' , room_type= '"+ mdlBookObj.getRoomType() +"' , rates = '"+ mdlBookObj.getRates() 
					+"' , number_of_people= '"+ mdlBookObj.getNumberOfPeople() +"' where id = '"+ mdlBookObj.getId() +"' ";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.execute();
			pst.close();
			success = true;
			
			return success;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return (Boolean) null;
		}
	}
	
	public boolean deleteBooking(int id){
		
		boolean success = false;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		
		try{
			
			query = "Delete from booking where id = '"+ id +"'";
			pst = connection.prepareStatement(query);
			
			pst.execute();
			pst.close();
			success = true;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return (Boolean) null;
		}
		
		return success;
	}
	
	public ResultSet searchBooking(String selection, String searchBooking){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		Statement  st;
		ResultSet rs;
				
	try{
				
			if(selection != "All_Checked_in"){
				query = "Select * from Booking where "+ selection +" LIKE '%"+searchBooking+"%' ";
				st = connection.createStatement();
				rs = st.executeQuery(query);
			}
			else{
				
				query = "select * from booking where checked_in is not null ";
				st = connection.createStatement();
				rs = st.executeQuery(query);
		
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		
		return rs;
	}
	
	public ResultSet searchOccupiedRooms(java.sql.Date bookedFrom, java.sql.Date bookedTill){
		
		Connection connection;
		ResultSet rs;
		PreparedStatement pst;
		String query;
		connection = DbConnection.DbConnector();
		
		try{
		
		
			query = "select room_number from booking where booked_til > ? AND booked_from < ?";
			pst = connection.prepareStatement(query);
			
			pst.setDate(1, bookedFrom);
			pst.setDate(2, bookedTill);
			rs = pst.executeQuery();
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
			return null;
		}
		
		return rs;
	}
	
	public boolean checkExistingCheckIn(int id){
		
		boolean exists = true;
		
		Connection connection;
		ResultSet rs;
		PreparedStatement pst;
		String query;
		connection = DbConnection.DbConnector();
		
		try{
			
			
			query = "select checked_in from booking where id = ?";
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				if(rs.getDate("checked_in") == null){
					exists = false;
				}
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
		
		return exists;
	}
	
	public java.sql.Date getCheckInDate(int id){
		
		java.sql.Date checkIn = null;
		
		Connection connection;
		ResultSet rs;
		PreparedStatement pst;
		String query;
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select checked_in from booking where id = ?";
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				checkIn = rs.getDate("checked_in");
			}
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
		
		return checkIn;
	}
	
	public void checkInCurrentDate(String currectDate, int id){
		
		Connection connection;
		PreparedStatement pst;
		String query;
		connection = DbConnection.DbConnector();
		
		try{
			
			
			query = "Update booking set checked_in = '"+ currectDate +"' where id = '"+ id +"'";
			pst = connection.prepareStatement(query);
			
			pst.execute();
		}
		catch(Exception e){
			
			System.out.println("Error while building the query");
		}
	}
	
	public boolean checkCustomerUsername(String customerUsername){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		boolean exists = false;
		
		try{
			
			query = "Select * from customer where username = ?";
			pst = connection.prepareStatement(query);
			
			pst.setString(1, customerUsername);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				exists = true;
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
		
		return exists;
	}
	
	public boolean checkEmployeeUsername(String employeeUsername){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		boolean exists = false;
		
		try{
			
			query = "Select * from employee where username = ?";
			pst = connection.prepareStatement(query);
			
			pst.setString(1, employeeUsername);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				exists = true;
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
		}
		
		return exists;
	}
	
	public int getMaxRoomType(){
		
		int roomType = 0;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		
		try{
			
			query = "Select max(type_number) from room_type";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				
				roomType =  ((Number) rs.getObject(1)).intValue();
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return 0;
		}
		
		return roomType;
	}
	
	public int getMaxRatesNumber(){
		
		int ratesNumber = 0;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		
		try{
			
			query = "Select max(number) from rates";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				
				ratesNumber =  ((Number) rs.getObject(1)).intValue();
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return 0;
		}
		
		return ratesNumber;
	}
	
}
