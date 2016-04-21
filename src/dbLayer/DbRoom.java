package dbLayer;


import java.sql.*;
import java.util.ArrayList;

import modelLayer.MdlCustomer;
import modelLayer.MdlEmployee;
import modelLayer.MdlRoom;

public class DbRoom {

	public DbRoom(){
		
	}
	
	public ResultSet refreshTableRoom(){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "Select * from Rooms";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
						
			return rs;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
	}
	
	public MdlRoom selectFromTableRoom(String selectedRoomNumber){
		
		Connection connection;
		String query;
		PreparedStatement pst;
		ResultSet rs;
		MdlRoom mdlRoomObj = new MdlRoom();
		
		connection = DbConnection.DbConnector();
		
		try{
			
			query = "select * from Rooms where room_number = '"+ selectedRoomNumber +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				mdlRoomObj.setRoomNumber(Integer.parseInt(rs.getString("room_number")));
				mdlRoomObj.setCapacity(Integer.parseInt(rs.getString("capacity")));
			}
			
			pst.close();
			return mdlRoomObj;
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		

	}
	
	public boolean insertRoom(MdlRoom mdlRoomObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "INSERT INTO Rooms (room_number, capacity) VALUES(?,?)";
			pst = connection.prepareStatement(query);
			success = false;
			
			pst.setString(1, Integer.toString(mdlRoomObj.getRoomNumber()));
			pst.setString(2, Integer.toString(mdlRoomObj.getCapacity()));
			
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
	
	public boolean updateRoom(MdlRoom mdlRoomObj){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		boolean success;
		
		try{
			
			query = "Update rooms set room_number = '"+ mdlRoomObj.getRoomNumber() + "', capacity = '"+ mdlRoomObj.getCapacity()  +"' where room_number = '"+ mdlRoomObj.getRoomNumber() +"' ";
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
	
	public boolean deleteRoom(int roomNumber){
		
		boolean success = false;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		
		try{
			
			query = "Delete from rooms where room_number = '"+ roomNumber +"'";
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
	
	public ResultSet searchRoom(String selection, String searchRoom){
		
		Connection connection = DbConnection.DbConnector();
		String query;
		Statement st;
		ResultSet rs;
				
	try{
					
			query = "Select * from rooms where "+ selection +" LIKE '%"+searchRoom+"%' ";
			st = connection.createStatement();
			rs = st.executeQuery(query);
			
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return null;
		}
		
		return rs;
	}
	
	public ResultSet searchFreeRooms(ArrayList<Integer> freeRooms){
		
		ResultSet rs;
		String query;
		PreparedStatement pst;
		Connection connection =  DbConnection.DbConnector();
		
		try{
			
			query = "select * from rooms where room_number = 0";
			
			for (int room : freeRooms) {
				
				query = query + "OR room_number = " + room;
			}
			
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
		}
		catch(Exception e){
			
			System.out.println("Error while executing the query");
			return null;
		}
		
		return rs;
	}
	
	public int getMaxRoomNumber(){
		
		int roomNumber = 0;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		
		try{
			
			query = "Select max(room_number) from rooms";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				
				roomNumber =  ((Number) rs.getObject(1)).intValue();
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return 0;
		}
		
		return roomNumber;
	}
	
	public int getMaxCapacity(int roomNumber){
		
		int capacity = 0;
		Connection connection = DbConnection.DbConnector();
		String query;
		PreparedStatement  pst;
		ResultSet rs;
		
		try{
			
			query = "Select capacity from rooms where room_number = '"+ roomNumber +"'";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				
				capacity =  ((Number) rs.getObject(1)).intValue();
			}
		
		}
		catch(Exception e){
			
			System.out.println("Error while building the Query");
			return 0;
		}
		
		return capacity;
	}
}
