package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelLayer.MdlArchive;
import modelLayer.MdlCustomer;

public class DbArchive {

	public DbArchive(){
		
	}
	
	public ResultSet refreshTableArchive(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Archive";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public boolean insertArchive(MdlArchive mdlArchObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "INSERT INTO archive (name, surname, country, city, street, zip_code, contact, booked_from, booked_til, checked_in, checked_out, room_number) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, mdlArchObj.getName());
			pst.setString(2, mdlArchObj.getSurname());
			pst.setString(3, mdlArchObj.getCountry());
			pst.setString(4, mdlArchObj.getCity());
			pst.setString(5, mdlArchObj.getStreet());
			pst.setString(6, mdlArchObj.getZipCode());
			pst.setString(7, mdlArchObj.getContact());
			pst.setDate(8, mdlArchObj.getBookedFrom());
			pst.setDate(9, mdlArchObj.getBookedTill());
			pst.setDate(10, mdlArchObj.getCheckedIn());
			pst.setDate(11, mdlArchObj.getCheckedOut());
			pst.setInt(12,  mdlArchObj.getRoomNumber());
			
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
	
	public ResultSet searchArchive(String selection, String searchArchive){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		Statement  st;
		ResultSet rs;
				
	try{
		
			query = "Select * from archive where "+ selection +" LIKE '%"+searchArchive+"%' ";
			st = connection.createStatement();
			rs = st.executeQuery(query);

		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		
		return rs;
	}
	
	public ResultSet getOccupancy(int year, int roomNumber){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		try{
			
			query = "Select * from archive where room_number = "+ roomNumber +" AND (booked_from >=  '"+ year + "-01-01" +"' OR checked_out <=  '"+ year + "-12-31" +"')";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();

		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		
		return rs;
	}
}
